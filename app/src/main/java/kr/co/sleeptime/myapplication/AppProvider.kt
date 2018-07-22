package kr.co.sleeptime.myapplication

import android.app.Application
import kr.co.sleeptime.myapplication.data.PersonRepository
import kr.co.sleeptime.myapplication.domain.IPersonRepository
import kr.co.sleeptime.myapplication.domain.usecase.PersonAgeUseCase

class AppProvider(application: Application) {
    val personRepository: IPersonRepository by lazy { PersonRepository() }
    val personAgeUseCase: PersonAgeUseCase by lazy { PersonAgeUseCase(personRepository) }
}