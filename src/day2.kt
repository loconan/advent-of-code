import kotlin.math.abs

// Solution to https://adventofcode.com/2024/day/2

const val DATA_SIZE = 6
const val REPORT_SIZE = 5

fun main() {

    // Initialization
    val report1 = listOf(7, 6, 4, 2, 1)
    val report2 = listOf(1, 2, 7, 8, 9)
    val report3 = listOf(9, 7, 6, 2, 1)
    val report4 = listOf(1, 3, 2, 4, 5)
    val report5 = listOf(8, 6, 4, 4, 1)
    val report6 = listOf(1, 3, 6, 7, 9)

    val data = listOf(report1, report2, report3, report4, report5, report6)

    var numberSafeReports = 0

    // Check all reports
    for (reportIndex in 0..<DATA_SIZE) {
        val levels = data[reportIndex]

        var isReportSafe = true
        var level = 0

        /**
         * If the first two levels are equals, stop checking the report immediately.
         * Otherwise, check whether the first two levels are increasing or decreasing.
         */
        if (levels[0] == levels[1]) {
            println("Report ${reportIndex + 1} is unsafe: ${levels[0]} ${levels[1]} is neither an increase or a decrease.")
            isReportSafe = false
        } else {
            val isIncreasing = levels[0] < levels[1]

            /**
             * Check whether the report is safe or not:
             * - The difference between two levels must be at minimum 1 and at maximum 3;
             * - The levels are supposed to be all increasing or all decreasing.
             */
            do {
                val difference = abs(levels[level] - levels[level + 1])

                // Check if the levels are equals (only the currently selected level is not the first one)
                if (level != 0 && difference == 0) {
                    println("Report ${reportIndex + 1} is unsafe: ${levels[level]} ${levels[level + 1]} is neither an increase or a decrease.")
                    isReportSafe = false
                }

                if (difference > 3) {
                    println("Report ${reportIndex + 1} is unsafe: the difference between ${levels[level]} ${levels[level + 1]} is higher than 3.")
                    isReportSafe = false
                }

                // Check if the levels are all increasing
                if (levels[level] > levels[level + 1] && isIncreasing) {
                    println("Report ${reportIndex + 1} is unsafe: the levels are all supposed to increase, but ${levels[level]} ${levels[level + 1]} is decreasing.")
                    isReportSafe = false
                }

                // Check if the levels are all decreasing
                if (levels[level] < levels[level + 1] && !isIncreasing) {
                    println("Report ${reportIndex + 1} is unsafe: the levels are all supposed to decrease, but ${levels[level]} ${levels[level + 1]} is increasing.")
                    isReportSafe = false
                }

                level++
            } while (isReportSafe && level < REPORT_SIZE - 1)
        }

        if (isReportSafe) {
            println("Report ${reportIndex + 1} is safe.")
            numberSafeReports++
        }

    }

    println("Number of safe reports: $numberSafeReports")
}
