package ru.okcode.icalc.command

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey
import ru.okcode.icalc.command.operand.Digit1
import ru.okcode.icalc.command.operand.Operand

@Module
abstract class CommandModule {

    @Binds
    abstract fun digit1(digit: Digit1): Operand
}