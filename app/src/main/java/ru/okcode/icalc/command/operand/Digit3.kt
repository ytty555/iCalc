package ru.okcode.icalc.command.operand


class Digit3 : Operand {
    override fun getResultNumber(oldNumber: Double): Double {
        return oldNumber * 10 + 3.0
    }

}