package com.example.genshinimpactprofile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var rvChara: RecyclerView
    private val list = ArrayList<Chara>()

    companion object {
        const val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvChara = findViewById(R.id.rv_chara)
        rvChara.setHasFixedSize(true)

        list.addAll(getListChara())
        showRecyclerList()

        val btnMoveActivity: Button = findViewById(R.id.btn_about)
        btnMoveActivity.setOnClickListener(this)
    }

    private fun getListChara(): ArrayList<Chara> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataVision = resources.getStringArray(R.array.data_vision)
        val dataWeapon = resources.getStringArray(R.array.data_weapon)
        val listChara = ArrayList<Chara>()
        for (i in dataName.indices) {
            val chara = Chara(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataVision[i], dataWeapon[i])
            listChara.add(chara)
        }
        return listChara
    }

    private fun showRecyclerList() {
        rvChara.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListCharaAdapter(list)
        rvChara.adapter = listHeroAdapter
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_about -> {
                val moveIntent = Intent(this@MainActivity, AboutPage::class.java)
                startActivity(moveIntent)
            }
        }
    }
}