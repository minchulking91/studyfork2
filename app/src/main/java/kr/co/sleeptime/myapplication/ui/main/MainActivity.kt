package kr.co.sleeptime.myapplication.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.main_activity.*
import kr.co.sleeptime.myapplication.R
import kr.co.sleeptime.myapplication.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private lateinit var vm: MainViewModel

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        vm = ViewModelProviders.of(this).get(MainViewModel::class.java)

        subscribeUI(vm)
        button.setOnClickListener {
            //event from view
            vm.calculateAge()
        }
        initialTask()
    }

    private fun initialTask() {

    }

    private fun subscribeUI(vm: MainViewModel) {
        vm.resultFromAPI.observe(this, Observer {
            //control view like finish() or something
        })
        vm.age.observe(this, Observer {
            textView.text = "$it"
        })
    }

}
