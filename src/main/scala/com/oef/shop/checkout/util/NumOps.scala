package com.oef.shop.checkout.util

object NumOps {

  def round2decimals(double: Double): Double = {
    BigDecimal(double).setScale(2, BigDecimal.RoundingMode.HALF_EVEN).toDouble
  }

}
