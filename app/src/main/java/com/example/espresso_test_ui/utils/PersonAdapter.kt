package com.example.espresso_test_ui.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.espresso_test_ui.R
import com.example.espresso_test_ui.RecyclerActivity
import com.example.espresso_test_ui.databinding.ListItemPersonaBinding


class PersonAdapter(private var personas: ArrayList<Personas>, private var listener: RecyclerActivity): RecyclerView.Adapter<PersonAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_persona, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PersonAdapter.ViewHolder, position: Int) {
        val currentItem = personas[position]
        with(holder){
            setListener(currentItem)
            holder.namePerson.text = currentItem.nombre
            holder.agePerson.text = currentItem.edad
        }
    }

    override fun getItemCount(): Int {
        return personas.size
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val namePerson: TextView = view.findViewById(R.id.tvNombre)
        val agePerson: TextView = view.findViewById(R.id.tvEdad)

        val mBinding = ListItemPersonaBinding.bind(view)

        fun setListener(myDataItem: Personas){
            mBinding.root.setOnClickListener {
                listener.onItemClick(myDataItem.nombre)
            }
        }
    }

}