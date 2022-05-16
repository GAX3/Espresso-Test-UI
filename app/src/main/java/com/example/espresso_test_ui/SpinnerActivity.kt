package com.example.espresso_test_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.espresso_test_ui.databinding.ActivitySpinnerBinding

class SpinnerActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var mBinding: ActivitySpinnerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySpinnerBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setUpView()
    }

    private fun setUpView() {
        val spinner = mBinding.spinner
        spinner.onItemSelectedListener = this
        ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item).also {
            it.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
            spinner.adapter = it
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        var texto = mBinding.tvSpinner
        val array = resources.getStringArray(R.array.planets_array)[p2]
        texto.text = array
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        var texto = mBinding.tvSpinner
        texto.setText("No options Selected")
    }
}