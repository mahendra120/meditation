package com.example.meditation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditation.music


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize(), topBar = { Mybar() }) { innerPadding ->
                Box(modifier = Modifier.padding(innerPadding)) {
                        MyHome()
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Mybar() {
        TopAppBar(
            title = {
                Text(
                    text = "Meditation",
                    modifier = Modifier.padding(start = 3.dp),
                    fontSize = 25.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Black),
            navigationIcon = {
                IconButton(
                    onClick = {
                        var intent = Intent(this@MainActivity, bridge::class.java)
                        startActivity(intent)
                    },
                    colors = IconButtonDefaults.iconButtonColors(contentColor = Color.White)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null, modifier = Modifier.size(27.dp)
                    )
                }
            },
        )
    }
    @Composable
    fun MyHome()
    {
         Box(modifier = Modifier.fillMaxSize())
         {
             Image(
                 painter = painterResource(R.drawable.download),
                 contentDescription = null,
                  contentScale = ContentScale.Crop,
                 modifier = Modifier.fillMaxSize()
             )
         }
    }
}
