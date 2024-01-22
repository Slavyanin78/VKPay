package ru.netology

import com.sun.source.tree.BreakTree


fun main() {
    val payPercent = calculatePayTransfer(1000, 75000, 150000, "MasterCard")

    println(payPercent)


}

fun cardZeroLimit(cardPay: String): Int = when (cardPay) {
    "Maestro" -> 75000
    "MasterCard" -> 75000
    "VKPay" -> 40000
    else -> 0
}

fun dayLimitPay(cardPay: String): Int = when (cardPay) {
    "Maestro" -> 150000
    "MasterCard" -> 150000
    "Visa" -> 150000
    "MIR" -> 150000
    "VKPay" -> 15000
    else -> 0
}

fun monthLimitPay(cardPay: String): Int = when (cardPay) {
    "Maestro" -> 600000
    "MasterCard" -> 600000
    "Visa" -> 600000
    "MIR" -> 600000
    "VKPay" -> 40000
    else -> 0
}

fun calculatePayTransfer(amount: Int, sumAmountMonth: Int, sumAmountDay: Int, cardPay: String): Int {

    var payTransfer = when (cardPay) {
        "Maestro", "MasterCard" -> if ((sumAmountMonth < cardZeroLimit(cardPay))) 0.0 else amount * 0.006 + 20

        "VKPay" -> 0

        "Visa", "MIR" -> if ((amount * 0.0075) < 35) 35 else amount * 0.0075

        else -> amount * 0.006 + 20
    }


    if (sumAmountDay > dayLimitPay(cardPay)) {
        //println("Over limit day")
        payTransfer = dayLimitPay(cardPay) - sumAmountDay
    }
    if (sumAmountMonth > monthLimitPay(cardPay)) {
        //println("Over limit month")
        payTransfer = monthLimitPay(cardPay) - sumAmountMonth
    }
    return payTransfer.toInt()

}



