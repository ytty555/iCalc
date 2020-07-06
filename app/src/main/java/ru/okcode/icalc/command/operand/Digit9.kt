package ru.okcode.icalc.command.operand


class Digit9 : Operand {
    override fun getResultNumber(oldNumber: Double): Double {
        return oldNumber * 10 + 9.0
    }

}