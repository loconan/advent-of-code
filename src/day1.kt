import kotlin.math.abs

fun main() {
    // Initialization
    val l1 = listOf(3, 4, 2, 1, 3, 3)
    val l2 = listOf(4, 3, 5, 3, 9, 3)

    var result = 0

    // Sort the two lists from smallest to highest
    val sortedL1 = l1.sorted()
    val sortedL2 = l2.sorted()

    for (i in sortedL1.indices) {
        // Get the distance between the two lists for each index
        val distance = abs(sortedL1[i] - sortedL2[i])

        println("Distance between ${sortedL1[i]} and ${sortedL2[i]}: $distance")
        result += distance
    }

    println("Total distance: $result")
}