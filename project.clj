(defproject com.kimbsy/lein-template.clunk "0.1.12"
  :description "A Leiningen template for the clunk game engine"
  :url "https://github.com/Kimbsy/clunk-template"
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/MIT"}
  :eval-in-leiningen true
  :deploy-repositories [["clojars" {:url "https://clojars.org/repo/"
                                    :username :env/clojars_user
                                    :password :env/clojars_pass
                                    :sign-releases false}]])
