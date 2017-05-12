package com.oef.shop.checkout.model

import com.oef.shop.checkout.UnitTest

class PriceListTest extends UnitTest {
  private val priceList = PriceList()
  import Fruit._

  "priceFor" should {

    s"return 0.6 for an $Apple" in {
      priceList.priceFor(Apple) shouldBe 0.6
    }

    s"return 0.25 for an $Orange" in {
      priceList.priceFor(Orange) shouldBe 0.25
    }

    s"return an exception for an intem with no price defined" in {
      a[PriceNotFoundException] shouldBe thrownBy {
        priceList.priceFor(Grapes)
      }
    }

  }
}
