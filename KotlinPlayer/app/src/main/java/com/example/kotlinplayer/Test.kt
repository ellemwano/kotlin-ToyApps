package com.example.kotlinplayer

/*
  Class with constructor and direct assignment
 */
open class Person(val name:String, val age:Int)

/*
  Class extending from Person (Person needs to be declared "open"
  (If class is abstract, open by default)
  Parent constructor has to be called
  Here, every developer is 20
 */
class Developer(name: String) : Person(name, 20)


fun test() {
    val person = Person("John", 30)
    val age = person.age
    val name = person.name
}



/*
  Class with custom getter and setter
 */
open class Person2(name:String, val age:Int) {
    var name: String = name
    get() = "Name: $field"
    set(value) {
        if (value != field) {
            field = value
        }
    }
}


/*
  Class with several constructors
 */
open class Person3(name: String = "Peter", val age: Int = 20)

class Developer2: Person3 {
    constructor(name: String) : super(name)
    constructor(age: Int) : super(age = age)
}


