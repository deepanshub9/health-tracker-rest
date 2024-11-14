package ie.setu.domain.db

import ie.setu.domain.db.SleepDb.autoIncrement
import org.jetbrains.exposed.sql.Table
import org.joda.time.DateTime
import org.jetbrains.exposed.sql.jodatime.datetime



object Water : Table("Water") {
    val id = integer("id").autoIncrement()
    val litres = double("litres")
    val dateofdrinking = datetime(name = "dateofdrinking")
    val userid = integer(name="userid")
}