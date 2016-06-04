(ns neuegaf-1up.thread
  (:require
            [khroma.log :as console]
            [khroma.runtime :as runtime]
            [dommy.core :refer-macros [sel sel1] :refer [append!]]))

(defn reverse-posts []
  (let [posts (reverse (sel "#posts > div"))]
    (apply append! (sel1 "#posts") posts)
    ))

  (defn init []
    (console/log "This is thread.")
    (reverse-posts))
