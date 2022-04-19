package ar.edu.unahur.obj2.semillas

open class Parcelas(private val ancho : Double, private val largo : Double, val horasDeSol : Int) {
    var plantas = mutableListOf<Planta>()

    fun superficie() = ancho * largo

    fun cantMaximaDePlantas() = if(ancho > largo) {this.superficie() / 5} else {(this.superficie() / 3) + largo}

    fun tieneComplicaciones() = plantas.any{ it.horasDeSolToleradas() < horasDeSol }

    fun plantar(semilla : Planta) {if (plantas.size < this.cantMaximaDePlantas()) { plantas.add(semilla)} }

}

open class ParcelaEcologica(ancho : Double, largo : Double, horasDeSol : Int) : Parcelas(ancho ,  largo , horasDeSol) {

    fun seAsociaBien(planta : Planta) = !this.tieneComplicaciones() and planta.esParcelaIdeal(this)

}

open class ParcelaIndustrial(ancho : Double, largo : Double, horasDeSol : Int) : Parcelas(ancho ,  largo , horasDeSol) {

    /*Para que una planta se asocie bien deben haber 2 o menos plantas en la parcela
     Y la planta debe ser fuerte
     */
    fun seAsociaBien(planta : Planta) = (this.plantas.size <= 2) and (planta.esFuerte())

}