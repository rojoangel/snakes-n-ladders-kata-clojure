(ns snakes-n-ladders.core-test
  (:require [clojure.test :refer :all]
            [snakes-n-ladders.core :refer :all]))

(defn new-game []
  {})

(defn place-token [game]
  1)

(deftest moving-your-token
  (testing "When the token is placed on the board then the token is on square 1"
    (let [game (new-game)]
      (is (= 1 (place-token game))))))
