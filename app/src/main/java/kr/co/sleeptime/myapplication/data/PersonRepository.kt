package kr.co.sleeptime.myapplication.data

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.subjects.PublishSubject
import kr.co.sleeptime.myapplication.domain.IPersonRepository
import kr.co.sleeptime.myapplication.entity.Person

class PersonRepository:IPersonRepository {
    override fun getPerson(): List<Person> {
        return listOf(
                Person("A", 20),
                Person("B", 21),
                Person("C", 22),
                Person("D", 23),
                Person("E", 24),
                Person("F", 25),
                Person("G", 26)
        )
    }

    override fun getAddress(): List<Pair<String, String>> {
        return listOf(
                "A" to "서울",
                "B" to "경기도",
                "C" to "서울",
                "D" to "제주도",
                "E" to "대구"
        )
    }

    override fun getPersonWithCallback(callback: (List<Person>) -> Unit) {
        callback.invoke(getPerson())
    }

    override fun getAddressWithCallback(callback: (List<Pair<String, String>>) -> Unit) {
        callback.invoke(getAddress())
    }

    override fun getPersonWithObservable(): Single<List<Person>> {
        return Single.fromCallable {
            getPerson()
        }
    }
    override fun getAddressWithObservable():Single<List<Pair<String,String>>>{
        return Single.fromCallable {
            getAddress()
        }
    }
}