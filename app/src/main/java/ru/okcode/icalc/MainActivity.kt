package ru.okcode.icalc

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import ru.okcode.icalc.command.Command
import ru.okcode.icalc.command.DaggerCommandFactory
import ru.okcode.icalc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val commandFactory = DaggerCommandFactory.create()
    private val viewModel: CalcViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setClickListeners();

    }

    private fun setClickListeners() {
        binding.apply {

            // Click "Plus" button
            btnPlus.setOnClickListener {
                val command: Command = commandFactory.operatorPlus();
                Log.e("qq", "setClickListeners Plus. Command: $command")
                viewModel?.onClickOperator(command)
            }
        }
    }
}