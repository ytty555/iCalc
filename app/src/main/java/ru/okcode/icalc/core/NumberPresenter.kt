package ru.okcode.icalc.core

/**
 * Класс предназначен для представления числа в двух типах:
 * в виде Double и в виде String
 */
class NumberPresenter private constructor() {
    private var value: Double = 0.0

    /**
     * Содержит значение данного числа в формате типа Double
     */
    val valueAsDouble: Double
        get() = value

    /**
     * Содержит значение данного числа в формате типа String
     */
    val valueAsString: String
        get() = convertToString(value)

    companion object {
        private const val COMMA = ','
        private const val POINT = '.'

        /**
         * Перегруженый фабричный метод
         * @param value - входящее значение числа в формате типа String
         */
        fun create(value: String): NumberPresenter {
            val numberPresentation = NumberPresenter()
            numberPresentation.value = numberPresentation.convertToDouble(value)
            return numberPresentation
        }

        /**
         * Перегруженый фабричный метод
         * @param value - входящее значение числа в формате типа Double
         */
        fun create(value: Double): NumberPresenter {
            val numberPresentation = NumberPresenter()
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
            true -> number.toString().replace(POINT, COMMA)
            false -> (number.toInt()).toString()
        }
    }

    private fun hasFractional(number: Double): Boolean {
        val decimal = number.toInt()
        val fractional = number - decimal
        return fractional != 0.0
    }
}