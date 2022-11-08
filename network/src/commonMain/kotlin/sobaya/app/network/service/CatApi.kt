package sobaya.app.network.service

import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path
import de.jensklingenberg.ktorfit.http.Query
import kotlinx.coroutines.flow.Flow
import sobaya.app.data.dogApi.response.CatSearchResponseItem
import sobaya.app.data.dogApi.response.RandomDogResponse

interface CatApi {
//    @GET("breeds/image/random")
//    suspend fun getRandomDog(): RandomDogResponse

    @GET("v1/images/search")
    fun searchCat(@Query("limit") limit: Int = 10, @Query("page") page: Int = 0): Flow<List<CatSearchResponseItem>>
}
