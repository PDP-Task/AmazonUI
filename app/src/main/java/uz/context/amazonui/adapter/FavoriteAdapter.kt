package uz.context.amazonui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.context.amazonui.R
import uz.context.amazonui.model.Favorite

class FavoriteAdapter(context: Context, private val favoriteList: ArrayList<Favorite>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_feed_layout, parent, false)
        return FavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val favorite = favoriteList[position]

        if (holder is FavoriteViewHolder) {
            holder.apply {
                title.text = favorite.title
                imageView.setImageResource(favorite.image)
            }
        }
    }

    override fun getItemCount(): Int {
        return favoriteList.size
    }

    inner class FavoriteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tv_title)
        val imageView: ImageView = view.findViewById(R.id.iv_image)
    }
}