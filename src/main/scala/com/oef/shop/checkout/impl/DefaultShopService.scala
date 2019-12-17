package com.oef.shop.checkout.impl

import com.oef.shop.checkout.ShopService
import com.oef.shop.checkout.model._

private[checkout] class DefaultShopService(priceList: PriceList, offerList: OfferList) extends ShopService {

  import com.oef.shop.checkout.util.NumOps._

  override def checkoutWithOffer(fruits: Seq[Fruit]): Price = {
    priceFor(fruits, includeOffers = true)
  }

  override def checkout(fruits: Seq[Fruit]): Price = {
    priceFor(fruits, includeOffers = false)
  }

  private def priceFor(fruits: Seq[Fruit], includeOffers: Boolean): Price = {
    val groupedFruits = countByGroup(fruits)
    val prices = groupedFruits.map {
      case (fruit, count) => priceOn(fruit, count, includeOffers)
    }
    round2decimals(prices.sum)
  }

  private def priceOn(fruit: Fruit, count: Count, includeOffers: Boolean): Price = {
    val price = priceList.priceFor(fruit)
    val offer = if (includeOffers) offerList.offerFor(fruit) else None
    offer match {
      case Some(o) => priceWithOffer(count, price, o)
      case None => count * price
    }
  }

  private def priceWithOffer(count: Count, price: Price, o: Offer): Price = {
    val onOfferPrice = count / o.buy * o.pay * price
    val noOfferPrice = count % o.buy * price
    onOfferPrice + noOfferPrice
  }

  private def countByGroup(fruits: Seq[Fruit]): Map[Fruit, Count] = {
    fruits.view.groupBy(k => k).map { case (fruit, fruitList) => fruit -> fruitList.size }
  }

}
