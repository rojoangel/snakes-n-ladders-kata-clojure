(ns snakes-n-ladders.core-test
  (:require [clojure.test :refer :all]
            [snakes-n-ladders.core :refer :all]
            [clojure.spec.alpha :as s]))

(defn dice-spec [& {:keys [min max]}]
  (s/int-in min (inc max)))

(deftest moving-your-token
  (testing "Token can move accross the board"
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
  (testing "Moves are determined by dice rolls"
    (testing "When the player rolls a dice then the result should be between 1-6 inclusive"
      (do (s/def ::dice-roll (dice-spec :min 1 :max 6))
        (is (not (s/valid? ::dice-roll 0)))
        (is (s/valid? ::dice-roll 1))
        (is (s/valid? ::dice-roll 2))
        (is (s/valid? ::dice-roll 3))
        (is (s/valid? ::dice-roll 4))
        (is (s/valid? ::dice-roll 5))
        (is (s/valid? ::dice-roll 6))
        (is (not (s/valid? ::dice-roll 7)))))))