(ns classlonely.core
  (:require [cemerick.pomegranate :as pom]
            [cemerick.pomegranate.aether :as aether]
            [classlojure.core :as classlojure]))


(comment


 (aether/resolve-dependencies :coordinates '[[jarohen/yoyo "0.0.5"]]
                       :repositories (merge cemerick.pomegranate.aether/maven-central
                                            {"clojars" "http://clojars.org/repo"}))


 (def a (fn [x] x))
 (def b (fn [x] x))

 (class a)
 (supers (type a))
 (.getClassLoader (type a))
 (.getClassLoader (type b))

 (defn list-cl [o] (->> (.getClassLoader (type o))
       (iterate #(when % (.getParent %)))
       (take-while (complement nil?))))
 (list-cl b)

 (def v [(fn [x] x) (fn [y] y)])

 (map (comp #(.getClassLoader %) type) v)

 (ClassLoader/getSystemClassLoader)
 (.getClassLoader (type eval))
 (.getClassLoader (type aether/install))
 (list-cl aether/install)

 (.getClassLoader (type aether/resolve-dependencies))
(supers (class eval))
(supers (type eval))
(supers (type require))

(eval '(require fdjkfljas
           ))

)
