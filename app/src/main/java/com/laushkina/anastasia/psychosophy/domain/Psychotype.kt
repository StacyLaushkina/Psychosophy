package com.laushkina.anastasia.psychosophy.domain

import android.os.Parcel
import android.os.Parcelable
import com.laushkina.anastasia.psychosophy.domain.test.PsychoFunction

enum class Psychotype(val functions: Array<PsychoFunction>) : Parcelable {
    Augustine(arrayOf(PsychoFunction.Logic, PsychoFunction.Emotion, PsychoFunction.Physics, PsychoFunction.Will)),
    Pascal(arrayOf(PsychoFunction.Logic, PsychoFunction.Emotion, PsychoFunction.Will, PsychoFunction.Physics)),
    Berthier(arrayOf(PsychoFunction.Logic, PsychoFunction.Physics, PsychoFunction.Emotion, PsychoFunction.Will)),
    Plato(arrayOf(PsychoFunction.Logic, PsychoFunction.Physics, PsychoFunction.Will, PsychoFunction.Emotion)),
    Lao(arrayOf(PsychoFunction.Logic, PsychoFunction.Will, PsychoFunction.Physics, PsychoFunction.Emotion)),
    Einstein(arrayOf(PsychoFunction.Logic, PsychoFunction.Will, PsychoFunction.Emotion, PsychoFunction.Physics)),

    Anderson(arrayOf(PsychoFunction.Emotion, PsychoFunction.Logic, PsychoFunction.Will, PsychoFunction.Physics)),
    Rousseau(arrayOf(PsychoFunction.Emotion, PsychoFunction.Logic, PsychoFunction.Physics, PsychoFunction.Will)),
    Bukharin(arrayOf(PsychoFunction.Emotion, PsychoFunction.Physics, PsychoFunction.Logic, PsychoFunction.Will)),
    Pushkin(arrayOf(PsychoFunction.Emotion, PsychoFunction.Physics, PsychoFunction.Will, PsychoFunction.Logic)),
    Ghazali(arrayOf(PsychoFunction.Emotion, PsychoFunction.Will, PsychoFunction.Logic, PsychoFunction.Physics)),
    Parsnip(arrayOf(PsychoFunction.Emotion, PsychoFunction.Will, PsychoFunction.Physics, PsychoFunction.Logic)),

    Aristippus(arrayOf(PsychoFunction.Physics, PsychoFunction.Logic, PsychoFunction.Will, PsychoFunction.Emotion)),
    Epicurus(arrayOf(PsychoFunction.Physics, PsychoFunction.Logic, PsychoFunction.Emotion, PsychoFunction.Will)),
    Borgia(arrayOf(PsychoFunction.Physics, PsychoFunction.Emotion, PsychoFunction.Logic, PsychoFunction.Will)),
    Dumas(arrayOf(PsychoFunction.Physics, PsychoFunction.Emotion, PsychoFunction.Will, PsychoFunction.Logic)),
    Goethe(arrayOf(PsychoFunction.Physics, PsychoFunction.Will, PsychoFunction.Logic, PsychoFunction.Emotion)),
    Chekhov(arrayOf(PsychoFunction.Physics, PsychoFunction.Will, PsychoFunction.Emotion, PsychoFunction.Logic)),

    Akhmatova(arrayOf(PsychoFunction.Will, PsychoFunction.Emotion, PsychoFunction.Logic, PsychoFunction.Physics)),
    Tolstoy(arrayOf(PsychoFunction.Will, PsychoFunction.Emotion, PsychoFunction.Physics, PsychoFunction.Logic)),
    Lenin(arrayOf(PsychoFunction.Will, PsychoFunction.Logic, PsychoFunction.Physics, PsychoFunction.Emotion)),
    Socrates(arrayOf(PsychoFunction.Will, PsychoFunction.Logic, PsychoFunction.Emotion, PsychoFunction.Physics)),
    Napoleon(arrayOf(PsychoFunction.Will, PsychoFunction.Physics, PsychoFunction.Logic, PsychoFunction.Emotion)),
    Twardowski(arrayOf(PsychoFunction.Will, PsychoFunction.Physics, PsychoFunction.Emotion, PsychoFunction.Logic));

    companion object {
        private val DEFAULT = Augustine

        @JvmField
        val CREATOR = object : Parcelable.Creator<Psychotype> {
            override fun createFromParcel(parcel: Parcel): Psychotype {
                return resolve(parcel) ?: DEFAULT
            }

            override fun newArray(size: Int): Array<Psychotype?> {
                return arrayOfNulls(size)
            }
        }

        fun resolve(input: Parcel): Psychotype? {
            val parcelType = input.readString()
            return if (parcelType != null) valueOf(parcelType) else null
        }

        fun resolve(functions: Array<PsychoFunction>): Psychotype? {
            var foundType: Psychotype? = null
            for (psychotype in values()) {
                if (areFunctionsEqual(functions, psychotype.functions)) {
                    foundType = psychotype
                    break
                }
            }
            return foundType
        }

        fun areFunctionsEqual(f1: Array<PsychoFunction>, f2: Array<PsychoFunction>): Boolean {
            return f1.size == 4 && f2.size == 4
                    && f1[0] === f2[0]
                    && f1[1] === f2[1]
                    && f1[2] === f2[2]
                    && f1[3] === f2[3]
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }
}