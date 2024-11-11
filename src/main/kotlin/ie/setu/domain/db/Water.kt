package ie.setu.domain.db
import jdk.jfr.internal.event.EventConfiguration.timestamp
import org.jetbrains.exposed.sql.Table
import org.joda.time.DateTime
import java.sql.Time
import java.sql.Timestamp


object Water : Table("Water") {
    val userid = integer(name="userid")
    val litres = double("litres")
}