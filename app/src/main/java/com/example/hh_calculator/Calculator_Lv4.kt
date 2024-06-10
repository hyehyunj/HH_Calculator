package com.example.hh_calculator

fun main() {

    var num1 : Int = 0
    while (true) {
        println("첫번째 숫자를 입력해주세요.")
        num1 = readLine()!!.toInt()


        println("${num1}에 무엇을 해드릴까요?")
        println("1 : 더하기, 2 : 빼기, 3 : 곱하기, 4 : 나누기, 5 : 나머지 구하기, -1 : 그만하기")
        val operator = readLine()!!.toInt()

        if(operator == -1) {
            println("계산을 종료합니다.")
            break
        }

        println("두번째 숫자를 입력해주세요.")
        val num2 = readLine()!!.toInt()

        //인스턴스화
        val addOperation = Calculator(AddOperation())
        val subtractOperation = Calculator(SubtractOperation())
        val multipleOperation = Calculator(MultipleOperation())
        val divideOperation = Calculator(DivideOperation())

        when (operator) {
            1 -> {//더하기
                num1 = addOperation.calculate(num1, num2)
                addOperation.printResult(num1)}
            2 ->{//빼기
                num1 = subtractOperation.calculate(num1, num2)
                subtractOperation.printResult(num1)}
            3 ->{//곱하기
                num1 = multipleOperation.calculate(num1, num2)
                multipleOperation.printResult(num1)}
            4 ->{//나누기
                num1 = divideOperation.calculate(num1, num2)
                divideOperation.printResult(num1)}
            5 -> {//나머지 구하기
                num1 = num1 % num2
                println("나머지는 ${num1} 입니다.")
                println("-----------------------")}
        }
    }
}
//부모 클래스
open class Calculator(val abstractOperation: AbstractOperation) {
    open fun calculate(a: Int, b: Int) : Int = abstractOperation.calculate(a, b)
    open fun printResult(a:Int) = abstractOperation.printResult(a)
}
//추상 클래스
abstract class AbstractOperation {
    abstract fun calculate(a: Int, b: Int) : Int
    abstract fun printResult(a:Int)
}
//더하기 클래스
class AddOperation : AbstractOperation() {
    override fun calculate(a: Int, b: Int): Int = a + b
    override fun printResult(a: Int) {
        println("덧셈 결과는 ${a} 입니다.")
        println("-----------------------")
    }
}
//빼기 클래스
class SubtractOperation : AbstractOperation() {
    override fun calculate(a: Int,b: Int) : Int = a - b
    override fun printResult(a: Int) {
        println("뺄셈 결과는 ${a} 입니다.")
        println("-----------------------")
    }
}
//곱하기 클래스
class MultipleOperation : AbstractOperation() {
    override fun calculate(a: Int,b: Int) : Int = a * b
    override fun printResult(a: Int) {
        println("곱셈 결과는 ${a} 입니다.")
        println("-----------------------")
    }
}
//나누기 클래스
class DivideOperation : AbstractOperation() {
    override fun calculate(a: Int,b: Int) : Int = a / b
    override fun printResult(a: Int) {
        println("나눗셈 결과는 ${a} 입니다.")
        println("-----------------------")
    }
}
//나누기 클래스
class RemainderOperation : AbstractOperation() {
    override fun calculate(a: Int,b: Int) : Int = a % b
    override fun printResult(a: Int) {
        println("나눗셈 결과는 ${a} 입니다.")
        println("-----------------------")
    }
}



