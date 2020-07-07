package ru.okcode.icalc.core

class NumberPresentation private constructor() {
    private var value: Double = 0.0

    val valueAsDouble: Double
        get() = value

    val valueAsString: String
        get() = convertToString(value)

    companion object {
        private const val COMMA = ','
        private const val POINT = '.'

        fun create(value: String): NumberPresentation {
            val numberPresentation = NumberPresentation()
            numberPresentation.value = numberPresentation.convertToDouble(value)
            return numberPresentation
        }

        fun create(value: Double): NumberPresentation {
            val numberPresentation = NumberPresentation()
            numberPresentation.value = value
            return numberPresentation
        }
    }

    private fun convertToDouble(value: String): Double {
        return if (value.contains(COMMA)) {
            val newValue = value.replace(COMMA, POINT)
            newValue.toDouble()
        } else {
            value.toDouble()
        }
    }

    private fun convertToString(number: Double): String {
        return when (hasFractional(number)) {
            true -> replacePointByComma(number.toString())
            false -> (number.toInt()).toString()
        }
    }

    private fun replacePointByComma(value: String): String {
        return value.replace(POINT, COMMA)
    }

    private fun hasFractional(number: Double): Boolean {
        val decimal = number.toInt()
        val fractional = number - decimal
        return fractional != 0.0
    }
}