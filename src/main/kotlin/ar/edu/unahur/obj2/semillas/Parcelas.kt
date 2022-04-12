package ar.edu.unahur.obj2.semillas

class Parcelas(private val ancho : Double, private val largo : Double, val horasDeSol : Int) {
    var plantas = mutableListOf<Planta>()

    fun superficie() = ancho * largo

    fun cantMaximaDePlantas() = if(ancho > largo) {this.superficie() / 5} else {(this.superficie() / 3) + largo}

    fun tieneComplicaciones() = plantas.any{ it.horasDeSolToleradas() < horasDeSol }

    fun plantar(semilla : Planta) {if (plantas.size < this.cantMaximaDePlantas()) {
    plantas.add(semilla)} }
}