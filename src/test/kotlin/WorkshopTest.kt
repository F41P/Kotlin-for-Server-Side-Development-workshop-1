import org.example.celsiusToFahrenheit
import org.example.kilometersToMiles
import org.example.products
import org.example.calculateTotalElectronicsPriceOver500
import org.example.countElecOver500
import kotlin.test.Test
import kotlin.test.assertEquals

class WorkshopTest {

    // --- Tests for Workshop #1: Unit Converter ---

    @Test
    fun `test celsiusToFahrenheit with positive value`() {
        val celsiusInput = 20.0
        val expectedFahrenheit = 68.0
        val actualFahrenheit = celsiusToFahrenheit(celsiusInput)
        assertEquals(expectedFahrenheit, actualFahrenheit, 0.001, "20°C should be 68°F")
    }

    @Test
    fun `test celsiusToFahrenheit with zero`() {
        val celsiusInput = 0.0
        val expectedFahrenheit = 32.0
        val actualFahrenheit = celsiusToFahrenheit(celsiusInput)
        assertEquals(expectedFahrenheit, actualFahrenheit, 0.001, "0°C should be 32°F")
    }

    @Test
    fun `test celsiusToFahrenheit with negative value`() {
        val celsiusInput = -10.0
        val expectedFahrenheit = 14.0
        val actualFahrenheit = celsiusToFahrenheit(celsiusInput)
        assertEquals(expectedFahrenheit, actualFahrenheit, 0.001, "-10°C should be 14°F")
    }

    @Test
    fun `test kilometersToMiles with one kilometer`() {
        val kilometersInput = 1.0
        val expectedMiles = 0.621371
        val actualMiles = kilometersToMiles(kilometersInput)
        assertEquals(expectedMiles, actualMiles, 0.001, "1 km should be 0.621371 miles")
    }

    // --- Tests for Workshop #2: Data Analysis Pipeline ---

    @Test
    fun `test calculateTotalElectronicsPriceOver500 using import products`() {
        val expected = 35000.0 + 25000.0 + 7500.0 + 1800.0
        val actual = calculateTotalElectronicsPriceOver500(products)
        assertEquals(expected, actual, 0.001, "Total price of electronics >500 should be $expected")
    }

    @Test
    fun `test countElectronicsOver500`() {
        val expected = 4
        val actual = countElecOver500(products)
        assertEquals(expected, actual, "Count of electronics >500 should be $expected")
    }
}
