(ns pong.core.desktop-launcher
  (:require [pong.core :refer :all])
  (:import [com.badlogic.gdx.backends.lwjgl LwjglApplication]
           [org.lwjgl.input Keyboard])
  (:gen-class))

(defn -main
  []
  (LwjglApplication. pong "pong" 800 600)
  (Keyboard/enableRepeatEvents true))
