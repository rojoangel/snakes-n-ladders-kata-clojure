(ns snakes-n-ladders.core-test
  (:require [clojure.test :refer :all]
            [snakes-n-ladders.core :refer :all]))

(defn new-game []
  {})

(defn place-token [game]
  (assoc game :token 1))

(defn move-token [game spaces]
  (update game :token #(+ % spaces)))

(defn current-token [game]
  (:token game))

(deftest moving-your-token
  (testing "When the token is placed on the board then the token is on square 1"
    (-> (new-game)
        (place-token)
        (current-token)
        (= 1)
        (is)))
  (testing "Given the token is on square 1 when the token is moved 3 spaces then the token is on square 4"
    (-> (new-game)
        (place-token)
        (move-token 3)
        (current-token)
        (= 4)
        (is)))
  (testing "Given the token is on square 1 when the token is moved 3 spaces And then it is moved 4 spaces Then the token is on square 8"
    (-> (new-game)
        (place-token)
        (move-token 3)
        (move-token 4)
        (current-token)
        (= 8)
        (is))))
