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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Homepage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyHome()
        }
    }

    @Composable
    @Preview(showSystemUi = true)
    fun MyHome() {
        Box(modifier = Modifier.fillMaxSize())
        {
            Image(
                painter = painterResource(R.drawable.homepage),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Hello",
                    fontSize = 55.sp, fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 60.dp),
                    color = Color.White.copy(2f)
                )
                Button(
                    onClick = {
                        val intent = Intent(this@Homepage, Login::class.java)
                        startActivity(intent)
                        finish()
                    },
                    modifier = Modifier.padding(top = 40.dp, bottom = 7.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White.copy(.5f)),
                    border = BorderStroke(
                        2.dp,
                        Color.White
                    )
                )
                {
                    Text(
                        text = "Login",
                        fontSize = 18.sp, fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 80.dp, end = 80.dp)
                    )
                }
                Button(
                    onClick = {
                        val intent = Intent(this@Homepage, register::class.java)
                        startActivity(intent)
                        finish()
                    },
                    modifier = Modifier.padding(top = 10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    border = BorderStroke(
                        2.dp,
                        Color.White
                    )
                )
                {
                    Text(
                        text = "Create Account",
                        fontSize = 18.sp, fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 32.dp, end = 32.dp)
                    )
                }
            }
        }
    }
}