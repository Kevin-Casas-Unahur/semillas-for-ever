package ar.edu.unahur.obj2.semillas

class Parcelas(val ancho : Double, val largo : Double, val horasDeSol : Int) {
    var plantas = mutableListOf<Planta>()

    fun superficie() = ancho * largo

    fun cantMaximaDePlantas() = if(ancho > largo) {}
}