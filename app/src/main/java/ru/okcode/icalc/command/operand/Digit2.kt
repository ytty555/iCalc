package ru.okcode.icalc.command.operand

class Digit2 : Operand {
    override fun getResultNumber(oldNumber: Double): Double {
        return oldNumber * 10 + 2.0
    }
}