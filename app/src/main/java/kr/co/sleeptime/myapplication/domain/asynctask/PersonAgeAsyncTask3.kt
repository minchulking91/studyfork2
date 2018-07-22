package kr.co.sleeptime.myapplication.domain.asynctask

import android.os.AsyncTask
import kr.co.sleeptime.myapplication.data.PersonRepository

/**
 * from observable (single) rest api call
 */
class PersonAgeAsyncTask3(private val personRepository: PersonRepository, private val callback: (Int?) -> Unit) : AsyncTask<Void, Void, Int>() {
    override fun doInBackground(vararg p0: Void?): Int {
        val personsObservable = personRepository.getPersonWithObservable()
        val addressObservable = personRepository.getAddressWithObservable()

        val ageObservable = personsObservable
                .flatMap { persons ->
                    addressObservable.map { address ->
                        persons to address
                    }
                }
                .map {
                    val address = it.second
                    val persons = it.first
                    val personInSeoul = address
                            .filter { it.second == "서울" }
                            .map { it.first } //서울에 사는 사람들의 이름.
                    val ageInSeoul = persons
                            .filter { person ->
                                personInSeoul.find { it == person.name } != null
                            }.map {
                                it.age
                            }.sum()
                    ageInSeoul
                }

        return try {
            ageObservable.blockingGet()
        } catch (e: Exception) {
            //TODO error handling
            -1
        }
    }

    override fun onPostExecute(result: Int?) {
        super.onPostExecute(result)
        callback.invoke(result)
    }
}

