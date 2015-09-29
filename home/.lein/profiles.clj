{:user {:plugins [[lein-pprint "1.1.2"]
                  [lein-voom "0.1.0-20140716_032004-g85e4c9b" :exclusions [org.clojure/clojure]]]
                  ;[venantius/ultra "0.3.4" :exclusions [org.clojure/clojure]]]

        :ultra {:color-scheme :solarized_dark}

        :dependencies [[rubydoc "0.4.0"]
                       [clj-stacktrace "0.2.8"]
                       [spyscope "0.1.5"]
                       [jonase/eastwood "0.2.1" :exclusions [org.clojure/clojure]]]

        :injections [(require 'spyscope.core)
                     (let [orig (ns-resolve (doto 'clojure.stacktrace require) 'print-cause-trace)
                           new (ns-resolve (doto 'clj-stacktrace.repl require) 'pst)]
                       (alter-var-root orig (constantly (deref new))))]}}
