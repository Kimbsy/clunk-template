(ns {{name}}.scenes.level-01
    (:require [clunk.core :as c]
              [clunk.palette :as p]
              [clunk.sprite :as sprite]
              [clunk.util :as u]))

(def coral-pink (p/hex->rgba "#FF9B85"))

(defn sprites
  "The initial list of sprites for this scene"
  []
  [(sprite/animated-sprite
    :captain ; sprite-group, used for group collision detection
    pos
    [240 360] ; <- width and height of each animation frame
    :captain-spritesheet ; <- spritesheet image asset key
    [1680 1440] ; <- width and height of the whole spritesheet image
    :animations {:none {:frames 1
                        :y-offset 0
                        :frame-delay 100}
                 :idle {:frames 4
                        :y-offset 1
                        :frame-delay 15}
                 :run  {:frames 4
                        :y-offset 2
                        :frame-delay 8}
                 :jump {:frames 7
                        :y-offset 3
                        :frame-delay 8}}
    :current-animation current-animation)])

(defn draw-level-01!
  "Called each frame, draws the current scene to the screen"
  [state]
  (c/draw-background! coral-pink)
  (sprite/draw-scene-sprites! state))

(defn update-level-01
  "Called each frame, update the sprites in the current scene"
  [state]
  (-> state
      sprite/update-state))

(defn init
  "Initialise this scene"
  [state]
  {:sprites (sprites)
   :draw-fn draw-level-01!
   :update-fn update-level-01})
