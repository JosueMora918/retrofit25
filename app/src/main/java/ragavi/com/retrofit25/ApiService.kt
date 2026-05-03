package ragavi.com.retrofit25

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("futurama/info")
    fun getFuturamaInfo(): Call<List<FuturamaApiService>>
}