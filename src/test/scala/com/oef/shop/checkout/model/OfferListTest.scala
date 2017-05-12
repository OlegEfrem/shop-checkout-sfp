package com.oef.shop.checkout.model

import com.oef.shop.checkout.UnitTest

class OfferListTest extends UnitTest {
  private val offerList: OfferList = OfferList
  import Fruit._

  "offerFor" should {

    "return the offer for Apples" in {
      offerList.offerFor(Apple).value shouldBe Offer(2, 1)
    }

    "return the offer for Oranges" in {
      offerList.offerFor(Orange).value shouldBe Offer(3, 2)
    }

    "return the NONE for item not on offfer" in {
      offerList.offerFor(Grapes) shouldBe None
    }

  }
}
