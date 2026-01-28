package com.ext.android_emptystatewidgets

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ext.emptystatekit.ui.EmptyStateView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val emptyView = findViewById<EmptyStateView>(R.id.emptyView)

        emptyView.setOnActionClick {
            Toast.makeText(this, "Retry clicked", Toast.LENGTH_SHORT).show()
        }
        // Default
        emptyView.showNoInternet()

// Custom message
        emptyView.showNoInternet(
            message = "Turn on Wi-Fi or Mobile Data"
        )

// Fully custom
        emptyView.showError(
            icon = com.ext.emptystatekit.R.drawable.ic_error,
            message = "Server not responding"
        )

    }
}