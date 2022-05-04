package com.example.espresso_test_ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.espresso_test_ui.utils.PersonAdapter
import com.example.espresso_test_ui.utils.Personas


class RecyclerActivity : AppCompatActivity(), OnClickListener {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList : ArrayList<Personas>
    lateinit var namePerson: Array<String>
    lateinit var agePerson: Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        setUpList()
    }


    private fun setUpList(){

        newRecyclerView = findViewById(R.id.recyclerActivityRv)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Personas>()
        getUserData()
    }


    private fun getUserData() {
        newArrayList.add(Personas("Alberto", "20"))
        newArrayList.add(Personas("Beatriz", "22"))
        newArrayList.add(Personas("Carlos", "24"))
        newArrayList.add(Personas("Diana", "26"))
        newArrayList.add(Personas("Eduardo", "28"))
        newArrayList.add(Personas("Francisca", "30"))
        newArrayList.add(Personas("Gustavo", "32"))
        newArrayList.add(Personas("Hilda", "34"))
        newArrayList.add(Personas("Ismael", "36"))
        newArrayList.add(Personas("Julia", "38"))
        newArrayList.add(Personas("Karla", "40"))
        newArrayList.add(Personas("Luis", "42"))
        newArrayList.add(Personas("Marta", "44"))
        newArrayList.add(Personas("Nicolas", "46"))
        newArrayList.add(Personas("Orfelia", "48"))


        newRecyclerView.adapter = PersonAdapter(newArrayList, this@RecyclerActivity)
    }

    override fun onItemClick(namePerson: String) {
        Toast.makeText(this, "Welcome $namePerson", Toast.LENGTH_SHORT).show()
    }
}

