package ragavi.com.retrofit25

import retrofit2.Call
import retrofit2.http.GET

interface FuturamaApiService {

    @GET("futurama/info")
    fun getFuturamaInfo(): Call<List<FuturamaInfo>>

}