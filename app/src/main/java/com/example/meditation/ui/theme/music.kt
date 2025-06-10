package com.example.meditation.ui.theme


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditation.R
import com.example.meditation.list
import com.example.meditation.list1

class music : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
                Mybar()
            }) { innerPadding ->
                Box(modifier = Modifier.padding(innerPadding)) {
                    Mycards()
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
                    text = "Music",
                    modifier = Modifier,
                    fontSize = 25.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Black),
            navigationIcon = {
                IconButton(
                    onClick = {
                        finish()
                    },
                    colors = IconButtonDefaults.iconButtonColors(contentColor = Color.White)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                    )
                }
            },
            actions = {
                IconButton(
                    onClick = {},
                    colors = IconButtonDefaults.iconButtonColors(contentColor = Color.White)
                ) {
                    Icon(Icons.Default.FavoriteBorder, contentDescription = null)
                }
            }
        )
    }

    @Composable
    @Preview(showSystemUi = true)
    fun Mycards() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            Image(
                painter = painterResource(R.drawable.download),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
            Column {
                Text(
                    text = "  Music instruments > ",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(top = 7.dp)
                )
                Spacer(modifier = Modifier.padding(top = 12.dp))
                MyBars()
//                MyBars1()
                MyMusiclist()
            }
        }
    }

    @Composable
    fun MyBars() {
        LazyRow {
            items(list.size) {
                Card(
                    onClick = {

                    },
                    modifier = Modifier
                        .height(90.dp)
                        .padding(start = 8.dp, end = 8.dp)
                        .height(80.dp)
                        .width(150.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White.copy(.2f)),
                    border = BorderStroke(2.dp, color = Color.White)
                ) {
                    Image(
                        painter = painterResource(list[it]),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }

    @Composable
    fun MyBars1() {
        LazyRow {
            items(list1.size) {
                Button(
                    onClick = {},
                    modifier = Modifier.padding(start = 5.dp, end = 5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    border = BorderStroke(
                        1.dp,
                        Color.White.copy(.9f)
                    )
                )
                {
                    Text(text = "${list1[it]}", fontSize = 15.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }

    @Composable
    fun MyMusiclist() {
        LazyVerticalGrid(columns = GridCells.Fixed(1)) {
            items(list1.size)
            {
                Row {
                    Card(
                        modifier = Modifier.fillMaxSize(),
                        colors = CardDefaults.cardColors(contentColor = Color.White)
                    ) {

                    }
                }
            }
        }
    }
}
