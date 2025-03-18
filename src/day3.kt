// Solution to https://adventofcode.com/2024/day/3

fun main() {
    // Initialization
    val instruction = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"

    var result = 0

    /**
     * Define Regex to only get valid mul operations
     * Valid operations: "mul(a,b)" with a and b numbers composed of  1 to 3 digits
     */
    val patternOperations = "mul\\(\\d{1,3},\\d{1,3}\\)"
    val matches = Regex(patternOperations).findAll(instruction)

    println("Operations found: ")
    // Process all valid operations
    for (match in matches) {
        // Gather the two factors and multiply them
        val matchValues = Regex("(\\d+),(\\d+)").find(match.value)!!
        val (a, b) = matchValues.destructured
        val mulResult = mul(a, b)

        println(match.value + " = " + mulResult + ";")
        result += mulResult
    }

    println("Sum of all operations: $result.")
}

fun mul(a: String, b: String): Int {
    return a.toInt() * b.toInt()
}