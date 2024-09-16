package com.example.sumitapi.viewmodel


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sumitapi.adapters.Entity
import com.example.sumitapi.adapters.EntityAdapter
import com.example.test8.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException


class DashboardActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EntityAdapter
    private lateinit var keypass: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        keypass = intent.getStringExtra("KEYPASS") ?: return

        recyclerView = findViewById(R.id.recyclerView) //Unresolved reference: recyclerView
        adapter = EntityAdapter { entity -> onEntityClick(entity) }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        fetchEntities()
    }

    private fun fetchEntities() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitClient.apiService.getDashboardEntities(keypass)

                Log.d("DashboardActivity", "Raw response: ${response.body()}")

                if (response.isSuccessful) {
                    val entities = response.body()?.entities ?: emptyList()
                    Log.d("DashboardActivity", "Fetched entities: $entities")
                    Log.d("DashboardActivity", "Number of entities: ${entities.size}")
                    runOnUiThread {
                        if (entities.isNotEmpty()) {
                            adapter.submitList(entities)
                        } else {
                            Toast.makeText(this@DashboardActivity, "No entities found", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    runOnUiThread {
                        Log.e("DashboardActivity", "API call failed with response: ${response.errorBody()}")
                        Toast.makeText(this@DashboardActivity, "Failed to load entities", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: HttpException) {
                runOnUiThread {
                    Log.e("DashboardActivity", "HttpException: ${e.message}")
                    Toast.makeText(this@DashboardActivity, "Network error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                runOnUiThread {
                    Log.e("DashboardActivity", "Exception: ${e.message}")
                    Toast.makeText(this@DashboardActivity, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    private fun onEntityClick(entity: Entity) {
        // Create intent to start DetailsActivity
        val intent = Intent(this, DetailsActivity::class.java)

        // Pass the clicked entity as an extra
        intent.putExtra("ENTITY", entity)

        // Start the DetailsActivity
        startActivity(intent)
    }



}
