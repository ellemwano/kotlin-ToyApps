package Aquarium

import kotlin.math.PI

open class Aquarium (var length: Int = 100, var width: Int = 20, var height: Int = 40){

    // Custom getter and setter (setter needs var)
    open var volume: Int
        get() = width * height * length / 1000
        set(value) {height = (value * 1000) / (width * length)}  // new height

    // max water to put
    open var water = volume * 0.9

    // Additional constructor
    constructor(numberOfFish: Int) : this() { // this - call to default constructor
        val water: Int = numberOfFish * 2000  // cm3
        val tank: Double = water + water * 0.1
        height = (tank / (length * width)).toInt()
    }
}

class TowerTank() : Aquarium() {

    override var water = volume * 0.8

    override var volume: Int
        get() = (width * height * length / 1000 * PI).toInt()
    set(value) {
        height = (value * 1000) / (width * length)
    }
}