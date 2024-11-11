package ie.setu.domain.db
import org.jetbrains.exposed.sql.Table

object  Activities : Table("Activity") {
    val id = integer(name = "activityid").autoIncrement()
    val description = varchar("description", 255)
    val duration = double("duration")
    val started = double("started")
    val calories = double("calories")
    val userid = integer(name = "userid")

}