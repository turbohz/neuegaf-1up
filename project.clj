(defproject neuegaf-1up "0.0.2-SNAPSHOT"
  :license {:name "Unlicense"
            :url "http://unlicense.org"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.36"]
                 [khroma "0.3.0"]
                 [prismatic/dommy "1.1.0"]]
  :source-paths ["src"]
  :profiles {:dev
             {:plugins [[com.cemerick/austin "0.1.6"]
                        [lein-cljsbuild "1.1.3"]
                        [lein-chromebuild "0.3.0"]]
              :cljsbuild
              {:builds
               {:main
                {:source-paths ["src"]
                 :compiler {:output-to "target/unpacked/main.js"
                            :source-map "target/unpacked/main.js.map"
                            :output-dir "target/unpacked/"
                            :parallel-build true
                            :optimizations :whitespace
                            :pretty-print false}}}}}})

