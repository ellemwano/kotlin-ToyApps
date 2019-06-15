package Aquarium

import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.findAnnotation

@ImAPlant class Plant {
    fun trim() {}
    fun fertilize() {}

    // apply OnGet to isgrowing getter
    @get:OnGet
    val isGrowing: Boolean = true

    // apply OnSet to needsfood setter
    @set:OnSet
    var needsFood: Boolean = false
}

// This annotation does not do anything
annotation class ImAPlant

// Getter and setter
@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet

@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet

// Get information about the class at runtime
fun reflections() {
    val classObj = Plant::class

    // Printing all the methods of the class
    for (method in classObj.declaredMemberFunctions) {
        println(method.name) // trim fertilize
    }

    // print all annotations
    for (annotation in classObj.annotations) {
        println(annotation.annotationClass.simpleName)  // ImAPlant
    }

    // find one annotation, or null
    val annotated = classObj.findAnnotation<ImAPlant>()
    annotated?.apply {
        println("Found a plant annotation")  // Found a plant annotation
    }

}

fun main() {
    reflections()
}