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

    open fun seAsociaBien(planta : Planta) = false
    open fun porcentajeBienAsociadas() = 0.0F
}

open class ParcelaEcologica(ancho : Double, largo : Double, horasDeSol : Int) : Parcelas(ancho ,  largo , horasDeSol) {

    /*Para que una planta se asocie bien la parcela no debe tener complicaciones y
    y la parcela debe ser ideal para la planta
    */
    override fun seAsociaBien(planta : Planta) = !this.tieneComplicaciones() and planta.esParcelaIdeal(this)

    //Devuelve el porcentaje de plantas bien asociadas
    override fun porcentajeBienAsociadas() : Float {
        val cantBienAsociadas = plantas.count{this.seAsociaBien(it)}
        return cantBienAsociadas / plantas.size * 100.0F
    }
}

open class ParcelaIndustrial(ancho : Double, largo : Double, horasDeSol : Int) : Parcelas(ancho ,  largo , horasDeSol) {

    /*Para que una planta se asocie bien deben haber 2 o menos plantas en la parcela
     Y la planta debe ser fuerte
    */
    override fun seAsociaBien(planta : Planta) = (this.plantas.size <= 2) and (planta.esFuerte())

    //Devuelve el porcentaje de plantas bien asociadas
    override fun porcentajeBienAsociadas() : Float {
        val cantBienAsociadas = plantas.count{this.seAsociaBien(it)}
        return cantBienAsociadas / plantas.size * 100.0F
    }
}