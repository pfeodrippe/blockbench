(ns main
  (:require
   [cljs.pprint :as pp]))

;; Connecting to the REPL
;; - Jack-in into the CLJS repl
;; - npm run bundle && npm run dev
;; Now the REPL should be running!!

(defn main
  []
  (+ 1 13))

(defn -d
  [arg]
  (js/console.log arg))

(declare c)
#_(defonce c (.init (js/Cube.)))

(comment

  (js/Undo.initEdit (clj->js {:elements []}))

  (doseq [_ (range 10)]
    (let [c (.init (js/Cube.))]
      (set! (.-from c) (clj->js [(rand-int 100) (rand-int 100) (rand-int 100)]))
      (set! (.-to c) (clj->js [(rand-int 100) (rand-int 100) (rand-int 100)]))
      (js/Canvas.updateView
       (clj->js {:elements [c]
                 :elements_aspects {:geometry true}
                 :selection true}))))

  (js/Undo.finishEdit "Hunnn, we did something for sure..."
                      (clj->js {:elements [c]}))

  ())

(comment

  ;; Blockbench API
  ;; https://www.blockbench.net/wiki/docs/blockbench

  ;; Blockbench plugins (for API reference)
  ;; https://github.com/JannisX11/blockbench-plugins/tree/master

  (.-version js/Blockbench)
  (-d js/BARS)
  (js/getCurrentGroup)

  (def c (.init (js/Cube.)))
  (-d c)
  (set! (.-selected c) false)
  (-d (.-from c))
  (set! (.-from c) #js [-2 -2 -2])
  (set! (.-to c) #js [4 4 4])

  (js/Canvas.updateView
   (clj->js {:elements [c]
             :elements_aspects {:geometry true}
             :selection true}))
  js/Undo


  (js/console.log (js/Cube.selected))
  (js/console.log js/Texture.selected.id)

  ())
