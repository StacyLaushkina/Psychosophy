package com.laushkina.anastasia.psychosophy.domain.test

import com.laushkina.anastasia.psychosophy.domain.Psychotype
import java.util.*

class PsychotypeCalculator {
    private class Pair internal constructor(val function: PsychoFunction, val amount: Int)

    companion object {
        fun calculate(questions: Array<TestQuestion>): List<Psychotype>? {
            val pairs = ArrayList<Pair>()

            val sums = IntArray(4)
            for (question in questions) {
                val function = question.type
                val answer = question.answer
                if (function != null && answer != null) {
                    sums[function.getNumber()] += answer.number
                }
            }

            pairs.add(Pair(PsychoFunction.Logic, sums[PsychoFunction.Logic.getNumber()]))
            pairs.add(Pair(PsychoFunction.Emotion, sums[PsychoFunction.Emotion.getNumber()]))
            pairs.add(Pair(PsychoFunction.Physics, sums[PsychoFunction.Physics.getNumber()]))
            pairs.add(Pair(PsychoFunction.Will, sums[PsychoFunction.Will.getNumber()]))

            pairs.sortWith(Comparator { p1, p2 -> p2.amount - p1.amount })

            return when {
                areResultsUnreliable(pairs) -> null
                isExceptionCase(pairs) -> resolveMultipleTypes(pairs)
                else -> resolveSingleType(pairs)
            }
        }

        // If user has more then two functions with same answer, results are not reliable
        private fun areResultsUnreliable(pairs: List<Pair>): Boolean {
            return pairs[0].amount == pairs[1].amount
                    && pairs[1].amount == pairs[2].amount
                    && pairs[2].amount == pairs[3].amount
        }

        // Exception case is when two or more types are possible
        private fun isExceptionCase(pairs: List<Pair>): Boolean {
            return pairs[0].amount == pairs[1].amount
                    || pairs[1].amount == pairs[2].amount
                    || pairs[2].amount == pairs[3].amount
        }

        private fun resolveSingleType(pairs: List<Pair>): List<Psychotype>? {
            val type = Psychotype.resolve(injectFunctions(pairs))
            return if (type != null) listOf(type) else null
        }

        private fun resolveMultipleTypes(pairs: List<Pair>): List<Psychotype> {
            val typeVariants = ArrayList<Array<PsychoFunction>>()

            val functionsOrder = injectFunctions(pairs)
            typeVariants.add(functionsOrder)

            var tmp: PsychoFunction
            for (i in 0..2) {
                if (pairs[i].amount == pairs[i + 1].amount) {
                    val assumption = Arrays.copyOf(functionsOrder, 4)
                    tmp = assumption[i]
                    assumption[i] = assumption[i + 1]
                    assumption[i + 1] = tmp
                    typeVariants.add(assumption)
                    for (j in i + 1..2) {
                        if (pairs[j].amount == pairs[j + 1].amount) {
                            val assumptionCopy = Arrays.copyOf(assumption, 4)
                            tmp = assumptionCopy[j]
                            assumptionCopy[j] = assumptionCopy[j + 1]
                            assumptionCopy[j + 1] = tmp
                            typeVariants.add(assumptionCopy)
                        }
                    }
                }
            }

            val result = ArrayList<Psychotype>()
            for (assumption in typeVariants) {
                val type = Psychotype.resolve(assumption)
                if (type != null) {
                    result.add(type)
                }
            }

            return result
        }

        private fun injectFunctions(pairs: List<Pair>): Array<PsychoFunction> {
            return arrayOf(pairs[0].function, pairs[1].function, pairs[2].function, pairs[3].function)
        }
    }
}