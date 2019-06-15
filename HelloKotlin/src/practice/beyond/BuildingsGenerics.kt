package practice.beyond

open class BaseBuildingMaterial(val numberNeeded: Int = 1)

class Wood : BaseBuildingMaterial(4)

class Brick : BaseBuildingMaterial(8)

class Building<out T: BaseBuildingMaterial>(val buildingMaterial: T) {

    val baseMaterialsNeeded: Int = 100
    val actualMaterialsNeeded = buildingMaterial.numberNeeded * baseMaterialsNeeded

    fun build() {
        println("Material needed: $actualMaterialsNeeded of ${buildingMaterial::class.simpleName}")
    }
}

fun main() {
    val building = Building(Wood())
    building.build()  // Material needed: 400 of Wood - (OK)
    isSmallBuilding(Building(Brick()))  // large building
}

// Generic function
fun <T: BaseBuildingMaterial> isSmallBuilding(building: Building<T>) {
    if (building.actualMaterialsNeeded < 500) println("small building") else println("large building")
}





//Solution Code
//open class BaseBuildingMaterial() {
//    open val numberNeeded = 1
//}
//
//class Wood : BaseBuildingMaterial() {
//    override val numberNeeded = 4
//}
//
//class Brick : BaseBuildingMaterial() {
//    override val numberNeeded = 8
//}
//
//class Building<T: BaseBuildingMaterial>(val buildingMaterial: T) {
//
//    val baseMaterialsNeeded = 100
//    val actualMaterialsNeeded = buildingMaterial.numberNeeded * baseMaterialsNeeded
//
//    fun build() {
//        println(" $actualMaterialsNeeded ${buildingMaterial::class.simpleName} required")
//    }
//}
//
//fun main(args: Array<String>) {
//    Building(Wood()).build()
//}
//Output
//400 Wood required
