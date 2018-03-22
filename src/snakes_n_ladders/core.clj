(ns snakes-n-ladders.core)

(defn new-game
  ([]
   {})
  ([& {:keys [rolling-fn]}]
   (-> {}
       (assoc :rolling-fn rolling-fn))))

(defn place-token [game]
  (assoc game :token 1))

(defn roll-dice [game]
  (assoc game :dice ((:rolling-fn game))))

(defn move-token
  ([game]
    (update game :token #(+ % (:dice game))))
  ([game spaces]
   (update game :token #(+ % spaces))))

(defn current-token [game]
  (:token game))
