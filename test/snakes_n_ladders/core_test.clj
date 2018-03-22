(ns snakes-n-ladders.core-test
  (:require [clojure.test :refer :all]
            [snakes-n-ladders.core :refer :all]
            [snakes-n-ladders.dice :as dice]
            [clojure.spec.alpha :as s]))

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
      (do (s/def ::dice-roll (dice/roll-spec :min 1 :max 6))
          (is (not (s/valid? ::dice-roll 0)))
          (is (s/valid? ::dice-roll 1))
          (is (s/valid? ::dice-roll 2))
          (is (s/valid? ::dice-roll 3))
          (is (s/valid? ::dice-roll 4))
          (is (s/valid? ::dice-roll 5))
          (is (s/valid? ::dice-roll 6))
          (is (not (s/valid? ::dice-roll 7)))))
    (testing "Given the player rolls a 4 when they move their token then the token should move 4 spaces"
      (let [always-rolls-4-fn (fn [] 4)]
        (-> (new-game :rolling-fn always-rolls-4-fn)
            (place-token)
            (roll-dice)
            (move-token)
            (current-token)
            (= 5)
            (is))))))