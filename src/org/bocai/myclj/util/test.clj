((fn [s] (let [rv (reverse (vec s))
              cnt (/ (count rv) 2)
              s1 (take cnt (vec s))
              s2 (take cnt rv)]
          (= s1 s2 )) )  '(1 2 3 2 1))

