package ie.setu.controllers

import ie.setu.controllers.HealthTrackerController

import ie.setu.domain.Activity
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
        if(act != null){
            ctx.json(act)
            ctx.status(200)
        }
        else{
            ctx.status(400)
        }

    }
    //fun addActivity(ctx: Context) {}
    //fun deleteActivityById(ctx: Context) {}
    //fun updateActivity(ctx: Context) {}

}