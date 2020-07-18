package ru.okcode.icalc.core

import org.junit.Before
import org.junit.Test
import ru.okcode.icalc.command.Operator
import ru.okcode.icalc.command.operator.*

class CalcProcessorImplTest {

    private val coreFactory = DaggerCoreFactory.create()
    private val calcProcessor = coreFactory.processor()

    // Operators
    private val plus: Operator = Plus()
    private val minus: Operator = Minus()
    private val div: Operator = Division()
    private val mult: Operator = Multiplication()
    private val percent: Operator = Percent()


    @Before
    fun setUp() {

    }

    @Test
    fun test2plus3equally5() {
    }


}