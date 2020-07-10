package ru.okcode.icalc.command.operator

import ru.okcode.icalc.command.Operator
import java.lang.Exception
import javax.inject.Inject

class Equally @Inject constructor() : Operator {

    private val rang = 0

    override fun getRang(): Int {
        return rang
    }
}