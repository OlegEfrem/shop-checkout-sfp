# Shop checkout coding challenge
Complete assignment cand be found [here](https://github.com/OlegEfrem/shop-checkout-sfp/blob/master/Assignment.pdf)

# Requirements
This is a scala sbt project, and was developed and tested to run with: Java 1.8, Scala 2.12.2 and Sbt 0.13.15

# Highlights
1. This is a simple Functional Programming (FP) implementation to the more elaborated FP one found [here](https://github.com/OlegEfrem/shop-checkout) and more OO (Object Oriented) one found [here](https://github.com/OlegEfrem/shop-checkout-oop)
2. Distinctive feature of this implementation is that is pulls prices, offers and the shop items/fruits apart, allowing them to vary independently. 

# Libraries, Frameworks & Plugins
* Dependencies are defined [here](https://github.com/OlegEfrem/shop-checkout-sfp/blob/master/build.sbt) and 
plugins [here](https://github.com/OlegEfrem/shop-checkout-sfp/blob/master/project/plugins.sbt);
* Testing layer uses: [scala test](http://www.scalatest.org/) for defining test cases, [scala check](https://www.scalacheck.org/) test data management; 
* Plugins configured for the project are: [s-coverage](https://github.com/scoverage/sbt-scoverage) for code test coverage, [scala-style](http://www.scalastyle.org/) for code style checking and
[scala-iform](https://github.com/scala-ide/scalariform) for code formatting.