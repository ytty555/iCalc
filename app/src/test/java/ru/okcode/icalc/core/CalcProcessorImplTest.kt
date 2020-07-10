package ru.okcode.icalc.core

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import ru.okcode.icalc.command.Calculable
import ru.okcode.icalc.command.Operator
import ru.okcode.icalc.command.operator.*

class CalcProcessorImplTest {

    private val coreFactory = DaggerCoreFactory.create()
    private val calcProcessor = coreFactory.getCalcProcessor()

    // Operators
    private val plus: Calculable = Plus()
    private val minus: Calculable = Minus()
    private val div: Calculable = Division()
    private val mult: Calculable = Multiplication()
    private val percent: Calculable = Percent()


    @Before
    fun setUp() {

    }

    @Test
    fun test2plus3equally5() {
        calcProcessor.handleNumber(2.0)
        calcProcessor.handleOperator(plus)
        calcProcessor.handleNumber(3.0)
        calcProcessor.handleEqually()

        val actual = calcProcessor.getCalcResult()
        val expected = 5.0
        assertEquals(expected, actual, 0.0)
    }

    @Test
    fun test2plus3mult5equally17() {
        calcProcessor.handleNumber(2.0)
        calcProcessor.handleOperator(plus)
        calcProcessor.handleNumber(3.0)
        calcProcessor.handleOperator(mult)
        calcProcessor.handleNumber(5.0)
        calcProcessor.handleEqually()

        val actual = calcProcessor.getCalcResult()
        val expected = 17.0
        assertEquals(expected, actual, 0.0)
    }

    @Test
    fun test2mult3minus5equally1() {
        calcProcessor.handleNumber(2.0)
        calcProcessor.handleOperator(mult)
        calcProcessor.handleNumber(3.0)
        calcProcessor.handleOperator(minus)
        calcProcessor.handleNumber(5.0)
        calcProcessor.handleEqually()

        val actual = calcProcessor.getCalcResult()
        val expected = 1.0
        assertEquals(expected, actual, 0.0)
    }


}