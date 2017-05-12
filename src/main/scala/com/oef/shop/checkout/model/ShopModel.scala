package com.oef.shop.checkout.model

object Fruit extends Enumeration {
  val Apple, Orange = Value
}

trait PriceList {
  def priceFor(fruit: Fruit.Value): Double
}

object PriceList extends PriceList {

  import Fruit._

  private val prices =
    Map(
      Apple -> 0.6,
      Orange -> 0.25
    )

  def apply(): PriceList = PriceList

  def priceFor(fruit: Fruit.Value): Double = {
    prices.get(fruit) match {
      case Some(p) => p
      case None => throw PriceNotFoundException(s"price for $fruit not defined")
    }
  }
}

case class PriceNotFoundException(message: String) extends Exception(message)
