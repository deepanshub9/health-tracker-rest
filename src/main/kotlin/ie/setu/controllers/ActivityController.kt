package ie.setu.controllers


import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import ie.setu.controllers.HealthTrackerController

import ie.setu.domain.Activity
import ie.setu.domain.User


import ie.setu.utils.jsonObjectMapper
import ie.setu.utils.jsonToObject
import io.javalin.http.Context
import ie.setu.domain.repository.ActivityDAO

object ActivityController {
    private val activityDao = ActivityDAO()

    fun getAllActivities(ctx: Context) {
        ctx.json(activityDao.getAllActivities())
    }

    fun getActivityById(ctx: Context) {
        val act = activityDao.getactivitybyId(ctx.pathParam("act-id").toInt())
        if (act != null) {
            ctx.json(act)
            ctx.status(200)
        } else {
            ctx.status(400)
        }

    }

    fun addActivity(ctx: Context) {
        val mapper = jacksonObjectMapper()
        val activity = mapper.readValue<Activity>(ctx.body())
        activityDao.save(activity)
        ctx.json(activity)
    }


    fun deleteActivityById(ctx: Context) {
        if (activityDao.deleteActivity(ctx.pathParam("act-id").toInt()) != 0)
            ctx.status(204)
        else
            ctx.status(404)


    }

    fun updateActivity(ctx: Context) {
        val mapper = jacksonObjectMapper()
        val activity = mapper.readValue<Activity>(ctx.body())
        activityDao.updateActivityById(activity.id, activity)
        ctx.json(activity)

    }


}