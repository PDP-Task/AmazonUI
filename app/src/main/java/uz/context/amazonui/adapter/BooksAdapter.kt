package uz.context.amazonui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.context.amazonui.R
import uz.context.amazonui.model.Book

class BooksAdapter(private val booksList: ArrayList<Book>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.books_item_layout, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val book = booksList[position]

        if (holder is BookViewHolder) {
            holder.apply {
                imageView.setImageResource(book.image)
                name.text = book.name
                price.text = "$${book.price}"
            }
        }
    }

    override fun getItemCount(): Int {
        return booksList.size
    }

    inner class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.image_book)
        val name: TextView = view.findViewById(R.id.text_title_book)
        val price: TextView = view.findViewById(R.id.text_price_book)
    }
}