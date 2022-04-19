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

    //Espacio de Soja es su altura dividida por 2
    override fun espacio() = altura / 2

    //Da semillas si es fuerte o
    // el año de su semilla es mayor a 2007 y su altura está entre 0.75 y 0.9 metros
    override fun daSemillas() = super.daSemillas() || (anioSemilla > 2007 && altura in 0.75..0.9)

    /*
    Si su altura es menor a 0.5 tolera 6 horas,
    Si es mayor a 0.5, pero menor a 1.0 tolera 8 horas
    Y si es igual o mayor a 1.0 tolera 12 horas
     */
    override fun horasDeSolToleradas() = if(altura < 0.5) {6}
        else if (altura < 1) {8} else {12}

    //Es parcela ideal cuando la parcela recibe las mismas horas de sol que las toleradas
    override fun esParcelaIdeal(parcela: Parcelas) = parcela.horasDeSol == this.horasDeSolToleradas()
}

class Quinoa(altura : Double,  anioSemilla: Int,val espacioQuinoa : Double) : Planta(altura, anioSemilla) {
    override fun espacio() = espacioQuinoa

    /*
    Si su espacio es menor a 0.3 metros tolera 10 horas de sol
    de lo contrario tolera 7 horas
     */
    override fun horasDeSolToleradas() = if(espacioQuinoa < 0.3) {10} else {super.horasDeSolToleradas()}

    /*
    Da semillas si es fuerte o el año de su semilla está entre 2001 y 2008
     */
    override fun daSemillas(): Boolean {
        return super.daSemillas() || anioSemilla in 2001..2008
    }

    //Es parcela ideal si no hay ninguna planta con altura menor o igual a 1.5 metros
    override fun esParcelaIdeal(parcela: Parcelas) = !parcela.plantas.any{it.altura <= 1.5}
}

class SojaTransgenica(altura : Double,  anioSemilla: Int) : Soja(altura, anioSemilla) {

    //Nunca da semillas
    override fun daSemillas() = false

    //Es parcela ideal si solo hay una planta en la parcela
    override fun esParcelaIdeal(parcela: Parcelas) = parcela.cantMaximaDePlantas().equals(1.0)
}

class Peperina(altura : Double,  anioSemilla: Int) : Menta(altura, anioSemilla) {

    //Su espacio es su altura + 1.0 multiplicado por 2
    override fun espacio() = super.espacio() * 2


}