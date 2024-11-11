package ie.setu.utils

import ie.setu.domain.*
import ie.setu.domain.db.*
import ie.setu.domain.Activity
import ie.setu.domain.db.Activities
import ie.setu.domain.WaterIntake
import ie.setu.domain.db.Water
import org.jetbrains.exposed.sql.ResultRow
import java.sql.Timestamp


fun mapToUser(it: ResultRow)= User(
    id = it[Users.id],
    name = it[Users.name],
    email = it[Users.email]
)

fun mapToActivity(it: ResultRow)= Activity(
    id = it[Activities.id],
    description = it[Activities.description],
    duration = it[Activities.duration],
    started = it[Activities.started],
    calories = it[Activities.calories],
    userId = it[Activities.userid]
)

fun mapToWaterIntake(it: ResultRow)= WaterIntake(
    userid = it[Water.userid],
    litres = it[Water.litres]
)

