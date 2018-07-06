// IMyAidlInterface.aidl
package kr.co.sleeptime.serviceaidlserver;

// Declare any non-default types here with import statements
import kr.co.sleeptime.serviceaidlserver.entity.Person;

interface IMyAidlCallback{
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void onCreatePerson(in Person person);
    int getPid();
}
