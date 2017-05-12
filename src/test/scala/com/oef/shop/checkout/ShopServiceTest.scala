package com.oef.shop.checkout

class ShopServiceTest extends UnitTest {
  private val service = ShopService()
  import com.oef.shop.checkout.model.Fruit._

  "checkout" should {

    "return 2.05 for input: [ Apple, Apple, Orange, Apple ] => " in {
      service.checkout(Seq(Apple, Apple, Orange, Apple)) shouldBe 2.05
    }

  }

}
