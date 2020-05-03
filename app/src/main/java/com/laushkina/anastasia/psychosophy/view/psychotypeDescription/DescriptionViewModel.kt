package com.laushkina.anastasia.psychosophy.view.psychotypeDescription

import android.graphics.drawable.Drawable

class DescriptionViewModel(val firstFunctionDescription: CharSequence?,
                           val secondFunctionDescription: CharSequence?,
                           val thirdFunctionDescription: CharSequence?,
                           val forthFunctionDescription: CharSequence?,
                           val shortDescription: CharSequence?,
                           val image: Drawable?) {

    constructor(builder: Builder) : this(
            builder.firstFunctionDescription,
            builder.secondFunctionDescription,
            builder.thirdFunctionDescription,
            builder.forthFunctionDescription,
            builder.shortDescription,
            builder.image
    )


    class Builder {
        var firstFunctionDescription: CharSequence? = null
        var secondFunctionDescription: CharSequence? = null
        var thirdFunctionDescription: CharSequence? = null
        var forthFunctionDescription: CharSequence? = null
        var shortDescription: CharSequence? = null
        var image: Drawable? = null

        fun firstFunctionDescription(firstFunctionDescription: CharSequence): Builder {
            this.firstFunctionDescription = firstFunctionDescription
            return this
        }

        fun secondFunctionDescription(secondFunctionDescription: CharSequence): Builder {
            this.secondFunctionDescription = secondFunctionDescription
            return this
        }

        fun thirdFunctionDescription(thirdFunctionDescription: CharSequence): Builder {
            this.thirdFunctionDescription = thirdFunctionDescription
            return this
        }

        fun forthFunctionDescription(forthFunctionDescription: CharSequence): Builder {
            this.forthFunctionDescription = forthFunctionDescription
            return this
        }

        fun shortDescription(shortDescription: CharSequence): Builder {
            this.shortDescription = shortDescription
            return this
        }

        fun image(image: Drawable): Builder {
            this.image = image
            return this
        }

        fun build(): DescriptionViewModel {
            return DescriptionViewModel(this)
        }
    }
}