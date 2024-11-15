package ie.setu.domain.db


import jdk.jfr.internal.event.EventConfiguration.timestamp
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.jodatime.datetime
import java.sql.Timestamp


object SleepDb : Table("Sleep") {
    val id = integer("id").autoIncrement()
    val duration = double("duration")
    val date = datetime("date")
    val userid = integer("userid").references(Users.id, onDelete = ReferenceOption.CASCADE)
}