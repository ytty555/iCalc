package ru.okcode.icalc.command.operand

class Comma : Operand {

    override fun getResultNumber(oldNumber: Double): Double {
        return when (hasFractionalPart(oldNumber)) {
            true -> oldNumber
            false -> oldNumber.times(0.1)
        }
    }

    private fun hasFractionalPart(number: Double): Boolean {
        // TODO TEST
        val integerPart = number.toLong()
        return number.minus(integerPart) != 0.0
    }

}