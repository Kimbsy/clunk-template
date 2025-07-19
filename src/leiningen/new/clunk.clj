(ns leiningen.new.clunk
  (:require [leiningen.new.templates :as tmpl]
            [leiningen.core.main :as main]))

(def render (tmpl/renderer "clunk"))

(defn clunk
  "Create a basic clunk project"
  [name]
  (let [data {:name name
              :sanitized (tmpl/name-to-path name)}]
    (main/info "Generating fresh 'lein new' com.kimbsy/clunk project.")
    (tmpl/->files data
                  "src"
                  "resources"
                  ["project.clj" (render "project.clj" data)]
                  ["README.md" (render "README.md" data)]
                  [".gitignore" (render "gitignore" data)]
                  ["src/{{sanitized}}/core.clj" (render "core.clj" data)]
                  ["src/{{sanitized}}/scenes/menu.clj" (render "menu.clj" data)]
                  ["src/{{sanitized}}/scenes/level_01.clj" (render "level_01.clj" data)]
                  ["src/{{sanitized}}/sprites/button.clj" (render "button.clj" data)]
                  ["resources/img/captain.png" "captain.png"])))
