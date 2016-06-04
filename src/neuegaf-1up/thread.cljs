(ns neuegaf-1up.thread
  (:require
            [khroma.log :as console]
            [khroma.runtime :as runtime]
            [dommy.core :refer-macros [sel sel1] :refer [prepend!]]))

(defn reverse-posts []
  (let [posts (sel ".post")]
    (apply prepend! (sel1 "#newposts") posts)))

(defn init []
  (console/log "This is thread.")
  (reverse-posts))
