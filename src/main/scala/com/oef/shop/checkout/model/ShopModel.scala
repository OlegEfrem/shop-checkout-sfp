package com.oef.shop.checkout.model

object Fruit extends Enumeration {
  val Apple, Orange, Grapes = Value
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

case class Offer(buy: Int, pay: Int) {
  require(pay > 0 && buy > 0, s"pay: $pay & buy: $buy must be greater than zero.")
}

trait OfferList {
  def offerFor(fruit: Fruit.Value): Option[Offer]
}

object OfferList extends OfferList {

  import Fruit._

  private val offers =
    Map(
      Apple -> Offer(2, 1),
      Orange -> Offer(3, 2)
    )

  def apply(): OfferList = OfferList

  override def offerFor(fruit: Fruit.Value): Option[Offer] =
    offers.get(fruit)
}
