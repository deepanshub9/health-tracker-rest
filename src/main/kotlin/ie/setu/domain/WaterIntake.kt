package ie.setu.domain

import org.joda.time.DateTime

import org.jetbrains.exposed.sql.*


data class WaterIntake (
    var userid: Int,
    var litres:Double,
    var dateofdrinking: DateTime
)
