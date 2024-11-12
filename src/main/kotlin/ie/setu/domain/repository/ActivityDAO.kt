package ie.setu.domain.repository
import ie.setu.utils.mapToActivity
import ie.setu.domain.Activity
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.selectAll
import ie.setu.domain.db.Activities
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.update
import java.util.ArrayList

class ActivityDAO {
    fun getAllActivities(): ArrayList<Activity> {
        val activityList: ArrayList<Activity> = arrayListOf()
        transaction {
            Activities.selectAll().map {
                activityList.add(mapToActivity(it))
            }
        }
        return activityList
    }

    fun getactivitybyId(id : Int) :Activity? {
        return transaction {
            Activities.selectAll().where{Activities.id eq id}.map{mapToActivity(it)}.firstOrNull()
        }
    }
<<<<<<< HEAD




    fun deleteActivity(id: Int): Int? {
        return transaction { Activities.deleteWhere { Activities.id eq id } }
    }

    fun save(activity : Activity){
        return transaction {
            Activities.insert {
                it[id] = activity.id
                it[description] = activity.description
                it[duration] = activity.duration
                it[started] = activity.started
                it[calories] = activity.calories
                it[userid] = activity.userId

            }
        }
    }


    fun updateActivityById(id: Int, activity : Activity) {
        return transaction {
            Activities.update({ Activities.id eq id }) {
                it[description] = activity.description
                it[duration] = activity.duration
                it[started] = activity.started
                it[calories] = activity.calories
                it[userid] = activity.userId

            }
        }

    }






=======
>>>>>>> 4ece7b964c3abad71c3ea5a0b100f3951bf65a3f
}