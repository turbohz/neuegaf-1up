(ns neuegaf-1up.thread
  (:require
            [khroma.log :as console]
            [khroma.runtime :as runtime]
            [dommy.core :as dommy :refer-macros [sel sel1]]))

(defn reverse-posts []
  (let [posts (sel ".post")]
    (apply dommy.core/prepend! (sel1 "#newposts") posts)))

(defn fix-width []
  (let [
        body (sel1 "body#forum")
        children (dommy.utils/->Array (dommy.core/children body))
        wrapper (dommy/create-element :div)]
    (dommy/set-attr! wrapper "id" "wrapper")
    (dommy/append! body wrapper)
    (console/log children)
    (apply dommy/append! wrapper (js->clj children))
    (dommy/set-style! wrapper :width "50%")))

(defn init []
  (console/log "This is thread.")
  (fix-width)
  (reverse-posts))



