package br.com.erudio.controller

import br.com.erudio.controller.converters.NumberConverter
import br.com.erudio.exception.UnsupportedMathOperationException
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong
import kotlin.math.sqrt

//@RestController
class MathController2 {

    val counter: AtomicLong = AtomicLong()

    @RequestMapping(value = ["/sum/{numerOne}/{numerTwo}"])
    fun sum(
        @PathVariable(value = "numerOne") numerOne: String?,
        @PathVariable(value = "numerTwo") numerTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numerOne) || !NumberConverter.isNumeric(numerTwo)) throw UnsupportedMathOperationException("Please set a numreric value")
        return NumberConverter.convertToDouble(numerOne) + NumberConverter.convertToDouble(numerTwo)
    }

    @RequestMapping(value = ["/subtraction/{numerOne}/{numerTwo}"])
    fun subtraction(
        @PathVariable(value = "numerOne") numerOne: String?,
        @PathVariable(value = "numerTwo") numerTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numerOne) || !NumberConverter.isNumeric(numerTwo)) throw UnsupportedMathOperationException("Please set a numreric value")
        return NumberConverter.convertToDouble(numerOne) - NumberConverter.convertToDouble(numerTwo)
    }

    @RequestMapping(value = ["/division/{numerOne}/{numerTwo}"])
    fun division(
        @PathVariable(value = "numerOne") numerOne: String?,
        @PathVariable(value = "numerTwo") numerTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numerOne) || !NumberConverter.isNumeric(numerTwo)) throw UnsupportedMathOperationException("Please set a numreric value")
        return NumberConverter.convertToDouble(numerOne) / NumberConverter.convertToDouble(numerTwo)
    }

    @RequestMapping(value = ["/multiplication/{numerOne}/{numerTwo}"])
    fun multiplication(
        @PathVariable(value = "numerOne") numerOne: String?,
        @PathVariable(value = "numerTwo") numerTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numerOne) || !NumberConverter.isNumeric(numerTwo)) throw UnsupportedMathOperationException("Please set a numreric value")
        return NumberConverter.convertToDouble(numerOne) * NumberConverter.convertToDouble(numerTwo)
    }

    @RequestMapping(value = ["/mean/{numerOne}/{numerTwo}"])
    fun mean(
        @PathVariable(value = "numerOne") numerOne: String?,
        @PathVariable(value = "numerTwo") numerTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numerOne)) throw UnsupportedMathOperationException("Please set a numreric value")
        return (NumberConverter.convertToDouble(numerOne) + NumberConverter.convertToDouble(numerTwo)) / 2
    }

    @RequestMapping(value = ["/squareRoot/{numerOne}    "])
    fun squareRoot(
        @PathVariable(value = "numerOne") numerOne: String?
    ): Double {
        if (!NumberConverter.isNumeric(numerOne)) throw UnsupportedMathOperationException("Please set a numreric value")
        return sqrt(NumberConverter.convertToDouble(numerOne))
    }
}