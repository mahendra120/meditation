package com.example.meditation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        var currentRotation by remember { mutableStateOf(0f) }
        val rotation = remember { Animatable(currentRotation) }
        LaunchedEffect(true) {
            rotation.animateTo(
                targetValue = currentRotation + 360f,
                animationSpec = infiniteRepeatable(
                    animation = tween(50000, easing = LinearEasing),
                    repeatMode = RepeatMode.Restart
                )
            ) {
                currentRotation = value
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(R.drawable.download), contentScale = ContentScale.Crop,
                contentDescription = null, modifier = Modifier.fillMaxSize()
            )
            Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.padding(top = 45.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.wwwwwww),
                        contentDescription = null,
                        modifier = Modifier
                            .size(400.dp)
                            .rotate(currentRotation)
                    )
                }
                Text(
                    text = "कालचक्र:",
                    fontSize = 35.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .align(Alignment.BottomCenter),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(colors = CardDefaults.cardColors(containerColor = Color.Transparent)) {
                    var expanded by remember { mutableStateOf(false) }
                    Row(modifier = Modifier.clickable { expanded = !expanded }) {
                        Image(
                            painter = painterResource(R.drawable.screen_7),
                            contentDescription = null,
                            modifier = Modifier
                                .size(150.dp)
                                .fillMaxWidth()
                                .rotate(currentRotation)
                        )
                        AnimatedVisibility(expanded)
                        {
                            TextButton(onClick = {
                                var intent = Intent(this@bridge, music::class.java)
                                startActivity(intent)
                            }) {
                                Text(
                                    text = "Music",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    modifier = Modifier.padding(top = 55.dp)
                                )
                            }
                        }
                    }
                }
                Card(colors = CardDefaults.cardColors(containerColor = Color.Transparent)) {
                    var expanded by remember { mutableStateOf(false) }
                    Row(modifier = Modifier.clickable { expanded = !expanded }) {
                        Image(
                            painter = painterResource(R.drawable.rrrrrrr),
                            contentDescription = null,
                            modifier = Modifier
                                .size(150.dp)
                                .fillMaxWidth()
                                .rotate(currentRotation)
                        )
                        AnimatedVisibility(expanded)
                        {
                            TextButton(onClick = {
                                var intent = Intent(this@bridge, MainActivity::class.java)
                                startActivity(intent)
                            }) {
                                Text(
                                    text = "Meditation",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    modifier = Modifier.padding(top = 60.dp)
                                )
                            }
                        }
                    }
                }
                Card(colors = CardDefaults.cardColors(containerColor = Color.Transparent)) {
                    var expanded by remember { mutableStateOf(false) }
                    Row(modifier = Modifier.clickable { expanded = !expanded }) {
                        Image(
                            painter = painterResource(R.drawable.rororo),
                            contentDescription = null,
                            modifier = Modifier
                                .size(102.dp)
                                .fillMaxWidth()
                                .rotate(currentRotation)
                        )
                        AnimatedVisibility(expanded)
                        {
                            TextButton(onClick = {
                                var intent = Intent(this@bridge, Yoga::class.java)
                                startActivity(intent)
                            }) {
                                Text(
                                    text = "Yoga",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    modifier = Modifier.padding(top = 40.dp)
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.padding(top = 10.dp))
            }
        }
    }
}
