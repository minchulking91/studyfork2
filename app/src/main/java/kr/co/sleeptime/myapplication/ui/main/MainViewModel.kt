package kr.co.sleeptime.myapplication.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import kr.co.sleeptime.myapplication.MyApp
import kr.co.sleeptime.myapplication.domain.IPersonRepository
import kr.co.sleeptime.myapplication.domain.asynctask.PersonAgeAsyncTask
import kr.co.sleeptime.myapplication.domain.usecase.PersonAgeUseCase

class MainViewModel(app: Application) : AndroidViewModel(app) {
    private val personRepository: IPersonRepository
    private val personAgeUseCase: PersonAgeUseCase

    val age: MutableLiveData<Int> = MutableLiveData()

    init {
        val appProvider = getApplication<MyApp>().appProvider
        personRepository = appProvider.personRepository
        personAgeUseCase = appProvider.personAgeUseCase
    }

    fun calculateAge() {
        personAgeUseCase.run()
                .map { it }
                .flatMap {
                    Single.fromCallable { it }
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { result, throwable ->
                    if (throwable != null) {
                        //TODO error handling
                    } else {
                        age.value = result
                    }
                }

        personRepository.getPersonWithCallback { persons ->
            personRepository.getAddressWithCallback { address ->
                PersonAgeAsyncTask(persons, address) {
                    age.value = it
                }
                        .execute()
            }
        }
    }


}
