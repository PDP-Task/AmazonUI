package uz.context.amazonui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.context.amazonui.R
import uz.context.amazonui.model.Book
import uz.context.amazonui.model.Explore

class ExploreAdapter(private val exList: ArrayList<Explore>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_explore, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val ex = exList[position]

        if (holder is BookViewHolder) {
            holder.apply {
                imageView.setImageResource(ex.image)
                name.text = ex.title
            }
        }
    }

    override fun getItemCount(): Int {
       return exList.size
    }

    inner class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.explore_image)
        val name: TextView = view.findViewById(R.id.explore_title)
    }
}