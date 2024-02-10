package br.com.erudio

import br.com.erudio.exception.UnsupportedMathOperationException
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong
import kotlin.math.sqrt

@RestController
class MAthController {

    val counter: AtomicLong = AtomicLong()

    @RequestMapping(value = ["/sum/{numerOne}/{numerTwo}"])
    fun sum(
        @PathVariable(value = "numerOne") numerOne: String?,
        @PathVariable(value = "numerTwo") numerTwo: String?
    ): Double {
        if (!isNumeric(numerOne) || !isNumeric(numerTwo)) throw UnsupportedMathOperationException("Please set a numreric value")
        return convertToDouble(numerOne) + convertToDouble(numerTwo)
    }

    @RequestMapping(value = ["/subtraction/{numerOne}/{numerTwo}"])
    fun subtraction(
        @PathVariable(value = "numerOne") numerOne: String?,
        @PathVariable(value = "numerTwo") numerTwo: String?
    ): Double {
        if (!isNumeric(numerOne) || !isNumeric(numerTwo)) throw UnsupportedMathOperationException("Please set a numreric value")
        return convertToDouble(numerOne) - convertToDouble(numerTwo)
    }

    @RequestMapping(value = ["/division/{numerOne}/{numerTwo}"])
    fun division(
        @PathVariable(value = "numerOne") numerOne: String?,
        @PathVariable(value = "numerTwo") numerTwo: String?
    ): Double {
        if (!isNumeric(numerOne) || !isNumeric(numerTwo)) throw UnsupportedMathOperationException("Please set a numreric value")
        return convertToDouble(numerOne) / convertToDouble(numerTwo)
    }

    @RequestMapping(value = ["/multiplication/{numerOne}/{numerTwo}"])
    fun multiplication(
        @PathVariable(value = "numerOne") numerOne: String?,
        @PathVariable(value = "numerTwo") numerTwo: String?
    ): Double {
        if (!isNumeric(numerOne) || !isNumeric(numerTwo)) throw UnsupportedMathOperationException("Please set a numreric value")
        return convertToDouble(numerOne) * convertToDouble(numerTwo)
    }

    @RequestMapping(value = ["/mean/{numerOne}/{numerTwo}"])
    fun mean(
        @PathVariable(value = "numerOne") numerOne: String?,
        @PathVariable(value = "numerTwo") numerTwo: String?
    ): Double {
        if (!isNumeric(numerOne)) throw UnsupportedMathOperationException("Please set a numreric value")
        return (convertToDouble(numerOne) + convertToDouble(numerTwo)) / 2
    }

    @RequestMapping(value = ["/squareRoot/{numerOne}    "])
    fun squareRoot(
        @PathVariable(value = "numerOne") numerOne: String?
    ): Double {
        if (!isNumeric(numerOne)) throw UnsupportedMathOperationException("Please set a numreric value")
        return sqrt(convertToDouble(numerOne))
    }


    private fun convertToDouble(strNumber: String?): Double {
        if (strNumber.isNullOrBlank()) return 0.0
        val number = strNumber.replace(",".toRegex(), ".")
        return if (isNumeric(number)) number.toDouble() else 0.0
    }

    private fun isNumeric(strNumber: String?): Boolean {
        if (strNumber.isNullOrBlank()) return false;

        val number = strNumber.replace(",".toRegex(), ".")
        return number.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())
    }
}