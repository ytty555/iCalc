package ru.okcode.icalc.command.operand


class Digit6 : Operand {
    override fun getResultNumber(oldNumber: Double): Double {
        return oldNumber * 10 + 6.0
    }

}