(ns fetch.remotes
  (:require [fetch.core :as core]
            [cljs.reader :as reader]))

(def remote-uri "/pinotremotecall")

(defn remote-callback [remote params callback]
  (core/xhr [:post remote-uri] 
            {:remote remote
             :params (pr-str params)}
            (when callback
              (fn [data]
                (callback (reader/read-string data))))))
