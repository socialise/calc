package com.example.routine.calc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val MAX = 1000000000000
    var value: Long = 0
    var tempValue:Long = 0
    var operation:String =""

    lateinit var  textDisp: TextView

    override fun onClick(v: View?) {
        if (v==null) return

        var tag = v.tag
        when (tag) {
            "1","2","3","4","5","6","7","8","9","0" -> {
                if (value * 10 < MAX){
                    value = value * 10 + Integer.valueOf(tag as String)
                    displayValue()
                }
            }

            "c" -> {
                value = 0
                tempValue = 0
                displayValue()
            }

            "ce" -> {
                value = 0
                displayValue()
            }


            "plus","minus","mul","div" -> {
                if (!operation.isEmpty()){
                    when (tag) {
                        "plus" -> value += tempValue
                        "minus" -> value = tempValue - value
                        "mul" -> value *= tempValue
                        "div" -> value = tempValue / value
                    }

                    displayValue()
                }
                operation = tag as String
                tempValue = value
                value = 0

            }

            "equal" -> {

                if (!operation.isEmpty()){
                    when (operation) {
                        "plus" -> value += tempValue
                        "minus" -> value = tempValue - value
                        "mul" -> value *= tempValue
                        "div" -> value = tempValue / value
                    }

                    displayValue()
                    tempValue = 0
                    operation = ""
                }
            }

        }

    }

    fun displayValue(){
        textDisp.text = value.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textDisp = findViewById(R.id.text_display)
        findViewById<Button>(R.id.button_1).setOnClickListener(this)
        findViewById<Button>(R.id.button_2).setOnClickListener(this)
        findViewById<Button>(R.id.button_3).setOnClickListener(this)
        findViewById<Button>(R.id.button_4).setOnClickListener(this)
        findViewById<Button>(R.id.button_5).setOnClickListener(this)
        findViewById<Button>(R.id.button_6).setOnClickListener(this)
        findViewById<Button>(R.id.button_7).setOnClickListener(this)
        findViewById<Button>(R.id.button_8).setOnClickListener(this)
        findViewById<Button>(R.id.button_9).setOnClickListener(this)
        findViewById<Button>(R.id.button_0).setOnClickListener(this)

        findViewById<Button>(R.id.button_plus).setOnClickListener(this)
        findViewById<Button>(R.id.button_minus).setOnClickListener(this)
        findViewById<Button>(R.id.button_mul).setOnClickListener(this)
        findViewById<Button>(R.id.button_div).setOnClickListener(this)

        findViewById<Button>(R.id.button_equal).setOnClickListener(this)

        findViewById<Button>(R.id.button_c).setOnClickListener(this)
        findViewById<Button>(R.id.button_ce).setOnClickListener(this)

    }
}
