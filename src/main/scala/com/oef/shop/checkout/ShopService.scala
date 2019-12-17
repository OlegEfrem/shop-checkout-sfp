package com.oef.shop.checkout

import com.oef.shop.checkout.impl.DefaultShopService
import com.oef.shop.checkout.model._

trait ShopService {

  def checkout(fruits: Seq[Fruit]): Price

  def checkoutWithOffer(fruits: Seq[Fruit]): Price

}

object ShopService {
  def apply(priceList: PriceList = PriceList, offerList: OfferList = OfferList): ShopService =
    new DefaultShopService(priceList, offerList)
}
