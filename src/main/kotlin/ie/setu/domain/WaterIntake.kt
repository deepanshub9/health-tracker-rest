package ie.setu.domain

import org.joda.time.DateTime

import org.jetbrains.exposed.sql.*


data class WaterIntake (
    val id: Int,
    var litres:Double,
    var dateofdrinking: DateTime,
    var userid: Int
)
