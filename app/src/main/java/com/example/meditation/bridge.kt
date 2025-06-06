package com.example.meditation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meditation.ui.theme.Yoga
import com.example.meditation.ui.theme.music


class bridge : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Mybuttons()
        }
    }

    @Composable
    @Preview(showSystemUi = true)
    fun Mybuttons() {
        Box(modifier = Modifier.fillMaxSize())
        {
            Image(
                painter = painterResource(R.drawable.backlogo),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 430.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Button(
                    onClick = {
                        val intent = Intent(this@bridge, music::class.java)
                        startActivity(intent)
                    },
                    modifier = Modifier.padding(start = 5.dp, end = 5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White.copy(.15f)),
                    border = BorderStroke(
                        .5.dp,
                        Color.White
                    )
                )
                {
                    Text("Music")
                }
                Button(
                    onClick = {
                        val intent = Intent(this@bridge, MainActivity::class.java)
                        startActivity(intent)
                    },
                    modifier = Modifier.padding(start = 5.dp, end = 5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White.copy(.15f)),
                    border = BorderStroke(
                        .5.dp,
                        Color.White
                    )
                )
                {
                    Text("Meditation")
                }
                Button(
                    onClick = {
                        val intent = Intent(this@bridge, Yoga::class.java)
                        startActivity(intent)
                    },
                    modifier = Modifier.padding(start = 5.dp, end = 5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White.copy(.15f)),
                    border = BorderStroke(
                        .5.dp,
                        Color.White
                    )
                )
                {
                    Text("Yoga")
                }
            }
        }
    }
}
