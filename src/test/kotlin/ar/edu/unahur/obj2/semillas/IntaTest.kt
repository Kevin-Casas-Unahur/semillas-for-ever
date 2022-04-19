package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class IntaTest : DescribeSpec ({
    describe("Set de estadísticas del instituto Inta") {

        it("El promedio de 0 plantas") {
            Inta.promedioPlantasPorParcela().shouldBe(0)
        }
    }
})