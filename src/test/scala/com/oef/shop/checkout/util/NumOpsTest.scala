package com.oef.shop.checkout.util

import com.oef.shop.checkout.UnitTest

class NumOpsTest extends UnitTest {

  "round2decimals" should {

    "rounded to 2 decimals" in {
      NumOps.round2decimals(1.237) shouldBe 1.24
      NumOps.round2decimals(1.234) shouldBe 1.23
      NumOps.round2decimals(1.235) shouldBe 1.24
    }

  }
}
