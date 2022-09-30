package hr.ferit.antoniosusovcek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val searchButton = findViewById<Button>(R.id.searchButton)
        val textInput = findViewById<EditText>(R.id.textInput)

        searchButton.setOnClickListener {
            val request =
                ServiceBuilder.buildService(GamesEndpoints::class.java)
            val call = request.getGames(textInput.text.toString())

            call.enqueue(object : Callback<List<Games>> {
                override fun onResponse(
                    call: Call<List<Games>>,
                    response: Response<List<Games>>
                ) {
                    if (response.isSuccessful) {
                        findViewById<RecyclerView>(R.id.gameRecyclerView).apply {
                            layoutManager =
                                LinearLayoutManager(this@SearchActivity)
                            adapter =
                                GameRecycler(response.body()!!)
                        }
                    }
                }

                override fun onFailure(call: Call<List<Games>>, t: Throwable) {
                    Log.d("FAIL", t.message.toString())
                }
            })
        }
    }
}