package com.example.meditation

import android.media.MediaPlayer
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SliderState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.example.meditation.ui.theme.Pause
import com.example.meditation.ui.theme.SkipEndCircle
import com.example.meditation.ui.theme.SkipStartCircle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.Executors


@OptIn(ExperimentalMaterial3Api::class)
class MusicPlay : ComponentActivity() {

    var mediaPlayer: MediaPlayer? = null
    var sliderValue by mutableStateOf(0f)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        mediaPlayer = MediaPlayer.create(this@MusicPlay, R.raw.namami_shamishan)
        mediaPlayer?.start()

        GlobalScope.launch {
            while (true) {
                delay(500)
                sliderValue = mediaPlayer?.currentPosition?.toFloat() ?: 0f
            }
        }

        var imges = intent.getIntExtra("image", 0)
        setContent {
            Myhome(imges)

            DisposableEffect(Unit) {
                onDispose {
                    mediaPlayer?.release()
                    mediaPlayer = null
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Myhome(imges: Int) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(imges),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .blur(
                        radiusX = 20.dp,
                        radiusY = 20.dp,
                        edgeTreatment = BlurredEdgeTreatment.Unbounded
                    )
            )
            Box(modifier = Modifier.fillMaxSize().background(Color.Black.copy(alpha = .3f)),)
            IconButton(
                onClick = { finish() }, modifier = Modifier.padding(top = 90.dp),
                colors = IconButtonDefaults.iconButtonColors(contentColor = Color.White.copy(.9f))
            )
            {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
            }
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.padding(top = 140.dp))
                MyCards(imges)
                Spacer(modifier = Modifier.padding(top = 130.dp))
                Card(
                    modifier = Modifier.padding(9.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Black.copy(.3f)),
                    border = BorderStroke(
                        3.dp,
                        Color.Black
                    )
                ) {
                    Spacer(Modifier.padding(top = 20.dp))
                    Myslider()
                    Spacer(Modifier.padding(top = 20.dp))
                    MyButtons()
                    Spacer(Modifier.padding(top = 40.dp))
                }
            }
        }
    }

    @Composable
    fun MyCards(imges: Int) {
        Card(
            modifier = Modifier
                .height(300.dp)
                .width(300.dp)
                .fillMaxSize()
                .clip(CircleShape),
            colors = CardDefaults.cardColors(containerColor = Color.Black)
        ) {
            Image(
                painter = painterResource(imges),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
    }

    @Composable
    fun MyButtons() {

        var isPlaying by remember { mutableStateOf(true) }

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            IconButton(onClick = {}, modifier = Modifier.size(60.dp))
            {
                Icon(
                    SkipStartCircle,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp),
                )
            }
            IconButton(onClick = {
                isPlaying = !isPlaying
                if (isPlaying) {
                    mediaPlayer?.start()
                } else {
                    mediaPlayer?.pause()
                }
            }, modifier = Modifier.size(60.dp))
            {
                Icon(
                    if (isPlaying) Pause else Icons.Default.PlayArrow,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp),
                )
            }
            IconButton(onClick = {}, modifier = Modifier.size(60.dp))
            {
                Icon(
                    SkipEndCircle,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp),
                )
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Myslider() {

        val colors = SliderDefaults.colors(
            activeTrackColor = Color.White.copy(.8f),
            inactiveTrackColor = Color.White.copy(.3f),
            thumbColor = Color.White
        )

        Slider(
            value = sliderValue,
            valueRange = 0f..mediaPlayer?.duration!!.toFloat(),
            onValueChange = {
                sliderValue = it
            },
            onValueChangeFinished = {
                mediaPlayer?.seekTo(sliderValue.toInt())
            },
            modifier = Modifier.padding(horizontal = 23.dp),
            colors = colors,
            thumb = {
                SliderDefaults.Thumb(
                    interactionSource = MutableInteractionSource(),
                    thumbSize = DpSize(20.dp, 20.dp),
                    colors = colors
                )
            },
//            track = { sliderPositions ->
//                // Draw custom track using Box or Canvas
//                Box(
//                    Modifier
//                        .fillMaxWidth()
//                        .height(3.dp)
//                        .drawBehind {
//                            val trackWidth = size.width
//                            val centerY = size.height / 2
//
//                            // Draw inactive track (full width)
//                            drawLine(
//                                color = Color.Gray,
//                                start = Offset(0f, centerY),
//                                end = Offset(trackWidth, centerY),
//                                strokeWidth = 3.dp.toPx()
//                            )
//
//                            // Draw active track (up to thumb)
//                            val activeWidth = trackWidth * sliderPositions.value
//                            drawLine(
//                                color = Color.Blue,
//                                start = Offset(0f, centerY),
//                                end = Offset(activeWidth, centerY),
//                                strokeWidth = 3.dp.toPx()
//                            )
//                        }
//                )
//            }
        )

    }
}