(ns snakes-n-ladders.core
  (:require [snakes-n-ladders.dice :as dice]))

(defn new-game [& {:keys [rolling-fn max-squares]
                   :or   {rolling-fn dice/roll
                          max-squares 100}}]
  (-> {}
      (assoc :rolling-fn rolling-fn)
      (assoc :max-squares max-squares)))

(defn place-token [game]
  (assoc game :token 1))

(defn roll-dice [game]
  (assoc game :dice ((:rolling-fn game))))

(defn move-token
  ([game]
   (move-token game (:dice game)))
  ([game spaces]
   (let [square-to-move-to (+ (:token game) spaces)]
     (if (not (> square-to-move-to (:max-squares game)))
       (assoc game :token square-to-move-to)
       game))))

(defn current-token [game]
  (:token game))

(defn winner? [game]
  (= 100 (:token game)))
