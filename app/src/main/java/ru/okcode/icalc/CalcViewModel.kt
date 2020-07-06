package ru.okcode.icalc

import android.util.Log
import androidx.lifecycle.ViewModel

class CalcViewModel() : ViewModel() {


    fun onClickDigit(value: String) {
        Log.e("qq", "Click digit: $value")
    }

    fun onClickOperator(value: String) {
        Log.e("qq", "Click operator: $value")
    }

}