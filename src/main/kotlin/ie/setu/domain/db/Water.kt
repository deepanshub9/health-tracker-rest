package ie.setu.domain.db

import org.jetbrains.exposed.sql.Table
import org.joda.time.DateTime
import org.jetbrains.exposed.sql.jodatime.datetime



object Water : Table("Water") {
    val userid = integer(name="userid")
    val litres = double("litres")
    val dateofdrinking = datetime(name = "dateofdrinking")

}