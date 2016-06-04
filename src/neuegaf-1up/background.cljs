(ns neuegaf-1up.background
  (:require
            [khroma.log :as console]
            [khroma.runtime :as runtime]))

(defn init []
  (console/log "This is background")

  (let [
        request js/chrome.declarativeWebRequest
        ; matching
        matcher #js {:url #js {:hostSuffix ".neogaf.com"} :stages #js ["onBeforeRequest" "onBeforeSendHeaders"]}
        condition (new request.RequestMatcher matcher)
        ; action1: fake mobile device
        iphone-agent "Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1"
        fake-ua (new request.SetRequestHeader #js {:name "User-Agent" :value iphone-agent})
        ; acion2: move to mobile site
        redirect-from "^(https?)://www.neogaf.com/forum/(.*)$"
        redirect-to   "$1://m.neogaf.com/$2"
        redirect-mobile (new request.RedirectByRegEx #js {:from redirect-from :to redirect-to})
        rule #js {:conditions #js [condition] :actions #js [fake-ua redirect-mobile]}]
    (.addRules request.onRequest #js [rule])))








