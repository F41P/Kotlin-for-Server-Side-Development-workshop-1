package org.example

// 1. กำหนด data class สำหรับเก็บข้อมูลสินค้า
data class Product(val name: String, val price: Double, val category: String)

// 2. สร้างรายการสินค้าตัวอย่าง
val products = listOf(
    Product("Laptop", 35000.0, "Electronics"),
    Product("Smartphone", 25000.0, "Electronics"),
    Product("T-shirt", 450.0, "Apparel"),
    Product("Monitor", 7500.0, "Electronics"),
    Product("Keyboard", 499.0, "Electronics"),
    Product("Jeans", 1200.0, "Apparel"),
    Product("Headphones", 1800.0, "Electronics")
)

// 3. ฟังก์ชันสำหรับคำนวณผลรวมราคาสินค้า Electronics ที่ > 500
fun calculateTotalElectronicsPriceOver500(products: List<Product>): Double {
    return products
        .filter { it.category == "Electronics" && it.price > 500.0 }
        .sumOf { it.price }
}

// 4. ฟังก์ชันสำหรับนับจำนวนสินค้า Electronics ที่ > 500
fun countElecOver500(products: List<Product>): Int {
    return products.count { it.category == "Electronics" && it.price > 500.0 }
}

// 5. ฟังก์ชัน main เพื่อแสดงผล
fun main() {
    println("รายการสินค้าทั้งหมด:")
    products.forEach { println(it) }
    println("--------------------------------------------------")

    // วิธีที่ 1: List แบบ chaining
    val total1 = calculateTotalElectronicsPriceOver500(products)
    println("วิธีที่ 1 (List): Electronics > 500 รวม = $total1 บาท")

    // วิธีที่ 2: Sequence
    val total2 = products
        .asSequence()
        .filter { it.category == "Electronics" }
        .filter { it.price > 500.0 }
        .map { it.price }
        .sum()

    println("วิธีที่ 2 (Sequence): Electronics > 500 รวม = $total2 บาท")
    println("--------------------------------------------------")

    println("กลุ่มราคาไม่เกิน 1,000")
    products.filter { it.price < 1000.0 }.forEach { println(it) }

    println("\nกลุ่มราคา 1,000 - 9,999")
    products.filter { it.price in 1000.0..9999.0 }.forEach { println(it) }

    println("\nกลุ่มราคาเกิน 10,000")
    products.filter { it.price > 10000.0 }.forEach { println(it) }

    println("\n--- อภิปรายความแตกต่างระหว่าง List และ Sequence ---")
    println("List สร้างคอลเลกชันใหม่ทุกขั้นตอน เหมาะกับข้อมูลน้อย")
    println("Sequence ใช้ lazy processing ประหยัดหน่วยความจำ เหมาะกับข้อมูลขนาดใหญ่")
}
