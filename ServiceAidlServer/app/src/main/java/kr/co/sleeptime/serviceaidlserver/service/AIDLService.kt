package kr.co.sleeptime.serviceaidlserver.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.Process
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import kr.co.sleeptime.serviceaidlserver.IMyAidlCallback
import kr.co.sleeptime.serviceaidlserver.IMyAidlInterface
import kr.co.sleeptime.serviceaidlserver.entity.Person

class AIDLService : Service() {
    override fun onBind(p0: Intent?): IBinder {
        return _binder
    }

    private var _myAidlCallback: IMyAidlCallback? = null

    private val _binder = object : IMyAidlInterface.Stub() {
        override fun createPerson(name: String?, age: Int) {
            Single
                    .fromCallable {
                        Thread.sleep(1000)
                        val newName = if (name.isNullOrBlank()) "noname" else name!!
                        Person(newName, age)
                    }
                    .subscribeOn(Schedulers.computation())
                    .subscribe { result, throwable ->
                        _myAidlCallback?.onCreatePerson(result)
                    }
        }

        override fun registerCallback(callback: IMyAidlCallback?) {
            _myAidlCallback = callback
        }

        override fun unregisterCallback(callback: IMyAidlCallback?) {
            _myAidlCallback = null
        }

        override fun getPid(): Int {
            return Process.myPid()
        }
    }
}