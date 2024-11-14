package ie.setu.domain.db
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.jodatime.date
import org.jetbrains.exposed.sql.jodatime.datetime

import org.joda.time.DateTime

//object Sleep  : Table("Sleep") {
//    val id = integer("id")
//    val duration = Double("duration")
//    val date = datetime(name = "date")
//    val userid = integer("user_id").references(Users.id, onDelete = ReferenceOption.CASCADE)
//}