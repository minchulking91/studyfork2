package kr.co.sleeptime.koinprac.ui

import kr.co.sleeptime.koinprac.domain.Repository

class MainPresenter(private val repository: Repository) {

    fun sayHello(): String {
        return repository.giveHello()
    }
}