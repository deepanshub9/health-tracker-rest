package ie.setu.controllers
import ie.setu.domain.db.Water
import ie.setu.domain.WaterIntake
import ie.setu.domain.repository.WaterDAO
import io.javalin.http.Context
object WaterController {
    private val waterDAO = WaterDAO()

    fun getWaterDetails(ctx: Context) {
        ctx.json(waterDAO.getAll())
    }

    fun getWaterById(ctx: Context) {
        val id = waterDAO.findById(ctx.pathParam("wat-id").toInt())
        if (id != null) {
            ctx.json(id)
            ctx.status(200)
        }
        else{
            ctx.json(400)
        }


    }


}