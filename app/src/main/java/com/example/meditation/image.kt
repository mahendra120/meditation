package com.example.meditation

import android.content.Context
import android.media.MediaPlayer

var list = arrayListOf(
    R.drawable.dolka,
    R.drawable.img_4,
    R.drawable.img,
    R.drawable.img_3,
    R.drawable.img_5,
    R.drawable.img_6,
    R.drawable.sharnay,
    R.drawable.manjira,
    R.drawable.ramhat,
)
val list1 = arrayListOf(
    "Vina",
    "Dolka",
    "Flute",
    "Tambura",
    "Harmonium",
    "Sarangi",
    "Tabla"
)
val list2 = arrayListOf(
    R.drawable.classic_music_1,
    R.drawable.classic_music_2,
    R.drawable.classic_music_3,
    R.drawable.classic_music_4,
    R.drawable.classic_music_5,
    R.drawable.classic_music_6,
    R.drawable.tabla,
)
var musiclist = arrayListOf(
    R.raw.ranchhod_rangila,
    R.raw.music1,
    R.raw.shiv_kaylash,
    R.raw.namami_shamishan,
)

fun startMusic(context: Context, pose: Boolean) {
    val player = MediaPlayer.create(context, R.raw.music1)
    player.start()
}