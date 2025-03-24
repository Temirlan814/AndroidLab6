package com.example.lab6android

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val imageDetails = getListData()
        val listView: ListView = findViewById(R.id.listView)

        listView.adapter = CustomListAdapter(this, imageDetails)

        listView.setOnItemClickListener{ parent, _, position, _ ->
            val country = parent.getItemAtPosition(position) as Country
            Toast.makeText(
                this@MainActivity,
                "Selected: ${country.countryName} (Population: ${country.population})",
                Toast.LENGTH_LONG
            ).show()
        }
    }
    private fun getListData(): List<Country> {
        return listOf(
            Country("Vietnam", "vn", 98000000),
            Country("USA", "us", 320000000),
            Country("Russia", "ru", 142000000)
        )
    }
}