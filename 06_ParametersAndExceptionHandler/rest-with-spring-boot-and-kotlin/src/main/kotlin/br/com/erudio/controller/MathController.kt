package br.com.erudio.controller

import br.com.erudio.controller.converters.NumberConverter
import br.com.erudio.exception.UnsupportedMathOperationException
import br.com.erudio.math.SimpleMath
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong
import kotlin.math.sqrt

@RestController
class MathController {

    val counter: AtomicLong = AtomicLong()

    val math: SimpleMath = SimpleMath()

    @RequestMapping(value = ["/sum/{numerOne}/{numerTwo}"])
    fun sum(
        @PathVariable(value = "numerOne") numerOne: String?,
        @PathVariable(value = "numerTwo") numerTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numerOne) || !NumberConverter.isNumeric(numerTwo)) throw UnsupportedMathOperationException(
            "Please set a numreric value"
        )
        return math.sum(NumberConverter.convertToDouble(numerOne), NumberConverter.convertToDouble(numerTwo))
    }

    @RequestMapping(value = ["/subtraction/{numerOne}/{numerTwo}"])
    fun subtraction(
        @PathVariable(value = "numerOne") numerOne: String?,
        @PathVariable(value = "numerTwo") numerTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numerOne) || !NumberConverter.isNumeric(numerTwo)) throw UnsupportedMathOperationException(
            "Please set a numreric value"
        )
        return math.substraction(NumberConverter.convertToDouble(numerOne), NumberConverter.convertToDouble(numerTwo))
    }

    @RequestMapping(value = ["/division/{numerOne}/{numerTwo}"])
    fun division(
        @PathVariable(value = "numerOne") numerOne: String?,
        @PathVariable(value = "numerTwo") numerTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numerOne) || !NumberConverter.isNumeric(numerTwo)) throw UnsupportedMathOperationException(
            "Please set a numreric value"
        )
        return math.division(NumberConverter.convertToDouble(numerOne), NumberConverter.convertToDouble(numerTwo))
    }

    @RequestMapping(value = ["/multiplication/{numerOne}/{numerTwo}"])
    fun multiplication(
        @PathVariable(value = "numerOne") numerOne: String?,
        @PathVariable(value = "numerTwo") numerTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numerOne) || !NumberConverter.isNumeric(numerTwo)) throw UnsupportedMathOperationException(
            "Please set a numreric value"
        )
        return math.multiplication(NumberConverter.convertToDouble(numerOne), NumberConverter.convertToDouble(numerTwo))
    }

    @RequestMapping(value = ["/mean/{numerOne}/{numerTwo}"])
    fun mean(
        @PathVariable(value = "numerOne") numerOne: String?,
        @PathVariable(value = "numerTwo") numerTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numerOne)) throw UnsupportedMathOperationException("Please set a numreric value")
        return math.mean(NumberConverter.convertToDouble(numerOne), NumberConverter.convertToDouble(numerTwo))
    }

    @RequestMapping(value = ["/squareRoot/{numerOne}"])
    fun squareRoot(
        @PathVariable(value = "numerOne") numerOne: String?
    ): Double {
        if (!NumberConverter.isNumeric(numerOne)) throw UnsupportedMathOperationException("Please set a numreric value")
        return math.squareRoot(NumberConverter.convertToDouble(numerOne))
    }
}