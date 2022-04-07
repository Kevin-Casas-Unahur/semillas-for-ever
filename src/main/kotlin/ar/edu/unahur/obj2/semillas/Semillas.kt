package ar.edu.unahur.obj2.semillas

open class Planta(var altura: Double, val anioSemilla: Int) {

    open fun horasDeSolToleradas() = 7

    open fun esFuerte() = this.horasDeSolToleradas() > 9

    open fun daSemillas() = this.esFuerte()

    open fun espacio() : Double = 0.0

}

class Menta(altura : Double,  anioSemilla: Int) : Planta(altura, anioSemilla) {

   override fun daSemillas() = this.altura > 0.4 || super.daSemillas()

    override fun espacio() = this.altura + 1.0

}

class Soja(altura : Double,  anioSemilla: Int) : Planta(altura, anioSemilla) {
    override fun espacio() = altura / 2

    override fun daSemillas() = super.daSemillas() || (anioSemilla > 2007 && altura in 0.75..0.9)

    override fun horasDeSolToleradas() = if(altura < 0.5) {6}
        else if (altura in 0.5..1.0) {8} else {12} }

class Quinoa(altura : Double,  anioSemilla: Int,val espacioQuinoa : Double) : Planta(altura, anioSemilla) {
    override fun espacio() = espacioQuinoa


}