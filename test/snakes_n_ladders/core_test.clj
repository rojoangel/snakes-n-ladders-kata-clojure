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
    (let [game (new-game)]
      (is (= 1 (current-token (place-token game))))))
  (testing "Given the token is on square 1 when the token is moved 3 spaces then the token is on square 4"
    (let [game (place-token (new-game))]
      (is (= 4 (current-token (move-token game 3))))))
  (testing "Given the token is on square 1 when the token is moved 3 spaces And then it is moved 4 spaces Then the token is on square 8"
    (let [game (place-token (new-game))]
      (is (= 8 (current-token (move-token (move-token game 3) 4)))))))
