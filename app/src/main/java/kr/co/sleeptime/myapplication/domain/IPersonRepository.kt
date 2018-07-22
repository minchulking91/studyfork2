package kr.co.sleeptime.myapplication.domain

import io.reactivex.Single
import kr.co.sleeptime.myapplication.entity.Person

interface IPersonRepository {
    fun getPerson(): List<Person>
    fun getAddress(): List<Pair<String, String>>
    fun getPersonWithCallback(callback: (List<Person>) -> Unit)
    fun getAddressWithCallback(callback: (List<Pair<String, String>>) -> Unit)
    fun getPersonWithObservable(): Single<List<Person>>
    fun getAddressWithObservable(): Single<List<Pair<String, String>>>
}