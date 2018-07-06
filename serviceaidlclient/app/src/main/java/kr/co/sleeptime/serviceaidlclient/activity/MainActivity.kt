package kr.co.sleeptime.serviceaidlclient.activity

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.os.Process
import android.os.RemoteException
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kr.co.sleeptime.serviceaidlclient.R
import kr.co.sleeptime.serviceaidlclient.SERVICE_ACTION
import kr.co.sleeptime.serviceaidlclient.SERVICE_PACKAGE
import kr.co.sleeptime.serviceaidlserver.IMyAidlCallback
import kr.co.sleeptime.serviceaidlserver.IMyAidlInterface
import kr.co.sleeptime.serviceaidlserver.entity.Person


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindMyService()
        createButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val age = ageEditText.text.toString().toIntOrNull() ?: 0
            val pid: Int?
            try {
                _remoteService?.createPerson(name, age)
                pid = _remoteService?.pid
                Toast.makeText(this@MainActivity, "$pid", Toast.LENGTH_SHORT).show()

            } catch (e: RemoteException) {
                e.printStackTrace()
            }
        }
    }

    private fun bindMyService() {
        val serviceIntent = Intent(SERVICE_ACTION).apply {
            `package` = SERVICE_PACKAGE
        }
        serviceStateTextView.text = "request bind service"
        bindService(serviceIntent, serviceConnection, Context.BIND_AUTO_CREATE)
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(serviceConnection)
    }

    private var _remoteService: IMyAidlInterface? = null
    private val serviceConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(componentName: ComponentName?) {
            serviceStateTextView.text = "service disconnected"
            _remoteService?.unregisterCallback(_remoteCallback)
            _remoteService = null
        }

        override fun onServiceConnected(componentName: ComponentName?, binder: IBinder?) {
            serviceStateTextView.text = "service connected"
            _remoteService = IMyAidlInterface.Stub.asInterface(binder)
            _remoteService?.registerCallback(_remoteCallback)
        }
    }

    private val _remoteCallback: IMyAidlCallback = object : IMyAidlCallback.Stub() {
        override fun onCreatePerson(person: Person?) {
            Single
                    .create<Person> {
                        if (person == null) {
                            it.onError(IllegalStateException())
                        } else {
                            it.onSuccess(person)
                        }
                    }
                    .subscribeOn(Schedulers.computation())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe { result, throwable ->
                        resultTextView.text = result.toString()

                    }
        }

        override fun getPid(): Int {
            return Process.myPid()
        }
    }
}
