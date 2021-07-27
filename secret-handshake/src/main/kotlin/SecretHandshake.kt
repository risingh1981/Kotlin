import Signal.*

object HandshakeCalculator {
    fun calculateHandshake(number: Int): List<Signal> {
        val signals = listOf(Signal.WINK, Signal.DOUBLE_BLINK, Signal.CLOSE_YOUR_EYES, Signal.JUMP)
        var binary = number.toString(2)
        var handshakeOps = mutableListOf<Signal>()

        println(binary)

        binary = binary.reversed()
        println(binary)
        var index = 0
        for (char in binary) {
            if (index == 4) {
                handshakeOps.reverse()
                break
            }
            if (char == '1') {
                handshakeOps.add(signals[index])
            }
            index += 1
        }

        return handshakeOps
    }
}