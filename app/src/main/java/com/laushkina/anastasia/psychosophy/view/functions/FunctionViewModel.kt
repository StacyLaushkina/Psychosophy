package com.laushkina.anastasia.psychosophy.view.functions

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import android.graphics.drawable.Drawable
import com.laushkina.anastasia.psychosophy.BR

class FunctionViewModel(private var functionTitle: CharSequence,
                        private var functionDescription: CharSequence,
                        private var functionImage: Drawable,
                        private var emotionTitle: String,
                        private var logicTitle: String,
                        private var physicsTitle: String,
                        private var willTitle: String): BaseObservable() {

    constructor(builder: Builder) : this(
            builder.functionTitle,
            builder.functionDescription,
            builder.functionImage,
            builder.emotionTitle,
            builder.logicTitle,
            builder.physicsTitle,
            builder.willTitle)

    @Bindable
    fun getFunctionTitle(): CharSequence {
        return functionTitle
    }

    internal fun setFunctionTitle(functionTitle: CharSequence) {
        this.functionTitle = functionTitle
        notifyPropertyChanged(BR.functionTitle)
    }

    @Bindable
    fun getFunctionDescription(): CharSequence {
        return functionDescription
    }

    internal fun setFunctionDescription(functionDescription: CharSequence) {
        this.functionDescription = functionDescription
        notifyPropertyChanged(BR.functionDescription)
    }

    @Bindable
    fun getFunctionImage(): Drawable {
        return functionImage
    }

    internal fun setFunctionImage(functionImage: Drawable) {
        this.functionImage = functionImage
        notifyPropertyChanged(BR.functionImage)
    }

    fun getEmotionTitle(): String {
        return emotionTitle
    }

    fun getLogicTitle(): String {
        return logicTitle
    }

    fun getPhysicsTitle(): String {
        return physicsTitle
    }

    fun getWillTitle(): String {
        return willTitle
    }


    class Builder {
        lateinit var functionTitle: CharSequence
        lateinit var functionDescription: CharSequence
        lateinit var functionImage: Drawable
        lateinit var emotionTitle: String
        lateinit var logicTitle: String
        lateinit var physicsTitle: String
        lateinit var willTitle: String

        fun functionTitle(functionTitle: CharSequence): Builder {
            this.functionTitle = functionTitle
            return this
        }

        fun functionDescription(functionDescription: CharSequence): Builder {
            this.functionDescription = functionDescription
            return this
        }

        fun functionImage(functionImage: Drawable): Builder {
            this.functionImage = functionImage
            return this
        }

        fun emotionTitle(emotionTitle: String): Builder {
            this.emotionTitle = emotionTitle
            return this
        }

        fun logicTitle(logicTitle: String): Builder {
            this.logicTitle = logicTitle
            return this
        }

        fun physicsTitle(physicsTitle: String): Builder {
            this.physicsTitle = physicsTitle
            return this
        }

        fun willTitle(willTitle: String): Builder {
            this.willTitle = willTitle
            return this
        }

        fun build(): FunctionViewModel {
            return FunctionViewModel(this)
        }
    }
}