package id.ac.polbeng.gentaindianaluthfi.appbarexample

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.search.SearchBar
import com.google.android.material.search.SearchView

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val searchBar = findViewById<SearchBar>(R.id.searchBar)
        val searchView = findViewById<SearchView>(R.id.searchView)

        searchView.editText.setOnEditorActionListener { _, _, _ ->
            val query = searchView.text.toString()
            searchBar.setText(query)
            searchView.hide()
            Toast.makeText(this, query, Toast.LENGTH_SHORT).show()
            true
        }
    }
}
