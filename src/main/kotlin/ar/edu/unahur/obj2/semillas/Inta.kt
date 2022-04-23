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

    //Completar
    fun masSustentable(): Parcelas {
        if(parcelas.isEmpty()) {
            throw error("No hay Parcelas")
        } else {
        val parcelasConMasDeCuatroPlantas = parcelas.filter { it.plantas.size > 4 }
        val porcentajeParcelaMasSustentable =  parcelasConMasDeCuatroPlantas.maxOf { it.porcentajeBienAsociadas() }
        return parcelasConMasDeCuatroPlantas.find{ it.porcentajeBienAsociadas() == porcentajeParcelaMasSustentable}!!
        }
    }
}