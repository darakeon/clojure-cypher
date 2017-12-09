(ns cipher.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn to-int
  "takes a lowercase letter character and returns its position in the alphabet: a = 0, b = 1, etc."
  [letter-char]
  (let [ascii-a (int \a)]
    (- (int letter-char) ascii-a)))
