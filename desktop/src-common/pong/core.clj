(ns pong.core
  (:require [play-clj.core :refer :all]
            [play-clj.g2d :refer :all]
            [play-clj.ui :refer :all]))

(use 'play-clj.repl)
(declare pong main-screen)

(defscreen main-screen
  :on-show
  (fn [screen entities]
    (update! screen :renderer (stage))
    (label "foo" (color :white)))

  :on-render
  (fn [screen entities]
    (clear!)
    (render! screen entities))

  :on-key-down
  (fn [screen entities]
    (cond
     (key-pressed? :r) (set-screen! pong main-screen))))

(defgame pong
  :on-create
  (fn [this]
    (set-screen! this main-screen)))

(e main-screen)
