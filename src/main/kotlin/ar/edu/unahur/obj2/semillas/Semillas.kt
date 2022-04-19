package ar.edu.unahur.obj2.semillas

open class Planta(var altura: Double, val anioSemilla: Int) {

    open fun horasDeSolToleradas() = 7

    //Una planta es fuerte cuando tolera más de 9 horas de sol
    open fun esFuerte() = this.horasDeSolToleradas() > 9

    //Una planta da semillas si es fuerte
    open fun daSemillas() = this.esFuerte()

    open fun espacio() : Double = 0.0

    //Una parcela es ideal para la planta cuando su superficie es mayor a 6
    open fun esParcelaIdeal(parcela: Parcelas) = parcela.superficie() > 6



}

open class Menta(altura : Double,  anioSemilla: Int) : Planta(altura, anioSemilla) {

    //Menta da semillas si es más alta que 0.4 metros o es fuerte
    override fun daSemillas() = this.altura > 0.4 || super.daSemillas()

    //El espacio de la Menta es su altura más 1.0
    override fun espacio() = this.altura + 1.0


}

open class Soja(altura : Double,  anioSemilla: Int) : Planta(altura, anioSemilla) {
    override fun espacio() = altura / 2

    override fun daSemillas() = super.daSemillas() || (anioSemilla > 2007 && altura in 0.75..0.9)

    override fun horasDeSolToleradas() = if(altura < 0.5) {6}
        else if (altura < 1) {8} else {12}

    override fun esParcelaIdeal(parcela: Parcelas) = parcela.horasDeSol == this.horasDeSolToleradas()
}

class Quinoa(altura : Double,  anioSemilla: Int,val espacioQuinoa : Double) : Planta(altura, anioSemilla) {
    override fun espacio() = espacioQuinoa

    override fun horasDeSolToleradas() = if(espacioQuinoa < 0.3) {10} else {super.horasDeSolToleradas()}

    override fun daSemillas(): Boolean {
        return super.daSemillas() || anioSemilla in 2001..2008
    }

    override fun esParcelaIdeal(parcela: Parcelas) = !parcela.plantas.any{it.altura <= 1.5}
}

class SojaTransgenica(altura : Double,  anioSemilla: Int) : Soja(altura, anioSemilla) {
    override fun daSemillas() = false

    override fun esParcelaIdeal(parcela: Parcelas) = parcela.cantMaximaDePlantas().equals(1.0)
}

class Peperina(altura : Double,  anioSemilla: Int) : Menta(altura, anioSemilla) {
    override fun espacio() = super.espacio() * 2


}