package ie.setu.domain

import org.joda.time.DateTime
import kotlin.time.Duration

data class Sleep(
    var id: Int,
    var duration: Double,
    var date: DateTime,
    var userid: Int,
)
