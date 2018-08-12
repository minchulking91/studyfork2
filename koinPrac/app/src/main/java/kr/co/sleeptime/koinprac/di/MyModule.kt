package kr.co.sleeptime.koinprac.di

import kr.co.sleeptime.koinprac.data.MyDummyRepository
import kr.co.sleeptime.koinprac.data.MyRepository
import kr.co.sleeptime.koinprac.domain.Repository
import kr.co.sleeptime.koinprac.ui.MainPresenter
import kr.co.sleeptime.koinprac.ui.MainViewModel
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

object MyModule {
    private val myModule: Module = applicationContext {
        factory {
            MainPresenter(get("api"))
        }
        bean("api") { MyRepository() as Repository }
        bean("dummy") { MyDummyRepository() as Repository }
    }
    private val myViewModelModule: Module = applicationContext {
        viewModel {
            MainViewModel(get())
        }
        bean {
            MyRepository() as Repository
        }
    }

    fun getModules(): List<Module> {
        return listOf(myModule, myViewModelModule)
    }
}