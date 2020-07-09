package ru.okcode.icalc.command

enum class Operand(val value: String) {
    DIGIT_0("0"),
    DIGIT_000("000"),
    DIGIT_1("1"),
    DIGIT_2("2"),
    DIGIT_3("3"),
    DIGIT_4("4"),
    DIGIT_5("5"),
    DIGIT_6("6"),
    DIGIT_7("7"),
    DIGIT_8("8"),
    DIGIT_9("9"),
    COMMA(","),
    TRIGGER_PLUS_MINUS("trigger_plus_minus")
}