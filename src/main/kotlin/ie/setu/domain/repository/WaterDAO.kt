package ie.setu.domain.repository
import ie.setu.utils.mapToWaterIntake
import ie.setu.domain.db.Water
import ie.setu.domain.WaterIntake
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.update
import java.util.ArrayList



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

     fun getWaterIntake(id: Int): WaterIntake? {
         return transaction {
             Water.selectAll().where { Water.userid eq id }.map { mapToWaterIntake(it) }.firstOrNull()
         }


     }

    fun deleteWaterIntake(id: Int): Int {
        return transaction { Water.deleteWhere { Water.userid eq id  } }

    }


    fun save(waterIntake: WaterIntake){
        return transaction {
            Water.insert {
                it[userid] = waterIntake.userid
                it[litres] = waterIntake.litres
                it[dateofdrinking] = waterIntake.dateofdrinking
            }
        }
    }

    fun waterUpdatebyId(id: Column<Int>, waterIntake: WaterIntake){
        return transaction {
            Water.update({ Water.userid eq id }) {
                it[userid] = waterIntake.userid
                it[litres] = waterIntake.litres
                it[dateofdrinking] = waterIntake.dateofdrinking
            }
        }
    }

}