package ie.setu.domain.repository




//import ie.setu.domain.Sleep

//import ie.setu.domain.db.Sleep
//
//import ie.setu.utils.mapToSleep
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update


class SleepDAO {

//    fun getAllsleepUser(): ArrayList<ie.setu.domain.Sleep> {
//        val sleepList: ArrayList<ie.setu.domain.Sleep> = arrayListOf()
//        transaction {
//
//            sleepList.selectAll().map {
//                sleepList.add(mapToSleep(it))
//            }
//
//        }
//        return sleepList
//
//    }
//
//    fun getSleepbyId(id: Int): ie.setu.domain.Sleep? {
//        return transaction {
//            ie.setu.domain.Sleep.selectAll().where { ie.setu.domain.Sleep.id eq id }.map { mapToSleep(it) }.firstOrNull()
//        }
//    }
//
//    fun addSleep(Sleep: Sleep) {
//        return transaction {
//            ie.setu.domain.Sleep.insert {
//                it[id] = Sleep.id
//                it[duration] = Sleep.duration
//                it[date] = Sleep.date
//                it[userid] = Sleep.userid
//            } get Sleep.id
//        }
//    }
//
//
//    fun deleteSleepbyId(id: Int): Int? {
//        return transaction { Sleep.deleteWhere { ie.setu.domain.Sleep.id eq id } }
//    }
//
//
//    fun save(sleep: ie.setu.domain.Sleep) {
//        return transaction {
//            ie.setu.domain.Sleep.insert {
//                it[id] = sleep.id
//                it[duration] = sleep.duration
//                it[date] = sleep.date
//                it[userid] = sleep.userid
//            }
//        }
//    }
//
//    fun updateSleepByid(slee: Int, healthTip: HealthTip) {
//        return transaction {
//            HealthTips.update({ HealthTips.id eq healthTip.id }) {
//                it[id] = healthTip.id
//                it[tips] = healthTip.tips
//            }
//        }
//    }





}