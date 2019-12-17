package com.oef.shop.checkout.model

object Fruit extends Enumeration {
  val Apple, Orange, Grapes = Value
}

trait PriceList {
  def priceFor(fruit: Fruit): Price
}

object PriceList extends PriceList {

  import Fruit._

  private val prices =
    Map(
      Apple -> 0.6,
      Orange -> 0.25
    )

  def apply(): PriceList = PriceList

  def priceFor(fruit: Fruit): Price = {
    prices.get(fruit) match {
      case Some(p) => p
      case None => throw PriceNotFoundException(s"price for $fruit not defined")
    }
  }
}

case class PriceNotFoundException(message: String) extends Exception(message)

case class Offer(buy: Count, pay: Count) {
  require(pay > 0 && buy > 0, s"pay: $pay & buy: $buy must be greater than zero.")
}

trait OfferList {
  def offerFor(fruit: Fruit): Option[Offer]
}

object OfferList extends OfferList {

  import Fruit._

  private val offers =
    Map(
      Apple -> Offer(2, 1),
      Orange -> Offer(3, 2)
    )

  def apply(): OfferList = OfferList

  override def offerFor(fruit: Fruit): Option[Offer] =
    offers.get(fruit)
}
