package br.com.erudio.math

import kotlin.math.sqrt

class SimpleMath {

    fun sum(numerOne: Double, numerTwo: Double) = numerOne + numerTwo
    fun substraction(numerOne: Double, numerTwo: Double) = numerOne - numerTwo
    fun division(numerOne: Double, numerTwo: Double) = numerOne / numerTwo
    fun multiplication(numerOne: Double, numerTwo: Double) = numerOne * numerTwo
    fun mean(numerOne: Double, numerTwo: Double) = (numerOne + numerTwo) / 2
    fun squareRoot(numerOne: Double) = sqrt(numerOne)
}