package ie.setu.controllers

import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.datatype.joda.JodaModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import ie.setu.utils.jsonObjectMapper
import io.javalin.http.Context
import com.fasterxml.jackson.databind.SerializationFeature

import ie.setu.utils.jsonToObject


import ie.setu.domain.repository.SleepDAO
import ie.setu.utils.jsonToObject


object SleepController {
//    private val sleepDAO = SleepDAO()
//
//    fun getsleepUser(ctx: Context) {
//        ctx.json(sleepDAO.getAllsleepUser())
//    }
//
//    fun getsleepById(ctx: Context) {
//        val act = sleepDAO.getSleepbyId(ctx.pathParam("hth-id").toInt())
//        if(act != null){
//            ctx.json(act)
//            ctx.status(200)
//        }
//        else{
//            ctx.status(400)
//        }
//
//    }
//
//    fun addsleep(ctx: Context) {
//        val sleep = jsonToObject(ctx.body())
//        val id = sleepDAO.addSleep(sleep)
//        if (id != null) {
//
//            ctx.json(sleep)
//            ctx.status(201)
//        }
//    }
//
//
//
//
//    fun deletesleepById(ctx: Context) {
//        if (sleepDAO.deleteSleepbyId(ctx.pathParam("hth-id").toInt()) != 0)
//            ctx.status(204)
//        else
//            ctx.status(404)
//
//
//    }
//
//
//
//    fun updatesleepbyid(ctx: Context) {
//        val mapper = jacksonObjectMapper()
//        val sleep = mapper.readValue<ie.setu.domain.db.Sleep>(ctx.body())
//        sleepDAO.updateSleepByid(sleep.id, sleep)
//        ctx.json(sleep)
//
//    }
//
//







}