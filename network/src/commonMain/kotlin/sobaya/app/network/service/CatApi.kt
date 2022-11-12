package sobaya.app.network.service

import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Query
import sobaya.app.data.dogApi.response.SearchCatResponseItem

interface CatApi {
//    @GET("breeds/image/random")
//    suspend fun getRandomDog(): RandomDogResponse

    @GET("v1/images/search")
    suspend fun searchCat(@Query("limit") limit: Int = 10, @Query("page") page: Int = 0): List<SearchCatResponseItem>
}
