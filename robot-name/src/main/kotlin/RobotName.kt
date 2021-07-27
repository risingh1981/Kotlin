class Robot {
    var letters:CharRange = 'A'..'Z'
    var digits:IntRange = 0..9

    companion object CurrentRobots {
        var robots = mutableListOf<String>()
    }


    var name: String = generate()

    fun reset() {
        var newName = generate()
        robots.remove(name)
        name = newName
    }

    private fun generate():String {
        var trialName: String = letters.random().plus(
            letters.random().plus(digits.random().toString().plus(digits.random().toString().plus(digits.random().toString()))))
        while (trialName in robots) {
            trialName = letters.random().plus(letters.random().plus(digits.random().toString().plus(digits.random().toString().plus(digits.random().toString()))))
        }
        robots.add(trialName)
        return trialName
    }
}