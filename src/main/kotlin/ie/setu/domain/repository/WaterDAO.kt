package ie.setu.domain.repository
import ie.setu.utils.mapToWaterIntake
import ie.setu.domain.db.Water
import ie.setu.domain.WaterIntake
import ie.setu.domain.db.Users
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.update


class WaterDAO {
    fun getAll(): ArrayList<WaterIntake> {
        val waterList: ArrayList<WaterIntake> = arrayListOf()
        transaction {
            Water.selectAll().map {
                waterList.add(mapToWaterIntake(it))
            }
        }
        return waterList
}

     fun findById(id: Int): WaterIntake? {
         return transaction {
             Water.selectAll().where { Water.userid eq id }.map { mapToWaterIntake(it) }.firstOrNull()
         }


     }




}