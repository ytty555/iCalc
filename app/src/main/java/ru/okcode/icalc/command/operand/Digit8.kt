package ru.okcode.icalc.command.operand


class Digit8 : Operand {
    override fun getResultNumber(oldNumber: Double): Double {
        return oldNumber * 10 + 8.0
    }

}