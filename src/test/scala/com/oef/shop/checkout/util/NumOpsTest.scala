package com.oef.shop.checkout.util

import com.oef.shop.checkout.UnitTest
import org.scalatest.prop.TableDrivenPropertyChecks.forAll
import org.scalatest.prop.Tables.Table

class NumOpsTest extends UnitTest {

  private val testData = Table[Double, Double](
    ("Input Double", "Rounded Double"),
    (1.237, 1.24),
    (1.234, 1.23),
    (1.235, 1.24)
  )

  "round2decimals" should {
    forAll(testData) { (input, output) =>
      s"return $output for $input" in {
        NumOps.round2decimals(input) shouldBe output
      }
    }
  }

}
