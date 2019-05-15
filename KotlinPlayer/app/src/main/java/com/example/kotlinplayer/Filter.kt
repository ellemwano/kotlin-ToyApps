package com.example.kotlinplayer

sealed class Filter {

    object None : Filter()   // Can be an object, as does not have a state
    class ByType(val type: MediaItem.Type) : Filter()
}