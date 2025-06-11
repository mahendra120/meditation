package com.example.meditation.ui.theme

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import org.intellij.lang.annotations.PrintFormat


class MusicPlay : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        val mp : MediaPlayer = MediaPlayer.create(this)
//        mp.seekTo(1500)

        var imges = intent.getIntExtra("image", 0)
        setContent {
            Myhome(imges)
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
                        radiusX = 16.dp,
                        radiusY = 16.dp,
                        edgeTreatment = BlurredEdgeTreatment.Unbounded
                    )
            )
            IconButton(
                onClick = { finish() }, modifier = Modifier.padding(top = 45.dp),
                colors = IconButtonDefaults.iconButtonColors(contentColor = Color.White.copy(.9f))
            )
            {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier.size(27.dp)
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
                    modifier = Modifier.padding(5.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White.copy(.3f)),
                    border = BorderStroke(
                        3.dp,
                        Color.White
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
    @Preview(showSystemUi = true)
    fun MyButtons() {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Button(onClick = {}, modifier = Modifier.size(60.dp))
            {

            }
            Button(onClick = {}, modifier = Modifier.size(60.dp))
            {

            }
            Button(onClick = {}, modifier = Modifier.size(60.dp))
            {

            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Myslider() {
        val sliderState =
            remember { SliderState(valueRange = 0f..100f) }
        Slider(
            state = sliderState,
            modifier = Modifier.padding(horizontal = 23.dp),
            colors = SliderDefaults.colors(),
            thumb = {
                SliderDefaults.Thumb(
                    MutableInteractionSource(),
                    thumbSize = DpSize(20.dp, 20.dp)
                )
            },
            track = {
                SliderDefaults.Track(
                    sliderState,
                    thumbTrackGapSize = 0.dp,
                    trackInsideCornerSize = 0.dp,
                    modifier = Modifier.height(5.dp)
                )
            }
        )
    }
}