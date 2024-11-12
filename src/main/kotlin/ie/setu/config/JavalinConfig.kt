package ie.setu.config

import ie.setu.controllers.ActivityController
import ie.setu.controllers.ActivityController.getAllActivities
import ie.setu.controllers.HealthTrackerController
import ie.setu.controllers.WaterController

import io.javalin.Javalin


class JavalinConfig {

    fun startJavalinService(): Javalin {

        val app = Javalin.create().apply {
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
<<<<<<< HEAD

=======
>>>>>>> 4ece7b964c3abad71c3ea5a0b100f3951bf65a3f
        app.get("/api/users/email/{email}", HealthTrackerController::getUserByEmail)
        app.delete("/api/users/{user-id}", HealthTrackerController::deleteUser)
        app.patch("/api/users/{user-id}", HealthTrackerController::updateUser)

        //Activity - API CRUD
        app.get("/api/activities", ActivityController::getAllActivities)
        app.get("/api/activities/{act-id}", ActivityController::getActivityById)
<<<<<<< HEAD
        app.post("/api/activities", ActivityController::addActivity)


        app.delete("/api/activities/{act-id}", ActivityController::deleteActivityById)
        app.patch("/api/activities/{act-id}", ActivityController::updateActivity)

=======
>>>>>>> 4ece7b964c3abad71c3ea5a0b100f3951bf65a3f

        //WaterIntake - API CRUD
        app.get("/api/Water",WaterController::getWaterDetails)
        app.get("/api/Water/{wat-id}", WaterController::getWaterById)

    }








}