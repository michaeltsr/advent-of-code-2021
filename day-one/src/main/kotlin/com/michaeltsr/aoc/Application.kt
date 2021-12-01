package com.michaeltsr.aoc

fun main() {
    Application().dayOne()
}

class Application {
    fun dayOne() {
        val input = javaClass.getResource("/input.txt")!!.readText().split("\n")
            .filter { it.isNotBlank() }
            .map { Integer.parseInt(it.trim()) }

        fun partOne(data: List<Int>): Int {
            return data.filterIndexed { index, i -> i < (data.getOrNull(index + 1) ?: i) }.count()
        }

        fun partTwo(data: List<Int>) : Int {
            val list = mutableListOf<Int>()
            for(i in data.indices) {
                var result = 0
                repeat(3) {
                    result += data.getOrElse(i + it) {0}
                }
                list.add(result)
            }
            return partOne(list)
        }
        println("Part One Solution: ${partOne(input)}")
        println("Part Two Solution: ${partTwo(input)}")
    }
}