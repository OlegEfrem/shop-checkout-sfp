package com.oef.shop.checkout

import com.oef.shop.checkout.model.Fruit
import com.oef.shop.checkout.model.Fruit._
import org.scalatest.prop.TableDrivenPropertyChecks.forAll
import org.scalatest.prop.Tables.Table
import scala.language.implicitConversions

class ShopServiceTest extends UnitTest {
  private val service = ShopService()

  private val testData = Table[Seq[Fruit.Value], Double, Double](
    ("Fruits", "Price No Offer", "Price On Offer"),
    (basket(appleNo = 2), 1.2, 0.6),
    (basket(orangeNo = 3), 0.75, 0.5),
    (basket(appleNo = 3), 1.8, 1.2),
    (basket(orangeNo = 4), 1, 0.75),
    (basket(appleNo = 3, orangeNo = 4), 2.8, 1.95)
  )

  private def basket(appleNo: Int = 0, orangeNo: Int = 0): Seq[Fruit.Value] = {
    val oranges = (1 to orangeNo).map(_ => Orange)
    val apples = (1 to appleNo).map(_ => Apple)
    apples ++ oranges
  }

  "checkout" should {
    forAll(testData) { (fruits, price, _) =>
      s"return $price for ${fruits.inBrackets}" in {
        service.checkout(fruits) shouldBe price
      }
    }
  }

  "checkoutWithOffer" should {
    forAll(testData) { (fruits, _, price) =>
      s"return $price for ${fruits.inBrackets}" in {
        service.checkoutWithOffer(fruits) shouldBe price
      }
    }
  }

  implicit class CollectionPrettifier(fruits: Traversable[_]) {
    def inBrackets: String = fruits.mkString("[", ", ", "]")
  }

}
