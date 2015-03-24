(ns pong.core
  (:require [play-clj.core :refer :all]
            [play-clj.g2d :refer :all]))

(use 'play-clj.repl)
(declare pong main-screen)

(def game-center-x 240)
(def game-center-y 320)

(defscreen main-screen
  :on-show
  (fn [screen entities]
    (update! screen :renderer (stage))
    (let [background (assoc (texture "background.png")
                       :width 480 :height 640)]
      [background]))

  :on-render
  (fn [screen entities]
    (clear!)
    (render! screen entities))

  :on-key-down
  (fn [screen entities]
    (cond
     (key-pressed? :r) (on-gl (set-screen! pong main-screen)))))

(defgame pong
  :on-create
  (fn [this]
    (set-screen! this main-screen)))

(e main-screen)
