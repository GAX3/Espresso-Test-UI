package com.example.espresso_test_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.espresso_test_ui.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var mBinding : ActivityMain2Binding
    var value = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setUpView()
    }

    private fun setUpView() {
        mBinding.btnReset.setOnClickListener {
            mBinding.tvMainSecond.text = "RESET"
        }

        mBinding.btnChange.setOnClickListener {
            mBinding.tvMainSecond.text = mBinding.edtSecond.text.toString()
        }

        mBinding.btnSecond.setOnClickListener {
            Toast.makeText(this, "Go to Login Activity", Toast.LENGTH_SHORT).show()
        }


    }
}