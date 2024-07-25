package com.example.a2_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity:AppCompatActivity(){
    lateinit var textView:TextView
    lateinit var button:Button
    lateinit var editText:EditText

    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView=findViewById(R.id.textView)
        button=findViewById(R.id.button)
        editText=findViewById(R.id.editText)
            button.setOnClickListener{
                textView.text=editText.text.toString()
        }


    }
}