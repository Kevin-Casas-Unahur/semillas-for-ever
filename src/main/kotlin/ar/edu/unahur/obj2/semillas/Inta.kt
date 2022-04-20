package ar.edu.unahur.obj2.semillas

object Inta {
    val parcelas = mutableListOf<Parcelas>()

    //Retorna el promedio de plantas por parcela
    //Número de plantas en todas las parcelas divididas el número de parcelas
    //Si no hay ninguna parcela retorna 0
    fun promedioPlantasPorParcela() : Int {
        val cantPlantas = parcelas.sumOf { it.plantas.size }
        val cantParcelas = parcelas.size
        return if (cantParcelas == 0) {0} else {cantPlantas / cantParcelas}
    }
}