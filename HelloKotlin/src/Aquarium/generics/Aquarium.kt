package Aquarium.generics

open class WaterSupply(var needsProcessed: Boolean)

class TapWater : WaterSupply(true) {
    fun addChemicalCleaners() {
        needsProcessed = false
    }
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true) {
    fun filter() {
        needsProcessed = false
    }
}

class Aquarium<out T: WaterSupply>(val waterSupply: T) {

    fun addWater() {
        // lazyMessage shown if water needs to be processed (argument false)
        check(!waterSupply.needsProcessed) { "water supply needs processed" }
        println("adding water from $waterSupply")
    }

    // Using in type
    fun addWater(cleaner: Cleaner<T>) {
        if (waterSupply.needsProcessed) {
            cleaner.clean(waterSupply)
        }
        println("adding water from $waterSupply")
    }

//    // Generic function
//    inline fun <reified R : WaterSupply> hasWaterSupplyOfType() = waterSupply is R   // return true if T is R
}

fun genericExample() {

    val aquarium = Aquarium(TapWater())  // Type inference
//    val aquarium = Aquarium<TapWater>(TapWater())
    aquarium.waterSupply.addChemicalCleaners()  // No casting necessary. Generics

    // By default, all type and null are accepted
//    val aquarium2 =  Aquarium("string")
//    println(aquarium2.waterSupply)
//
//    val aquarium3 =  Aquarium(null)
//    aquarium3.waterSupply

    val aquarium4 = Aquarium(LakeWater())
    aquarium4.waterSupply.filter()
    aquarium4.addWater()

    addItemTo(aquarium)  // no compile error if T declared as out type

    // Using in type
    val cleaner = TapWaterCleaner()
    val aquarium5 = Aquarium(TapWater())
    aquarium5.addWater(cleaner)

    // Calling generic function
    aquarium.hasWaterSupplyOfType<TapWater>()  // true

    // Calling reified extension function
    aquarium.waterSupply.isOfType<LakeWater>()  // false
}

/*
  - Out type example function -
 */
fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added")


/*
  - In type example -
 */
interface Cleaner<in T: WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner : Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }
}

/*
  Generic function
  Here T is a type parameter to isWaterClean used to specify the generic type of the aquarium
 */
fun <T: WaterSupply> isWaterClean(aquarium: Aquarium<T>) {
    println("aquarium water is clean: ${aquarium.waterSupply.needsProcessed}")  // OK if Aquarium has an out type
}
//fun isWaterClean(aquarium: Aquarium<WaterSupply>) {
//    println("auarium water is clean: ${aquarium.waterSupply.needsProcessed}")  // OK if Aquarium has an out type
//}

/*
 Reified extension function
 */
inline fun <reified T: WaterSupply> WaterSupply.isOfType() = this is T

// Making it an extension function - The type of aquarium does not matter here (hence *)
inline fun <reified R : WaterSupply> Aquarium<*>.hasWaterSupplyOfType() = waterSupply is R