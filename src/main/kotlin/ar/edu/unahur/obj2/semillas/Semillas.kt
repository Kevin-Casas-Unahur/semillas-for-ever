package ar.edu.unahur.obj2.semillas

open class Planta(var altura: Double, val anioSemilla: Int) {

    open fun horasDeSolToleradas() = 7

    open fun esFuerte() = this.horasDeSolToleradas() > 9

    open fun daSemillas() = this.esFuerte()

    open fun espacio() : Double = 0.0

}

class Menta(altura : Double,  anioSemilla: Int) : Planta(altura, anioSemilla) {

   override fun daSemillas() = this.altura > 0.4 || super.daSemillas()

    fun esFuerte(): Boolean {
        TODO("Estas seguro que lo queres implementar así?")
    }

    override fun espacio() = this.altura + 1.0

}

class Soja(var altura: Double, val anioSemilla: Int) {
    fun espacio(): Double {
        TODO("Lee un poco más el enunciado...")
    }

    fun daSemillas(): Boolean {
        TODO("Dalee")
    }

    fun esFuerte(): Boolean {
        TODO("Así me implementas mejor")
    }
}

