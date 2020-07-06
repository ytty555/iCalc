package ru.okcode.icalc.command

import dagger.Component
import ru.okcode.icalc.command.operand.Digit1
import ru.okcode.icalc.command.operator.Plus

@Component(modules = [CommandModule::class])
interface CommandFactory {

    // Operands
    fun digit1(): Digit1


    // Operators
    fun operatorPlus(): Plus;
}