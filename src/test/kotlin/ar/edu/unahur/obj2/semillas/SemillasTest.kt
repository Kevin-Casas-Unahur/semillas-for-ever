package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class SemillasTest : DescribeSpec ({
    // hay una clase Planta que tiene por atributos
    // anioSemilla, altura

    describe("Creación de las plantas") {
        val menta = Menta(1.0, 2021)
        val mentita = Menta(0.3, 2021)
        val soja = Soja(0.6, 2009)
        val quinoa1 = Quinoa(0.2, 2010,3.0)
        val quinoa2 = Quinoa(0.9, 2006,0.6)
        val sojaTransgenica1 = SojaTransgenica(1.2, 2014)
        val sojaTransgenica2 = SojaTransgenica(0.3, 2021)
        val peperina1 = Peperina(1.0, 2021)

        it("probamos los atributos altura  y anioSemilla") {
            menta.altura.shouldBe(1.0)
            menta.anioSemilla.shouldBe(2021)
        }

        it("verificar si da semillas") {
            menta.daSemillas().shouldBeTrue()
            mentita.daSemillas().shouldBeFalse()
            soja.daSemillas().shouldBeFalse()
        }

        it("es fuerte") {
            menta.esFuerte().shouldBeFalse()
            soja.esFuerte().shouldBeFalse()
        }

        it("espacio") {
            menta.espacio().shouldBe(2.0)
            mentita.espacio().shouldBe(1.3)
            soja.espacio().shouldBe(0.3)
        }

        it("verifico la suma de varias") {
            val superficie = mutableListOf(
                soja.espacio(),
                menta.espacio(),
                mentita.espacio()
            ).sum()
            Math.ceil(superficie).shouldBe(4)
        }


    it("verificamos si quinoa da semillas") {
        quinoa1.daSemillas().shouldBeTrue()
        quinoa1.anioSemilla.shouldBe(2010)
        quinoa2.daSemillas().shouldBeTrue()
        quinoa2.anioSemilla.shouldBe(2006)
    }

    it("soja transgenica nunca da semillas") {
        sojaTransgenica1.daSemillas().shouldBeFalse()
        sojaTransgenica2.daSemillas().shouldBeFalse()
    }

    it("verificar que peperina mide el doble que la menta") {
        peperina1.espacio().shouldBe(menta.espacio() * 2)
    }

   }

})

class ParcelasTest : DescribeSpec ({
    describe("Creacion de Parcela y plantas") {
        val parcela1 = Parcelas(20.0, 1.0, 10)
        val sojaTransgenica1 = SojaTransgenica(1.2, 2014)
        val sojaTransgenica2 = SojaTransgenica(1.7, 20007)
        val sojaTransgenica3 = SojaTransgenica(1.9, 2009)
        val sojaTransgenica4 = SojaTransgenica(1.3, 2011)


        it("Superficie de la parcela") {
            parcela1.superficie().shouldBe(20)
        }

        it("Cantidad maxima de plantas") {
            parcela1.cantMaximaDePlantas().shouldBe(4)
        }

        it("verificamos que una parcela no tiene complicaciones") {
            parcela1.plantar(sojaTransgenica1)
            parcela1.plantar(sojaTransgenica2)
            parcela1.plantar(sojaTransgenica3)
            parcela1.plantar(sojaTransgenica4)
            parcela1.tieneComplicaciones().shouldBeFalse()
        }

    }
})

class ParcelasIdealesTest : DescribeSpec ({
    describe("Las plantas identifican parcelas ideale") {
        val parcela1 = Parcelas(20.0, 1.0, 10)
        val parcela2 = Parcelas(20.0, 1.0, 10)
        val parcela3 = Parcelas(20.0, 1.0, 10)
        val menta = Menta(1.0, 2021)
        val soja = Soja(0.6, 2009)
        val sojaTransgenica = SojaTransgenica(1.2, 2014)
        val quinoa = Quinoa(0.2, 2010,3.0)
    }
})