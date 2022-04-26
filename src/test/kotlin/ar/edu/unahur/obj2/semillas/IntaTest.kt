package ar.edu.unahur.obj2.semillas

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.floats.shouldBeBetween
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith

class IntaTest : DescribeSpec ({



    fun agregarParcela3Con50() {
        val parcelaIndus3 = ParcelaIndustrial(10.0, 10.0, 10)

        val peperina4 = Peperina(1.7, 2021)
        val quinoa = Quinoa(0.2, 2010,3.0)

        parcelaIndus3.plantar(peperina4)
        parcelaIndus3.plantar(quinoa)

        Inta.parcelas.add(parcelaIndus3)
    }

    describe("Promedio por parcelas") {

        it("El promedio de 0 parcelas") {
            Inta.promedioPlantasPorParcela().shouldBe(0)
        }

        it("El promedio de 1 sola parcela es igual a su numero de plantas") {
            val parcelaIndus1 = ParcelaIndustrial(10.0, 10.0, 10)
            val peperina1 = Peperina(0.5, 2021)
            parcelaIndus1.plantar(peperina1)
            Inta.parcelas.add((parcelaIndus1))
            Inta.promedioPlantasPorParcela().shouldBe(parcelaIndus1.plantas.size)
        }

        it("El promedio de 3 sola parcelas con 3, 2 y 1 plantas respectivamente") {
            Inta.parcelas.clear()

            val parcelaIndus1 = ParcelaIndustrial(10.0, 10.0, 10)
            val parcelaIndus2 = ParcelaIndustrial(10.0, 10.0, 10)
            val parcelaEco1 = ParcelaEcologica(10.0, 10.0, 10)

            val peperina1 = Peperina(0.5, 2021)
            val peperina2 = Peperina(0.3, 2021)
            val peperina3 = Peperina(0.7, 2021)

            parcelaIndus1.plantar(peperina1)

            parcelaIndus2.plantar(peperina1)
            parcelaIndus2.plantar(peperina2)

            parcelaEco1.plantar(peperina1)
            parcelaEco1.plantar(peperina2)
            parcelaEco1.plantar(peperina3)

            Inta.parcelas.add((parcelaIndus1))
            Inta.parcelas.add((parcelaIndus2))
            Inta.parcelas.add((parcelaEco1))

            Inta.promedioPlantasPorParcela().shouldBe(2)
        }
    }

    //Completar
    describe("Parcela mas autosustentable") {
        Inta.parcelas.clear()

        it("Si no hay ninguna debe avisar") {
        val exception = shouldThrow<java.lang.RuntimeException>{Inta.masSustentable()}
            exception.message should startWith("No hay Parcelas")
        }

        it("3 parcelas, todas con 4 o mas plantas, y una con el 80, 75 y 50 % de plantas bien asociadas") {
            //Parcela con 80
            val parcelaIndus1 = ParcelaIndustrial(10.0, 10.0, 10)

            val peperina1 = Peperina(0.5, 2021)
            val peperina2 = Peperina(0.3, 2021)
            val peperina3 = Peperina(1.7, 2021)
            val peperina4 = Peperina(1.7, 2021)
            val quinoa = Quinoa(0.2, 2010,3.0)

            parcelaIndus1.plantar(peperina1)
            parcelaIndus1.plantar(peperina2)
            parcelaIndus1.plantar(peperina3)
            parcelaIndus1.plantar(peperina3)
            parcelaIndus1.plantar(quinoa)

            Inta.parcelas.add(parcelaIndus1)

            //Parcela con 75
            val parcelaIndus2 = ParcelaIndustrial(10.0, 10.0, 10)

            parcelaIndus2.plantar(peperina1)
            parcelaIndus2.plantar(peperina2)
            parcelaIndus2.plantar(peperina3)
            parcelaIndus2.plantar(peperina4)
            parcelaIndus2.plantar(quinoa)

            Inta.parcelas.add(parcelaIndus2)

            //Parcela con 50
            val parcelaIndus3 = ParcelaIndustrial(10.0, 10.0, 10)

            parcelaIndus3.plantar(peperina1)
            parcelaIndus3.plantar(peperina2)
            parcelaIndus3.plantar(peperina3)
            parcelaIndus3.plantar(peperina4)
            parcelaIndus3.plantar(quinoa)
            parcelaIndus3.plantar(quinoa)
            parcelaIndus3.plantar(quinoa)
            parcelaIndus3.plantar(quinoa)

            Inta.parcelas.add(parcelaIndus3)

            val laMasSustentable = Inta.masSustentable()

            laMasSustentable.porcentajeBienAsociadas().shouldBeBetween(79.0F, 81.0F, 0.1F)
        }
    }
})