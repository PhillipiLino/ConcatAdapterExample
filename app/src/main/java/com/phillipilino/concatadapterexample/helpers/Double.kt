package com.phillipilino.concatadapterexample.helpers

import java.text.NumberFormat
import java.util.*

fun Double.toCurrency(language: String = "pt", country: String = "BR"): String {
    val formatter = NumberFormat.getCurrencyInstance(Locale(language, country))
    val currencySymbol = formatter.currency?.symbol ?: "R$"
    return formatter.format(this).replace(currencySymbol, " $currencySymbol ")
}