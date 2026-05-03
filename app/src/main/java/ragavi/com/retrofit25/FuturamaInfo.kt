package ragavi.com.retrofit25

import com.google.gson.annotations.SerializedName

data class FuturamaInfo(
    @SerializedName("id") val id: Int,
    @SerializedName("synopsis") val synopsis: String,
    @SerializedName("yearsAired") val yearsAired: String
)