package ar.edu.unahur.obj2.semillas

class Parcelas(val ancho : Double, val largo : Double, val horasDeSol : Int) {
    var plantas = mutableListOf<Planta>()

    fun superficie() = ancho * largo

    fun cantMaximaDePlantas() = if(ancho > largo) {this.superficie() / 5} else {(this.superficie() / 3) + largo}

    fun tieneComplicaciones() = plantas.any { it.horasDeSolToleradas() < horasDeSol }

    fun plantar(semilla : Planta) {if (!plantas.size.equals(this.cantMaximaDePlantas())) {
    plantas.add(semilla)} }
}