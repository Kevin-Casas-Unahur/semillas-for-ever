package ar.edu.unahur.obj2.semillas

open class Parcelas(private val ancho : Double, private val largo : Double, val horasDeSol : Int) {
    var plantas = mutableListOf<Planta>()

    //Superficie es ancho * largo
    fun superficie() = ancho * largo

    /*
    Si el ancho es mayor que el largo la cantidad maxima de plantas es la superficie dividida 5
    en caso contrario es la superficie dividida por 3 y luego sumada por el largo
     */
    fun cantMaximaDePlantas() = if(ancho > largo) {this.superficie() / 5} else {(this.superficie() / 3) + largo}

    //Tiene complicaciones si alguna de las plantas en la Parcela,
    // tolera menos horas de sol que las que recibe lar parcela
    fun tieneComplicaciones() = plantas.any{ it.horasDeSolToleradas() < horasDeSol }

    //Agrega una planta a la Parcela, siempre y cuando halla lugar
    fun plantar(semilla : Planta) {if (plantas.size < this.cantMaximaDePlantas()) { plantas.add(semilla)} }

}

open class ParcelaEcologica(ancho : Double, largo : Double, horasDeSol : Int) : Parcelas(ancho ,  largo , horasDeSol) {

    /*Para que una planta se asocie bien la parcela no debe tener complicaciones y
    y la parcela debe ser ideal para la planta
    */
    fun seAsociaBien(planta : Planta) = !this.tieneComplicaciones() and planta.esParcelaIdeal(this)

}

open class ParcelaIndustrial(ancho : Double, largo : Double, horasDeSol : Int) : Parcelas(ancho ,  largo , horasDeSol) {

    /*Para que una planta se asocie bien deben haber 2 o menos plantas en la parcela
     Y la planta debe ser fuerte
    */
    fun seAsociaBien(planta : Planta) = (this.plantas.size <= 2) and (planta.esFuerte())

}