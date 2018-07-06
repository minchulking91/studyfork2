// IMyAidlInterface.aidl
package kr.co.sleeptime.serviceaidlserver;

// Declare any non-default types here with import statements
import kr.co.sleeptime.serviceaidlserver.IMyAidlCallback;
interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    oneway void registerCallback(IMyAidlCallback callback);
    oneway void unregisterCallback(IMyAidlCallback callback);
    oneway void createPerson(String name, int age);
    int getPid();
}
