package com.ksoft.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.ksoft.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Declaring the Binding object
    private lateinit var binding: ActivityMainBinding
    //Declaring the data class object
    private val myName: MyName = MyName("Rakibur Khan")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Setting bind to main activity class and xml
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myname = myName

        binding.doneButton.setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view: View) {
        //the generic bind method which by default takes members under bind
        binding.apply {
           myName.nickname = nicknameEdit.text.toString()
            binding.invalidateAll()
           nicknameEdit.visibility = View.GONE
           view.visibility = View.GONE
           nicknameText.visibility = View.VISIBLE
        }
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
