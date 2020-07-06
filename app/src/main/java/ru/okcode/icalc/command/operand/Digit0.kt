package ru.okcode.icalc.command.operand

class Digit0 : Operand {

    override fun getResultNumber(oldNumber: Double): Double {
        return oldNumber * 10.0;
    }

}