class SpaceAge(val ageSeconds: Int) {
    private val secPerYear = 31557600

    fun onEarth(): Double = String.format("%.2f", ageSeconds.toDouble() / secPerYear).toDouble()
    fun onMercury(): Double = String.format("%.2f",ageSeconds.toDouble() / secPerYear / 0.2408467).toDouble()
    fun onVenus(): Double = String.format("%.2f",ageSeconds.toDouble() / secPerYear / 0.61519726).toDouble()
    fun onMars(): Double = String.format("%.2f",ageSeconds.toDouble() / secPerYear / 1.8808158).toDouble()
    fun onJupiter(): Double = String.format("%.2f",ageSeconds.toDouble() / secPerYear / 11.862615).toDouble()
    fun onSaturn(): Double = String.format("%.2f",ageSeconds.toDouble() / secPerYear / 29.447498).toDouble()
    fun onUranus(): Double = String.format("%.2f",ageSeconds.toDouble() / secPerYear / 84.016846).toDouble()
    fun onNeptune(): Double = String.format("%.2f",ageSeconds.toDouble() / secPerYear / 164.79132).toDouble()
}