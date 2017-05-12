package com.oef.shop.checkout

import com.oef.shop.checkout.model.{ Fruit, PriceList }

trait ShopService {
  type Fruit = Fruit.Value
  type Price = Double

  def checkout(fruits: Seq[Fruit]): Price

  def checkoutWithOffer(fruits: Seq[Fruit]): Price

}

object ShopService {

  def apply(priceList: PriceList = PriceList): ShopService = new DefaultShopService(priceList)
}

private[checkout] class DefaultShopService(priceList: PriceList) extends ShopService {

  override def checkout(fruits: Seq[Fruit]) = {
    fruits.map(priceList.priceFor).sum
  }

  override def checkoutWithOffer(fruits: Seq[Fruit]) = 0
}
