package kr.co.sleeptime.serviceaidlserver.entity

import android.os.Parcel
import android.os.Parcelable

data class Person(
        val name: String,
        val age: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString(), parcel.readInt())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(age)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Person> {
        override fun createFromParcel(parcel: Parcel): Person {
            return Person(parcel)
        }

        override fun newArray(size: Int): Array<Person?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String {
        return "Person(name = $name, age = $age)"
    }
}