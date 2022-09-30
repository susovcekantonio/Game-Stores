package hr.ferit.antoniosusovcek

import retrofit2.http.Query
import retrofit2.http.GET
import retrofit2.Call

interface GamesEndpoints {
    @GET("api/games?")
    fun getGames(@Query("category") category: String): Call<List<Games>>

}