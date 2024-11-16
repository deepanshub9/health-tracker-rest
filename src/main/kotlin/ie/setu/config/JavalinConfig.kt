package ie.setu.config

import ie.setu.controllers.*
import ie.setu.controllers.ActivityController.getAllActivities
import ie.setu.domain.db.HealthTips
import ie.setu.utils.jsonObjectMapper
import io.javalin.json.JavalinJackson
import io.javalin.Javalin


class JavalinConfig {

    fun startJavalinService(): Javalin {
        println("INFO: Starting Javalin service...")
        val app = Javalin.create().apply {
            exception(Exception::class.java) { e, ctx ->
                println("ERROR: Exception occurred: ${e.message}")
                e.printStackTrace() }
            error(404) { ctx ->
                println("WARN: 404 - Not Found error triggered for request: ${ctx.url()}")
                ctx.json("404 - Not Found") }
        }.start("0.0.0.0", getRemoteAssignedPort())

        println("INFO: Javalin started on port ${app.port()}")
        registerRoutes(app)
        return app
    }

    private fun getRemoteAssignedPort(): Int {
        val remotePort = System.getenv("PORT")
        println("INFO: PORT environment variable value: $remotePort")
        return if (remotePort != null) {
            Integer.parseInt(remotePort)
        } else {
            println("WARN: PORT environment variable not found. Using default port 7001.")
            7001
        }
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
        app.get("/api/Water", WaterController::getWaterDetails)
        app.get("/api/Water/{wat-id}", WaterController::getWaterById)

        app.delete("/api/Water/{wat-id}", WaterController::deleteWaterById)
        app.post("/api/Water", WaterController::addWater)
        app.patch("/api/Water/{wat-id}", WaterController::updateWaterId)

        //HealthTip - API CRUD
        app.get("/api/HealthTips", HealthTipController::getAllHealthTip)
        app.get("/api/HealthTips/{hth-id}", HealthTipController::getHealthTipById)
        app.post("/api/HealthTips/", HealthTipController::addHealthTip)

        app.post("/api/HealthTips", HealthTipController::addhealthTip)
        app.delete("/api/HealthTips/{hth-id}", HealthTipController::deleteHealthTipById)
        app.patch("/api/HealthTips/{hth-id}", HealthTipController::updateHealthTip)


        //Sleep - API CRUD
        app.get("/api/Sleep", SleepController::getsleepUser)
        app.get("/api/Sleep/{slp-id}", SleepController::getsleepById)
        app.post("/api/Sleep", SleepController::addsleep)

        app.delete("/api/Sleep/{slp-id}", SleepController::deleteSleepByid)
        app.patch("/api/Sleep/{slp-id}", SleepController::updatesleepbyid)


    }


}