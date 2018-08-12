package kr.co.sleeptime.koinprac.ui

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kr.co.sleeptime.koinprac.R
import org.koin.android.architecture.ext.getViewModel
import org.koin.android.architecture.ext.viewModel

class MainActivity : AppCompatActivity(), MainFragmentListener {
    /**
     * share viewModel with fragment
     */
    override fun getViewModelFromFragment(): MainViewModel {
        return obtainViewModel(this) //or obtainViewModelWithKoin
    }

    //lazy property
    private val viewModelWithKoin: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text.text = viewModelWithKoin.sayHello()
        Log.d("MainActivity", viewModelWithKoin.toString())
    }

    companion object {

        /**
         * share viewModel with fragment
         */
        fun obtainViewModel(activity: FragmentActivity): MainViewModel {
            return ViewModelProviders.of(activity).get(MainViewModel::class.java)
        }

        /**
         * share viewModel with fragment with Koin
         */
        fun obtainViewModelWithKoin(activity: FragmentActivity): MainViewModel {
            return activity.getViewModel()
        }
    }
}
