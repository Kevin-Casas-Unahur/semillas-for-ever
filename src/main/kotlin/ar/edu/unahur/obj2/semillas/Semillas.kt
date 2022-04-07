package ar.edu.unahur.obj2.semillas

open class Planta(var altura: Double, val anioSemilla: Int) {


    fun horasDeSolToleradas() = 7

    fun esFuerte() = this.horasDeSolToleradas() > 9

    fun daNuevasSemillas() = this.esFuerte()

    fun espacio() = 0

}

class Menta(var altura, val anioSemilla: Int) {

    fun espacio(): Double {
        TODO("Te la debo, amigue...")
    }

    fun daSemillas(): Boolean {
        TODO("Colgue, che...")
    }

    fun esFuerte(): Boolean {
        TODO("Estas seguro que lo queres implementar así?")
    }

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

