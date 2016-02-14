(ns neuegaf-1up.thread
  (:require [khroma.runtime :as runtime]
            [khroma.log :as console]
            [cljs.core.async :refer [>! <!]]
            [dommy.core :refer-macros [sel sel1] :refer [append!]]
            )
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn reverse-posts []
  (let [posts (reverse (sel "#posts > div"))]
    (apply append! (sel1 "#posts") posts)
    ))

  (defn init []
    (console/log "This is thread.")
    (reverse-posts))
