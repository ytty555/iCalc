package ru.okcode.icalc.command.operand


class Digit5 : Operand {
    override fun getResultNumber(oldNumber: Double): Double {
        return oldNumber * 10 + 5.0
    }

}