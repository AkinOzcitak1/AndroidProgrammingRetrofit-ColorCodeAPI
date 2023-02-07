package com.akinozcitak.retrofitkotlin.model

data class ColorBookModel(
    val name : String,
    val hex : String,
    val rgb : String,
    val families : Array<String>
)