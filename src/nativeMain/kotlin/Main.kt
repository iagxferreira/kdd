import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.vararg


fun main(args: Array<String>) {
    val parser = ArgParser("kotlin-dd")

    val fileArgs by parser.argument(
        ArgType.String, description = "Key-value arguments (if=..., of=...)"
    ).vararg()

    parser.parse(args)

    val inputFile = fileArgs.find { it.startsWith("if=") }?.substringAfter("=")
        ?: error("Missing 'if=' argument")
    val outputFile = fileArgs.find { it.startsWith("of=") }?.substringAfter("=")
        ?: error("Missing 'of=' argument")

    println("Reading from: $inputFile")
    println("Writing to: $outputFile")
}