package kr.co.sleeptime.koinprac.ui

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.co.sleeptime.koinprac.R
import org.koin.android.architecture.ext.sharedViewModel
import org.koin.android.architecture.ext.viewModel

class MainFragment : Fragment() {
    var viewModelFromListener: MainViewModel? = null

    /**
     * use same viewModel in activity
     */
    val viewModelFromKoin: MainViewModel by sharedViewModel()

    /**
     * use different viewModel in activity
     */
    val viewModelFromKoin2: MainViewModel by viewModel()

    /**
     * communicate Fragment <-> Activity with listener
     */
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is MainFragmentListener) {
            //get same viewModel in activity with listener
            viewModelFromListener = context.getViewModelFromFragment() //get same viewModel from activity
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }
}