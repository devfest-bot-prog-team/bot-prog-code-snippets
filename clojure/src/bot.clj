(ns bot
  (:require
    [clj-http.client :as client]
    [clojure.data.json :as json]))


(defn parse-maze
  [maze-string]
  (let [rows (clojure.string/split maze-string #"\n")]
    (mapv (fn [row] (mapv (fn [cell] cell) row)) rows)))


(comment
  (json/read-str (:body (client/get "https://bot-api.devfestantananarivo.com/api/start_stage/contest-0-stage-3"
                                    {:headers {:Authorization "PLEASE CHANGE WITH API TOKEN"}
                                     :accept :json}))
                 :key-fn keyword))


(comment
  (json/read-str (:body
                  (client/post "https://bot-api.devfestantananarivo.com/api/execute_steps"
                               {:headers {:Authorization "PLEASE CHANGE WITH API TOKEN"}
                                :accept :json
                                :body (json/write-str {:steps "UDRL" :stageContestID "contest-0-stage-3"})}))
                 :key-fn keyword))
