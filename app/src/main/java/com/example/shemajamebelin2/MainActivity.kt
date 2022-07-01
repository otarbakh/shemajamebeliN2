package com.example.shemajamebelin2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shemajamebelin2.databinding.ActivityMainBinding

val mapOfWords = mutableMapOf<String,String>()

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnSave.setOnClickListener {
            var annagram = binding.edAnagram.text.toString()
            sort(annagram)
        }

        binding.btnOutput.setOnClickListener {

            val userInput = binding.edAnagram.text.toString()
            var str = userInput
            str = str.split("").sorted().joinToString("")

            if (mapOfWords.containsValue(str)){
                binding.tvAnagramCount.text = "$userInput ARSEBOBS ! ! !"
            }
        }
    }

    fun sort (annagram:String){
        var str = annagram
        str = str.split("").sorted().joinToString("")
        mapOfWords[annagram] = str
        binding.tvAnagramCount.text = mapOfWords.size.toString()
    }
}

