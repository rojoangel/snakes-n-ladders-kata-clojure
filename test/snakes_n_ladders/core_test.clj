(ns snakes-n-ladders.core-test
  (:require [clojure.test :refer :all]
            [snakes-n-ladders.core :refer :all]))

(defn new-game []
  {})

(defn place-token [game]
  1)

(defn move-token [game spaces]
  4)

(deftest moving-your-token
  (testing "When the token is placed on the board then the token is on square 1"
    (let [game (new-game)]
      (is (= 1 (place-token game)))))
  (testing "Given the token is on square 1 when the token is moved 3 spaces then the token is on square 4"
    (let [game (place-token (new-game))]
      (is (= 4 (move-token game 3))))))
