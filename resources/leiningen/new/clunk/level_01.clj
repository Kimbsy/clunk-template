(ns {{name}}.scenes.level-01
  (:require [clunk.core :as c]
            [clunk.input :as i]
            [clunk.palette :as p]
            [clunk.sprite :as sprite]
            [clunk.util :as u]))

(def coral-pink (p/hex->rgba "#FF9B85"))

(defn sprites
  "The initial list of sprites for this scene"
  [{:keys [window] :as state}]
  (let [[w h] (u/window-size window)]
    [(sprite/animated-sprite
      :captain ; sprite-group, used for group collision detection
      [(* w 1/2) (* h 1/2)]
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
      :current-animation :idle)]))

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

(defn change-animation
  "When the user presses space choose a random animation for the
  captain."
  [state e]
  (if (i/is e :key i/K_SPACE :action i/PRESS)
    (sprite/update-sprites
     state
     (sprite/has-group :captain)
     (fn [s]
       (let [animation (rand-nth [:none :idle :run :jump])]
         (prn animation)
         (sprite/set-animation s animation))))
    state))

(defn init
  "Initialise this scene"
  [state]
  {:sprites (sprites state)
   :draw-fn draw-level-01!
   :update-fn update-level-01
   :key-fns [change-animation]})
