package com.example.genshinimpactprofile

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val chara = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Chara>(MainActivity.INTENT_PARCELABLE, Chara::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Chara>(MainActivity.INTENT_PARCELABLE)
        }

        val photo = findViewById<ImageView>(R.id.img_item_photo)
        val name = findViewById<TextView>(R.id.tv_item_name)
        val description = findViewById<TextView>(R.id.tv_item_description)
        val vision = findViewById<TextView>(R.id.tv_item_vision)
        val weapon = findViewById<TextView>(R.id.tv_item_weapon)

        photo.setImageResource(chara?.photo!!)
        name.text = chara.name
        description.text = chara.description
        vision.text = chara.vision
        weapon.text = chara.weapon
    }
}