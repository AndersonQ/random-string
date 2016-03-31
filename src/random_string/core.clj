(ns random-string.core
  "Generate cryptographically secure random strings using Java's SecureRandom"
  (:require [clojure.string :as string])
  (:import java.security.SecureRandom
           java.math.BigInteger))

(def random (SecureRandom.))

(defn string
  ([] (string 26 32))
  ([len] (string len 32))
  ([len radix] (let [s (.toString (BigInteger. (* 5 len) random) radix)]
                  (if (== (count s) len)
                    s
                    (string len radix)))))

(defn hex-color []
  (let [s (string 6 16)]
    (if (== (count s) 6)
      (str "#" s)
      (hex-color))))
