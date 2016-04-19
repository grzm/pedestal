; Copyright 2013 Relevance, Inc.
; Copyright 2014 Cognitect, Inc.

; The use and distribution terms for this software are covered by the
; Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0)
; which can be found in the file epl-v10.html at the root of this distribution.
;
; By using this software in any fashion, you are agreeing to be bound by
; the terms of this license.
;
; You must not remove this notice, or any other, from this software.

(defproject server-sent-events "0.0.1-SNAPSHOT"
  :description "a sample to demonstrate server sent events"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [io.pedestal/pedestal.service "0.4.2-SNAPSHOT"]

                 ;; Remove this line and uncomment the next line to
                 ;; use Tomcat instead of Jetty:
                 [io.pedestal/pedestal.jetty "0.4.2-SNAPSHOT"]
                 ;; [io.pedestal/pedestal.tomcat "0.1.2"]

                 ;; Logging
                 [ch.qos.logback/logback-classic "1.1.3" :exclusions [[org.slf4j/slf4j-api]]]
                 [org.slf4j/jul-to-slf4j "1.7.12"]
                 [org.slf4j/jcl-over-slf4j "1.7.12"]
                 [org.slf4j/log4j-over-slf4j "1.7.12"]

                 ;; Deps cleanup
                 [org.clojure/tools.analyzer.jvm "0.6.9"]
                 [org.clojure/tools.reader "1.0.0-alpha1"]

                 ;; Example CLJS client
                 [org.clojure/core.async "0.2.374"]
                 [org.clojure/clojurescript "1.8.40" :exclusions [org.clojure/tools.reader]]]
  :plugins [[lein-cljsbuild "1.1.3"]]
  :min-lein-version "2.0.0"
  :resource-paths ["resources" "config"]
  :global-vars  {*warn-on-reflection* true
                 *assert* true}
  :pedantic? :abort
  :main ^{:skip-aot true} server-sent-events.server
  :profiles {:dev {:aliases {"run-dev" ["trampoline" "run" "-m" "server-sent-events.server/run-dev"]}
                   :dependencies []
                   :source-paths ["dev"]}}
  :cljsbuild {:builds
              {:adv {:source-paths  ["src" "target/classes"]
                    :compiler
                    {:output-dir "target/out"
                     :output-to "resources/public/js/app.js"
                     :pretty-print false
                     :optimizations :advanced}}}})

