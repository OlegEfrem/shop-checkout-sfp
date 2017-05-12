package com.oef.shop.checkout.model

import com.oef.shop.checkout.UnitTest

class OfferTest extends UnitTest {

  "offer" should {

    "throw an Exception if buy is zero" in {
      a[IllegalArgumentException] shouldBe thrownBy {
        Offer(0, 1)
      }
    }

    "throw an Exception if pay is zero" in {
      a[IllegalArgumentException] shouldBe thrownBy {
        Offer(1, 0)
      }
    }

  }
}
