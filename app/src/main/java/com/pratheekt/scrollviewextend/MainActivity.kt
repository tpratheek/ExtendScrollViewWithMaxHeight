package com.pratheekt.scrollviewextend

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val name = ArrayList<String>()
    private val selectedName = ArrayList<String>()

    lateinit var customAdapter: SelectItem
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for (i in 0..10) {
            name.add("1")
        }
        recyclerView()

    }

    private fun recyclerView() {
        customAdapter = SelectItem(name, object : SelectItem.ItemClickListener {
            override fun onBtnClick(name: String?) {
                addChip(name)
            }

        })
        recycler_view.adapter = customAdapter
    }

    private fun addChip(name: String?) {
        val chip = Chip(this)
        chip.text = name
        chip.isCloseIconEnabled = true
        chip_group.addView(chip)
        chip.setOnCloseIconClickListener {
            selectedName.remove(name)
            chip_group.removeView(chip)
        }
        selectedName.add(name!!)
        scroll_view.post{
            scroll_view.smoothScrollBy(0,chip_group.bottom)
        }
    }
}
