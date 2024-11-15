package ie.setu.controllers

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.javalin.http.Context
import ie.setu.domain.Sleep

import ie.setu.utils.jsonToObject


import ie.setu.domain.repository.SleepDAO


import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.joda.JodaModule


object SleepController {
    private val sleepDAO = SleepDAO()

    fun getsleepUser(ctx: Context) {
        ctx.json(sleepDAO.getAllsleepUser())
    }

    fun getsleepById(ctx: Context) {
        val act = sleepDAO.getSleepbyId(ctx.pathParam("slp-id").toInt())
        if (act != null) {
            ctx.json(act)
            ctx.status(200)
        } else {
            ctx.status(400)
        }

    }

    fun addsleep(ctx: Context) {
        val sleep: Sleep = jsonToObject(ctx.body())
        val id = sleepDAO.save(sleep)
        if (id != null) {

            ctx.json(sleep)
            ctx.status(201)
        }
    }


    fun deleteSleepByid(ctx: Context) {
        val sleep = sleepDAO.deleteSleepbyId(ctx.pathParam("slp-id").toInt())
        if (sleep != null) {
            ctx.status(204)
        } else
            ctx.status(400)
    }


    fun updatesleepbyid(ctx: Context) {
        val sleep: Sleep = jsonToObject(ctx.body())
        val id = sleepDAO.updateSleepbyId(sleep.id, sleep)
        if (id != null) {

            ctx.json(sleep)
            ctx.status(201)
        }


    }


}