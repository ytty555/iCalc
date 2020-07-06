package ru.okcode.icalc.command.operand


class Digit7 : Operand {
    override fun getResultNumber(oldNumber: Double): Double {
        return oldNumber * 10 + 7.0
    }

}