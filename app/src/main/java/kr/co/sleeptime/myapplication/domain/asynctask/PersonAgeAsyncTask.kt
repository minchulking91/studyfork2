package kr.co.sleeptime.myapplication.domain.asynctask

import android.os.AsyncTask
import kr.co.sleeptime.myapplication.data.PersonRepository

/**
 * blocking
 */
class PersonAgeAsyncTask(private val personRepository: PersonRepository, private val callback: (Int?) -> Unit) : AsyncTask<Void, Void, Int>() {
    override fun doInBackground(vararg p0: Void?): Int {
        val address = personRepository.getAddress()
        val persons = personRepository.getPerson()
        //서울 사는 사람들의 나이를 합산.
        val personInSeoul = address
                .filter { it.second == "서울" }
                .map { it.first } //서울에 사는 사람들의 이름.
        val ageInSeoul = persons
                .filter { person ->
                    personInSeoul.find { it == person.name } != null
                }.map {
                    it.age
                }.sum()

        return ageInSeoul
    }

    override fun onPostExecute(result: Int?) {
        super.onPostExecute(result)
        callback.invoke(result)
    }
}

