import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.exp
import kotlin.math.pow

fun exponential(input: ComplexNumber): ComplexNumber {
    val realResult = exp(input.real) * cos(input.imag)
    val imagResult = exp(input.real) * sin(input.imag)
    return ComplexNumber(realResult, imagResult)
}

data class ComplexNumber(val real: Double = 0.0, val imag: Double = 0.0) {

    val abs = (this.real.pow(2) + this.imag.pow(2)).pow(0.5)

    fun conjugate(): ComplexNumber {
        return ComplexNumber(real, -imag)
    }

    operator fun plus(addend: ComplexNumber): ComplexNumber {
        return ComplexNumber(this.real + addend.real, this.imag + addend.imag)
    }

    operator fun minus(addend: ComplexNumber): ComplexNumber {
        return ComplexNumber(this.real - addend.real, this.imag - addend.imag)
    }

    operator fun div(divisor: ComplexNumber): ComplexNumber {
        // (a * c + b * d)/(c^2 + d^2) + (b * c - a * d)/(c^2 + d^2) * i
        val a = this.real; val b = this.imag; val c = divisor.real; val d = divisor.imag
        val realResult = (a * c + b * d)/(c.pow(2) + d.pow(2))
        val imagResult = (b * c - a * d)/(c.pow(2) + d.pow(2))
        return ComplexNumber(realResult, imagResult)
    }

    operator fun times(multipliedBy: ComplexNumber): ComplexNumber {
        // (a * c - b * d) + (b * c + a * d) * i
        val a = this.real; val b = this.imag; val c = multipliedBy.real; val d = multipliedBy.imag
        val realResult = (a * c - b * d)
        val imagResult = (b * c + a * d)
        return ComplexNumber(realResult, imagResult)
    }

}
