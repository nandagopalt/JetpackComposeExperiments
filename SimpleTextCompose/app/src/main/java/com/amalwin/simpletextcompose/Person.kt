package com.amalwin.simpletextcompose

public open class Person constructor(public val age: Int = 10) {
    init {
        println("Hi, I am from Person init{} block !")
    }

    open fun speak(language: String = "Tamil"): Unit {
        val message = "I am a simple person who can speak in $language and my age is $age."
        print(message)
    }
}

public open class Teacher constructor(age :Int): Person(age) {
    init {
        println("Hi, I am from Teacher init{} block")
    }
    override fun speak(language: String): Unit {
        val message = "I am a teacher who can speak in $language and my age is $age"
        println(message)
    }
    open fun teach(role: String = "Teacher"): String {
        val message = "I am $role and can teach"
        return message
    }
}

fun main(args: Array<String>) {
    var simplePerson: Person = Person(age = 20)
    simplePerson.speak(language = "English")
    var teacher: Teacher = Teacher(age = 30)
    teacher.speak(language = "Hindi")
    println(teacher.teach())
    teacher = Teacher(50)
    teacher.speak("Marati")

}