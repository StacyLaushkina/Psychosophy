package com.laushkina.anastasia.psychosophy.domain.test

import android.os.Parcel
import android.os.Parcelable

class TestQuestion(val text: String,
                   val type: PsychoFunction?,
                   var answer: TestAnswer?) : Parcelable {

    constructor(text: String, type: PsychoFunction?) : this(text, type, null)

    constructor(parcel: Parcel) : this(
            parcel.readString() ?: "",
            functionFromString(parcel.readString()),
            answerFromString(parcel.readString())
    )

    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<TestQuestion> {
            override fun createFromParcel(parcel: Parcel): TestQuestion {
                return TestQuestion(parcel)
            }
            override fun newArray(size: Int) = arrayOfNulls<TestQuestion>(size)
        }

        private fun functionFromString(string: String?): PsychoFunction? {
            return if (string != null) PsychoFunction.valueOf(string) else null
        }

        private fun answerFromString(string: String?): TestAnswer? {
            return if (string != null) TestAnswer.valueOf(string) else null
        }
    }

    override fun writeToParcel(parcel: Parcel?, i: Int) {
        if (parcel == null) {
            return
        }
        parcel.writeString(text)
        parcel.writeString(type?.name)
        parcel.writeString(answer?.name)
    }

    override fun describeContents(): Int {
        return 0
    }



}