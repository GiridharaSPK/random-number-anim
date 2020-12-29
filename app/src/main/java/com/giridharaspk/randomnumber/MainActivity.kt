package com.giridharaspk.randomnumber

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        animView.addAnimatorListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator?) {
                super.onAnimationStart(animation)
                showRandomNumber();
                btRandom.isEnabled = false
            }

            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                btRandom.isEnabled = true
            }

        })

        btRandom.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                animView.playAnimation()
            }

        })
    }

    private fun showRandomNumber() {
        var random = Random()
        var num = random.nextInt(6)+1
        tvNum.text = "$num"
    }
}