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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
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
                painter = painterResource(R.drawable.download),
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
                    .padding(bottom = 110.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                border = BorderStroke(1.dp, Color.White)
            )
            {
                Text(
                    text = "Login",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 88.dp, end = 88.dp)
                )
            }
            Button(
                onClick = {},
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(bottom = 30.dp, start = 33.dp),
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
        var name by remember { mutableStateOf("") }
        var surname by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        Text(
            text = "Create Account",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier, color = Color.White
        )
        Spacer(modifier = Modifier.height(30.dp))
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            colors = OutlinedTextFieldDefaults.colors(Color.White),
            label = { Text(text = "Name", fontSize = 14.sp , color = Color.White)})
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = surname,
            onValueChange = { surname = it },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            colors = OutlinedTextFieldDefaults.colors(Color.White),
            label = { Text(text = "Surname", fontSize = 14.sp , color = Color.White) })
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            colors = OutlinedTextFieldDefaults.colors(Color.White),
            label = { Text(text = "Email", fontSize = 14.sp , color = Color.White) })
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            colors = OutlinedTextFieldDefaults.colors(Color.White),
            label = { Text(text = "Password", fontSize = 14.sp , color = Color.White) })
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {
                val intent = Intent(this@register, bridge::class.java)
                startActivity(intent)
            },
            modifier = Modifier,
            colors = ButtonDefaults.buttonColors(containerColor = Color.White.copy(.5f)),
            border = BorderStroke(1.dp, Color.White)
        )
        {
            Text(
                text = "Create Account",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 55.dp, end = 55.dp)
            )
        }
    }
}
