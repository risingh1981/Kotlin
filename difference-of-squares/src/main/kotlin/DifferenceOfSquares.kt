class Squares(val num: Int){

    // Sum of Squares Formula for “n” numbers
    //= 1^2 + 2^2 + 3^2 + ... + n^2 = [n(n + 1)(2n + 1)] / 6
    fun sumOfSquares(): Int {
        val n = this.num
        return (n*(n + 1)*(2*n + 1)) / 6
    }
    // Sum of First n numbers:
    // 1 + 2 + 3 +... + n = (n(n+1))/2
    fun squareOfSum(): Int{
        val n = this.num
        val sum = (n*(n+1))/2
        return sum*sum

    }

    fun difference(): Int {
        return (this.squareOfSum() - this.sumOfSquares())
    }
}