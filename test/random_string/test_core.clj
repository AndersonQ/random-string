(ns random-string.test-core
  (:require [random-string.core :as r])
  (:use clojure.test))

(defn hex-color? [colour]
  (and (re-matches #"#[0123456789abcdef]{6}" colour)
       (== (count colour) 7)))

(deftest random-string-default-exhaustive-test
    (is (empty?
          (filter #(not= 26 %1)
                  (take 1000 (repeatedly #(count (str (r/string)))))))))

(deftest random-string-length-5-exhaustive-test
    (is (empty?
          (filter #(not= 5 %1)
                  (take 1000 (repeatedly #(count (str (r/string 5)))))))))

(deftest random-hex-color-test
  (let [s (r/hex-color)]
    (is (re-matches #"#[0123456789abcdef]{6}" s))
    (is (== (count s) 7))))

(deftest random-hex-color-exhaustive-test
  (is (true?
        (reduce #(and %1 %2)
                (take 1000 (repeatedly #(hex-color? (r/hex-color))))))))

(run-tests)
