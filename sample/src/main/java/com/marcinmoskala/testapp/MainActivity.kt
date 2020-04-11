package com.marcinmoskala.testapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.marcinmoskala.kotlinpreferences.PreferenceHolder
import com.marcinmoskala.kotlinpreferences.gson.GsonSerializer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val text: String
        get()  = textEditView.text.toString()

    val num: Int
        get()  = numberEditView.text.toString().toInt()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PreferenceHolder.serializer = GsonSerializer(Gson())

            textEditView.setText(Pref.text)
        numberEditView.setText(Pref.num.toString())
        textEditView.setOnKeyListener { _, _, _ -> Pref.text = text; true }
        numberEditView.setOnKeyListener { _, _, _ -> Pref.num = num; true }
        saveObjectButton.setOnClickListener {
            val newObject = OtherPref.Together(text, num)
            OtherPref.together = newObject
            objectMonitor.text = newObject.toString()
        }
    }
}