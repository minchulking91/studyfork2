package kr.co.sleeptime.myapplication.domain.usecase

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import kr.co.sleeptime.myapplication.domain.IPersonRepository
import kr.co.sleeptime.myapplication.entity.Person

/**
 *  * from callback rest api call
 */
class PersonAgeUseCase2(private val personRepository: IPersonRepository) {

    fun run(): Single<Int> {
        val personListSingle = Single.create<List<Person>> { emitter ->
            personRepository.getPersonWithCallback {
                emitter.onSuccess(it)
            }
        }
        val addressListSingle = Single.create<List<Pair<String, String>>> { emitter ->
            personRepository.getAddressWithCallback {
                emitter.onSuccess(it)
            }
        }

        return personListSingle.subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .flatMap { persons ->
                    addressListSingle.map { persons to it }
                }
                .observeOn(Schedulers.computation())
                .map {
                    val persons = it.first
                    val address = it.second
                    val personInSeoul = address.filter { it.second == "서울" }.map { it.first } //서울에 사는 사람들의 이름.
                    val ageInSeoul = persons.filter { person ->
                        personInSeoul.find { it == person.name } != null
                    }.map {
                        it.age
                    }.sum()
                    ageInSeoul
                }

    }
}