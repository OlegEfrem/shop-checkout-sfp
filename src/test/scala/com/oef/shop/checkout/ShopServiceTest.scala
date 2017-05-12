package com.oef.shop.checkout

class ShopServiceTest extends UnitTest {
  private val service = ShopService()
  import com.oef.shop.checkout.model.Fruit._

  "checkout" should {

    "return 2.05 for input: [ Apple, Apple, Orange, Apple ] => " in {
      service.checkout(Seq(Apple, Apple, Orange, Apple)) shouldBe 2.05
    }

  }

  "checkoutWithOffer" should {

    "have buy one, get one free on Apples" in {
      service.checkoutWithOffer(Seq(Apple, Apple)) shouldBe 0.6
    }

    "have 3 for the price of 2 on Oranges" in {
      service.checkoutWithOffer(Seq(Orange, Orange, Orange)) shouldBe 0.5
    }

    "return 1.2 for 3 Apples" in {
      service.checkoutWithOffer(Seq(Apple, Apple, Apple)) shouldBe 1.2
    }

    "return 0.75 for 4 Oranges" in {
      service.checkoutWithOffer(Seq(Orange, Orange, Orange, Orange)) shouldBe 0.75
    }

    "return 1.95 for 3 Apples and 4 Oranges" in {
      service.checkoutWithOffer(Seq(Orange, Apple, Orange, Apple, Orange, Apple, Orange)) shouldBe 1.95
    }

  }

}
