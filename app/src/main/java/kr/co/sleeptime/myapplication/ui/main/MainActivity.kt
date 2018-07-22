package kr.co.sleeptime.myapplication.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.main_activity.*
import kr.co.sleeptime.myapplication.R

class MainActivity : AppCompatActivity() {

    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        vm = ViewModelProviders.of(this).get(MainViewModel::class.java)

        subscribeUI(vm)
        button.setOnClickListener {
            //event from view
            vm.calculateAge()
        }
    }

    private fun subscribeUI(vm: MainViewModel) {
        vm.age.observe(this, Observer {
            textView.text = "$it"
        })
    }

}
