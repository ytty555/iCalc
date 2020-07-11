package ru.okcode.icalc

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import ru.okcode.icalc.command.Operand
import ru.okcode.icalc.command.OperatorType
import ru.okcode.icalc.core.*
import ru.okcode.icalc.utils.ZERO

class CalcViewModel() : ViewModel() {

    private val coreFactory: CoreFactory = DaggerCoreFactory.create()
    private val calcProcessor: CalcProcessor = coreFactory.getCalcProcessor()
    private val textProcessor: TextProcessor = coreFactory.getTextProcessor()
    private val numberProcessor: NumberProcessor = coreFactory.getNumberProcessor()

    private val _display = MutableLiveData<String>()
    val display: LiveData<String>
        get() = _display

    private val displayObserver: Observer<String> = object : Observer<String> {
        override fun onComplete() {
            Log.e("qq", "onComplete")
        }

        override fun onSubscribe(d: Disposable?) {
            Log.e("qq", "onSubscribe")

        }

        override fun onNext(t: String?) {
            Log.e("qq", "onNext")
            setDisplayValue(t ?: ZERO)
        }

        override fun onError(e: Throwable?) {
            Log.e("qq", "onError")

        }

    }

    init {
        _display.value = ZERO

        textProcessor.numberAsString.subscribe(displayObserver)
    }

    fun onClickOperand(operand: Operand) {
        textProcessor
            .createText(operand)
    }


    fun onClickOperator(operatorType: OperatorType) {
        //        TODO("Not implemented yet")

    }

    fun onClickClear() {
        textProcessor
            .clear()
    }

    fun onClickEqually() {
        calcProcessor.handleEqually()
    }

    private fun setDisplayValue(value: String) {
        _display.value = value
    }

}