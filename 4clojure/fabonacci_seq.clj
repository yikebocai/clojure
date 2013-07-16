;; yikebocai's solution to Fibonacci Sequence
;; https://4clojure.com/problem/26

(fn [cnt]
  (loop [s [] i 0]
    (if (< i cnt)
      (recur
        (let [c (count s)
              lst (last s)
              scd (if (> c 1) (nth s (- c 2)) 0)]
          (if (= i 0)
            (conj s 1)
            (conj s (+ lst scd))))
        (inc i))
      s)))
