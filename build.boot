(set-env!
 :source-paths   #{"src/"}
 :resource-paths #{"assets/"}
 :dependencies   '[
                   [org.clojure/clojurescript "1.9.473"]
                   [tailrecursion/boot-jetty  "0.1.0"          :scope "test"]
                   [adzerk/boot-cljs          "1.7.228-2"          :scope "test"]

                   [cljsjs/jquery             "1.12.4-0"]
                   [cljsjs/jquery-ui          "1.11.4-0"]
                   [hoplon                    "7.0.0-SNAPSHOT" :exclusions [cljsjs/jquery]]])

(require
  '[adzerk.boot-cljs          :refer [cljs]]
  '[tailrecursion.boot-jetty  :refer [serve]]
  '[hoplon.boot-hoplon        :refer [bust-caches hoplon prerender]])

(deftask dev []
  (comp
    (watch)
    (hoplon :pretty-print true :bust-cache true)
    (cljs :source-map true)
    (serve :port 9090)
    (notify :audible true :theme "woodblock")))
