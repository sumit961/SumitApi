package com.example.sumitapi.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.test8.R

class EntityAdapter(private val onEntityClick: (Entity) -> Unit) :
    RecyclerView.Adapter<EntityAdapter.EntityViewHolder>() {

    private var entityList: List<Entity> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_entity, parent, false)
        return EntityViewHolder(view)
    }

    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {
        val entity = entityList[position]
        holder.bind(entity)
        holder.itemView.setOnClickListener {
            onEntityClick(entity) // Pass entity on click
        }
    }

    override fun getItemCount(): Int = entityList.size

    fun submitList(entities: List<Entity>) {
        this.entityList = entities
        notifyDataSetChanged()
    }

    class EntityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(entity: Entity) {
            // Bind entity data to your views in item layout
            itemView.findViewById<TextView>(R.id.albumTitle).text = entity.albumTitle
            itemView.findViewById<TextView>(R.id.artistName).text = entity.artistName
            itemView.findViewById<TextView>(R.id.releaseYear).text = entity.releaseYear.toString()
            itemView.findViewById<TextView>(R.id.genre).text = entity.genre
            itemView.findViewById<TextView>(R.id.trackCount).text = "${entity.trackCount} Tracks"

        }
    }
}



