package com.example.genshinimpactprofile

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Chara(
    val name: String,
    val description: String,
    val photo: Int,
    val vision: String,
    val weapon: String
) : Parcelable
