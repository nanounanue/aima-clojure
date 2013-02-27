(ns aima-clojure.games.tic-tac-toe-test
  (:use aima-clojure.games.tic-tac-toe
        aima-clojure.game
        clojure.test))

(deftest tic-tac-toe-test
  (testing "make-move"
    (is (= (make-move (tic-tac-toe)
                      {:to-move :o
                       :board [[:e :e :e]
                               [:o :o :e]
                               [:x :x :e]]
                       :utility 0}
                      [1 2])
           {:to-move :x
            :board [[:e :e :e]
                    [:o :o :o]
                    [:x :x :e]]
            :utility -1}))
    (is (= (make-move (tic-tac-toe)
                      {:to-move :x
                       :board [[:e :e :e]
                               [:o :o :e]
                               [:x :x :e]]
                       :utility 0}
                      [2 2])
           {:to-move :o
            :board [[:e :e :e]
                    [:o :o :e]
                    [:x :x :x]]
            :utility 1}))
    
    )
  
  (testing "minimax"
    (is (= (minimax-decision (tic-tac-toe)
                             {:to-move :x
                              :board [[:x :e :e]
                                      [:o :o :e]
                                      [:x :e :e]]
                              :utility 0
                              })
           [1 2]))
    ;; (is (= (minimax-decision (tic-tac-toe)
    ;;                          {:to-move :x
    ;;                           :board [[:o :e :x]
    ;;                                   [:e :x :e]
    ;;                                   [:e :x :e]]
    ;;                           :utility 0})
    ;;        [0 1]))
    (is (= (minimax-decision (tic-tac-toe)
                             {:to-move :o
                              :board [[:x :x :o]
                                      [:e :o :x]
                                      [:e :o :x]]
                              :utility 0})
           [2 0]))
    (is (= (minimax-decision (tic-tac-toe)
                             {:to-move :o
                              :board [[:o :e :o]
                                      [:x :x :o]
                                      [:x :e :x]]
                              :utility 0})
           [0 1]))
    ))
  

(def pos (make-move (tic-tac-toe)
                    {:to-move :o
                     :board [[:o :e :o]
                             [:x :x :o]
                             [:x :e :x]]
                     :utility 0}
                    [0 1]))

(utility (tic-tac-toe) pos :x)
        
                             
