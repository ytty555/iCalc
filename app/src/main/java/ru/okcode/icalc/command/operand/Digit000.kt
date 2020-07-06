package ru.okcode.icalc.command.operand

class Digit000 : Operand {

    override fun getResultNumber(oldNumber: Double): Double {
        return oldNumber * 1000.0;
    }

}