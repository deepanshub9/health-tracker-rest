package ie.setu.config

import ie.setu.controllers.ActivityController
import ie.setu.controllers.ActivityController.getAllActivities
import ie.setu.controllers.HealthTipController
import ie.setu.controllers.HealthTrackerController
import ie.setu.controllers.WaterController
import ie.setu.domain.db.HealthTips
import ie.setu.utils.jsonObjectMapper
import io.javalin.json.JavalinJackson


import io.javalin.Javalin


class JavalinConfig {

    fun startJavalinService(): Javalin {

        val app = Javalin.create{
            it.jsonMapper(JavalinJackson(jsonObjectMapper()))
        }.apply {
            exception(Exception::class.java) { e, ctx -> e.printStackTrace() }
            error(404) { ctx -> ctx.json("404 - Not Found") }
        }.start(7001)

        registerRoutes(app)
        return app
    }



    private fun registerRoutes(app: Javalin) {
        //User - API CRUD
        app.get("/api/users", HealthTrackerController::getAllUsers)
        app.get("/api/users/{user-id}", HealthTrackerController::getUserByUserId)
        app.post("/api/users", HealthTrackerController::addUser)

        app.get("/api/users/email/{email}", HealthTrackerController::getUserByEmail)
        app.delete("/api/users/{user-id}", HealthTrackerController::deleteUser)
        app.patch("/api/users/{user-id}", HealthTrackerController::updateUser)

        //Activity - API CRUD
        app.get("/api/activities", ActivityController::getAllActivities)
        app.get("/api/activities/{act-id}", ActivityController::getActivityById)

        app.post("/api/activities", ActivityController::addActivity)
        app.delete("/api/activities/{act-id}", ActivityController::deleteActivityById)
        app.patch("/api/activities/{act-id}", ActivityController::updateActivity)

        //WaterIntake - API CRUD
        app.get("/api/Water",WaterController::getWaterDetails)
        app.get("/api/Water/{wat-id}", WaterController::getWaterById)

        app.delete("/api/Water/{wat-id}", WaterController::deleteWaterById)
        app.post("/api/Water", WaterController::addWater)
        app.patch("/api/Water/{wat-id}", WaterController::updateWaterId)

//        //HealthTip - API CRUD
//        app.get("/api/healthtip", HealthTipController::getAllHealthTip)
//        app.get("/api/healthtip/{hth-id}", HealthTipController::getHealthTipById)
//        app.post("/api/healthtip/", HealthTipController::addHealthTip)
//
//        app.delete("/api/healthtip/{hth-id}", HealthTipController::deleteHealthTipById)
//        app.patch("/api/healthtip/{hth-id}", HealthTipController::updateHelathTipbyId)


    }








}