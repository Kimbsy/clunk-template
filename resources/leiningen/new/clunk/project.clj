(defproject {{name}} "0.1.0"
  :dependencies [[org.clojure/clojure "1.12.5"]
                 [com.kimbsy/clunk "2.0.2"]]
  :main ^:skip-aot {{name}}.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
