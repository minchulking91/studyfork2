package kr.co.sleeptime.koinprac.data

import kr.co.sleeptime.koinprac.domain.Repository

class MyRepository:Repository {
    override fun giveHello(): String = "hello koin!"
}