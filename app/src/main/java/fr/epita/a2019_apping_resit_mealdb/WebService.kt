package fr.epita.a2019_apping_resit_mealdb

import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("api/json/v1/1/categories.php")
    fun listCategories(): retrofit2.Call<List<Categories>>

    //@GET("game/details")
    //fun DescGame(@Query("game_id") id: Int): retrofit2.Call<Game>
}