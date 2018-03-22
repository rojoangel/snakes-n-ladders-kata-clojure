(ns snakes-n-ladders.dice
  (:require [clojure.spec.alpha :as s]
            [clojure.spec.gen.alpha :as gen]))

(defn roll-spec [& {:keys [min max]}]
  (s/int-in min (inc max)))

(s/def ::roll (roll-spec :min 1 :max 6))

(defn roll []
  (gen/generate (s/gen ::roll)))
