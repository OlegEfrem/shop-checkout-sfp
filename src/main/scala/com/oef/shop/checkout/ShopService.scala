package com.oef.shop.checkout

import com.oef.shop.checkout.model.Fruit

trait ShopService {
  type Fruit = Fruit.Value
  type Price = Double

  def checkout(fruits: Seq[Fruit]): Price
}

object ShopService {

  def apply(): ShopService = new ShopService {
    override def checkout(fruits: Seq[Fruit]) = ???
  }
}
