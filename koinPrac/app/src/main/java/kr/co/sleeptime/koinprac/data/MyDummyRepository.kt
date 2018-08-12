package kr.co.sleeptime.koinprac.data

import kr.co.sleeptime.koinprac.domain.Repository

class MyDummyRepository:Repository {
    override fun giveHello(): String = "hello koin!"
}