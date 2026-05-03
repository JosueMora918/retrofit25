package ragavi.com.retrofit25

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var btnLoad: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerViewWines)
        btnLoad = findViewById(R.id.btnLoad)

        recyclerView.layoutManager = LinearLayoutManager(this)

        btnLoad.setOnClickListener {
            loadFuturamaData()
        }
    }

    private fun loadFuturamaData() {
        RetrofitClient.instance.getFuturamaInfo()
            .enqueue(object : Callback<List<FuturamaInfo>> {

                override fun onResponse(
                    call: Call<List<FuturamaInfo>>,
                    response: Response<List<FuturamaInfo>>
                ) {
                    if (response.isSuccessful) {
                        val infoList = response.body() ?: emptyList()
                        recyclerView.adapter = FuturamaInfoAdapter(infoList)
                    } else {
                        Toast.makeText(this@MainActivity, "Error en la respuesta", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<List<FuturamaInfo>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_LONG).show()
                }
            })
    }
}