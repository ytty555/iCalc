package ru.okcode.icalc.command.operand


class Digit4 : Operand {
    override fun getResultNumber(oldNumber: Double): Double {
        return oldNumber * 10 + 4.0
    }

}