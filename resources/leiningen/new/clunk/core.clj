(ns {{name}}.core
  (:gen-class)
  (:require [clunk.core :as c]
            [{{name}}.scenes.level-01 :as level-01]
            [{{name}}.scenes.menu :as menu]))

(defn init-scenes
  "Map of scenes in the game"
  [state]
  {:menu (menu/init state)
   :level-01 (level-01/init state)})

;; Configure the game
(def {{name}}-game
  (qp/game {:title "{{name}}"
            :size [800 600]
            :init-scenes-fn init-scenes
            :current-scene :menu
            :assets {:image {:captain-spritesheet "resources/img/captain.png"}}}))

(defn -main
  "Run the game"
  [& args]
  (qp/start! {{name}}-game))
