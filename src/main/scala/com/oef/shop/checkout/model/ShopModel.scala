package com.oef.shop.checkout.model

object Fruit extends Enumeration {
  val Apple, Orange = Value
}

trait PriceList {
  def priceFor(fruit: Fruit.Value): Double
}

object PriceList extends PriceList {

  def apply(): PriceList = PriceList

  override def priceFor(fruit: Fruit.Value) = ???
}
