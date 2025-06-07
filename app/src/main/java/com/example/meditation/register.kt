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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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


class register : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Mytital()
        }
    }

    @Composable
    @Preview(showSystemUi = true)
    fun Mytital() {
        Box(modifier = Modifier.fillMaxSize())
        {
            Image(
                painter = painterResource(R.drawable.meditation),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text()
            }
            Button(
                onClick = {
                    val intent = Intent(this@register, Login::class.java)
                    startActivity(intent)
                    finish()
                },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 99.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White.copy(.2f)),
                border = BorderStroke(1.dp, Color.White)
            )
            {
                Text(
                    text = "Login",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 2.dp, start = 20.dp, end = 20.dp)
                )
            }
            Button(
                onClick = {},
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(bottom = 30.dp, start = 25.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent.copy(.3f)),
                border = BorderStroke(1.dp, Color.White)
            )
            {
                Image(
                    painter = painterResource(R.drawable.search),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .padding(end = 4.dp, bottom = 4.dp, top = 1.dp)
                )
                Text(text = "Google", modifier = Modifier.padding(bottom = 2.dp))
            }
            Button(
                onClick = {},
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 30.dp, end = 15.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent.copy(.3f)),
                border = BorderStroke(1.dp, Color.White)
            )
            {
                Image(
                    painter = painterResource(R.drawable.facebook),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .padding(bottom = 4.dp, end = 2.dp)
                )
                Text(text = "Facebook", modifier = Modifier.padding(bottom = 2.dp))
            }
        }
    }

    @Composable
    fun Text() {
        Text(
            text = "Create Account",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier, color = Color.White.copy(0.8f)
        )
        Spacer(modifier = Modifier.height(30.dp))
        OutlinedTextField(
            value = "",
            onValueChange = {},
            colors = OutlinedTextFieldDefaults.colors(Color.White),
            label = { Text(text = "Name", color = Color.White.copy(.8f)) })
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = "",
            onValueChange = {},
            colors = OutlinedTextFieldDefaults.colors(Color.White),
            label = { Text(text = "Surname", color = Color.White.copy(.8f)) })
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = "",
            onValueChange = {},
            colors = OutlinedTextFieldDefaults.colors(Color.White),
            label = { Text(text = "Email", color = Color.White.copy(.8f)) })
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = "",
            onValueChange = {},
            colors = OutlinedTextFieldDefaults.colors(Color.White),
            label = { Text(text = "Password", color = Color.White.copy(.8f)) })
        Spacer(modifier = Modifier.height(35.dp))
        Button(
            onClick = {
                val intent = Intent(this@register, bridge::class.java)
                startActivity(intent)
            },
            modifier = Modifier,
            colors = ButtonDefaults.buttonColors(containerColor = Color.White.copy(.35f)),
            border = BorderStroke(1.dp, Color.White)
        )
        {
            Text(
                text = "Create Account",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 20.dp, end = 20.dp)
            )
        }
    }
}
