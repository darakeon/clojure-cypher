(ns cipher.core-test
  (:require [clojure.test :refer :all]
            [cipher.core :as core]
            [midje.sweet :refer :all]))

(fact "this will fail"
      2 => 2)

(facts "takes a lowercase letter character and returns its position in the alphabet: a = 0, b = 1, etc"
       (fact "character a is the first letter, in position 0"
             (core/to-int \a) => 0)
       (fact "character b is the second letter, in position 1"
             (core/to-int \b) => 1)

       (tabular
         (core/to-int ?char) => ?result
         ?char ?result
         \a 0
         \b 1
         \c 2
         \d 3)
       )
