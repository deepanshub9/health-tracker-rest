package ie.setu.domain.db
import org.jetbrains.exposed.sql.Table


object HealthTips: Table("HealthTips") {
    val id = integer("id").autoIncrement()
    val tips = varchar("tips", 255)
}