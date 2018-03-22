(ns snakes-n-ladders.core)

(defn new-game []
  {})

(defn place-token [game]
  (assoc game :token 1))

(defn move-token [game spaces]
  (update game :token #(+ % spaces)))

(defn current-token [game]
  (:token game))
