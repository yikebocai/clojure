;; yikebocai's solution to Count a Sequence
;; https://4clojure.com/problem/22

(fn [s]
  (loop [s2 []
         i 0]
    (if (= s2 (seq s)) i (recur (conj s2 (nth (seq s) i)) (inc i)))))
