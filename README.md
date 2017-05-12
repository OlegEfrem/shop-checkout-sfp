# Shop checkout coding challenge
Complete assignment cand be found [here](https://github.com/OlegEfrem/shop-checkout-oop/blob/master/Assignment.pdf)

# Requirements
This is a scala sbt project, and was developed and tested to run with: Java 1.8, Scala 2.11.8 and Sbt 0.13.8

# Highlights
1. This is a simple alternative OOP implementation to the more FP one found [here](https://github.com/OlegEfrem/shop-checkout).
2. [ShopCheckout](https://github.com/OlegEfrem/shop-checkout-oop/blob/master/src/main/scala/com/oef/shop/checkout/ShopCheckout.scala#L11) is the single point of entry into the service with Factory on the main trait to hide implementation details from client users, note that [DefaultShopCheckout](https://github.com/OlegEfrem/shop-checkout-oop/blob/master/src/main/scala/com/oef/shop/checkout/impl/DefaultShopCheckout.scala#L6) is package private to enclosing "checkout" package, so classes outside of that package won't compile if using it.
3. [Model](https://github.com/OlegEfrem/shop-checkout-oop/blob/master/src/main/scala/com/oef/shop/checkout/model/Items.scala) classes show classical OOP implementation of the business logic: binding together data and operations on the data. 