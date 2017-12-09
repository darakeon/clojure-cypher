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

(defn to-char
  "takes a lowercase letter character and returns its position in the alphabet: a = 0, b = 1, etc."
  [number]
  (let [ascii-a (int \a)]
    (if (or(< number 0)(> number 25))
      "Hey, listen!"
      (char (+ number ascii-a))
      )
    )
  )

(defn shift
  [letter-char key]
  (let [number (to-int letter-char)]
    (let [ciphered (+ number key)]
      (to-char (mod ciphered 26))
      )
    )
  )

(defn caesar-encrypt
  [text key]
  (apply str (mapv #(shift % key) text))
)
