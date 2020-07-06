package ru.okcode.icalc.command.operand

class Digit1 : Operand {

    override fun getResultNumber(oldNumber: Double): Double {
        return oldNumber * 10 + 1.0;
    }
}