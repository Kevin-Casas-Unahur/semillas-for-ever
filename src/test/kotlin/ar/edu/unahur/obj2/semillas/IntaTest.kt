package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.floats.shouldBeBetween
import io.kotest.matchers.shouldBe

class IntaTest : DescribeSpec ({

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

        }

        it("3 parcelas, todas con 4 o mas plantas, y una con el 80, 75 y 50 % de plantas bien asociadas") {
            val laMasSustentable = Inta.masSustentable()
            laMasSustentable.porcentajeBienAsociadas().shouldBeBetween(79.0F, 81.0F, 0.1F)
        }
    }
})