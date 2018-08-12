package kr.co.sleeptime.koinprac.ui

import android.arch.lifecycle.ViewModel
import kr.co.sleeptime.koinprac.domain.Repository

class MainViewModel(private val repository: Repository) : ViewModel() {
    fun sayHello() = repository.giveHello()
}