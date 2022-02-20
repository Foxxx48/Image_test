package com.fox.imagetest

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.fox.imagetest.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

   lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.testImageView.layoutParams.width = resources.getDimensionPixelSize(R.dimen.image_width)
//        binding.testImageView.layoutParams.height = resources.getDimensionPixelSize(R.dimen.image_height)
        binding.testImageView.requestLayout()


        binding.getRandomImageButton.setOnClickListener {
            onGetRandomImagePressed()
        }

        binding.getRandomImageButton.setOnLongClickListener {
           showToastWithRandomNumber()
        }
    }

    private fun onGetRandomImagePressed(){
        Glide.with(this)
            .load("https://source.unsplash.com/random/800*600")
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .placeholder(R.drawable.ic_action_point)
            .into(binding.testImageView)
    }


   private fun showToastWithRandomNumber(): Boolean {
       val number = Random.nextInt(100)
       val message = getString("Random number: ", number)
       Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        return true
    }

    private fun getString(s: String, number: Int): String {
            return s + number
    }


}


