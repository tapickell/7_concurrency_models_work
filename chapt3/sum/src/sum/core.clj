(ns sum.core
  (:gen-class)
  (:require [clojure.core.reducers :as r]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn recursive-sum 
  "recursive-sum function"
  [numbers]
  (if (empty? numbers)
    0
    (+ (first numbers) (recursive-sum (rest numbers)))))

(defn reduce-sum 
  "reduce-sum function"
  [numbers]
  (reduce (fn [acc, x] (+ acc x)) 0 numbers))

(defn sum 
  "sum function"
  [numbers]
  (reduce + numbers))

(defn apply-sum 
  "apply-sum function"
  [numbers]
  (apply + numbers))

(defn parallel-sum 
  "paralell-sum function"
  [numbers]
  (r/fold + numbers))
