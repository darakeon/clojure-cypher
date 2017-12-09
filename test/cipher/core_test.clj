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

(facts "takes a number and returns the letter by position in the alphabet: 0 = a, 1 = b, etc"
       (fact "position 0 returns a"
             (core/to-char 0) => \a)
       )

(facts "cipher a letter"
       (tabular
         (core/shift ?char ?key) => ?result
         ?char ?key ?result
         \a 3 \d
         \z 1 \a)
       )

(facts "cipher a text"
       (tabular
         (core/caesar-encrypt ?char ?key) => ?result
         ?char ?key ?result
         "abc" 7 "hij"
         "apple" 20 "ujjfy"
         "Hello, friend!" 5 "mjqqtkwnjsi"
         )
       )

(facts "decipher a text"
       (tabular
         (core/caesar-decrypt ?text ?key) => ?result
         ?text ?key ?result
         "hij" 7 "abc"
         "ujjfy" 20 "apple"
         "gtxyts" 5 "boston"
         "mvytebolbsnqo" 10 "clojurebridge"
         )
       )

(fact "remove non-letter characters and make it lowercase"
      (core/get-letters "Hello, friend!") => "hellofriend"
      )

(fact "count letters"
      (core/count-letters \a "aadvark") => 3
      )
