package uz.context.amazonui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.context.amazonui.adapter.BooksAdapter
import uz.context.amazonui.adapter.ExploreAdapter
import uz.context.amazonui.adapter.FavoriteAdapter
import uz.context.amazonui.model.Book
import uz.context.amazonui.model.Explore
import uz.context.amazonui.model.Favorite

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var llFashion: LinearLayout
    private lateinit var llPopular: LinearLayout
    private lateinit var favoriteAdapter: FavoriteAdapter
    private lateinit var recyclerBook: RecyclerView
    private lateinit var booksAdapter: BooksAdapter
    private lateinit var exploreRecyclerView: RecyclerView
    private lateinit var exAdapter: ExploreAdapter
    private val bookList: ArrayList<Book> = ArrayList()
    private val favoriteList: ArrayList<Favorite> = ArrayList()
    private val exList: ArrayList<Explore> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerview_essential)
        recyclerBook = findViewById(R.id.recyclerview_books)
        exploreRecyclerView = findViewById(R.id.recyclerview_explore)
        llFashion = findViewById(R.id.ll_fashion)
        llPopular = findViewById(R.id.ll_popular)
        exploreRecyclerView.layoutManager = GridLayoutManager(this,2)
        recyclerBook.layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        favoriteAdapter = FavoriteAdapter(this, favoriteList())
        recyclerView.adapter = favoriteAdapter
        booksAdapter = BooksAdapter(booksList())
        recyclerBook.adapter = booksAdapter
        exploreRecyclerView.adapter = ExploreAdapter(exList())

        setLinearHeight(llFashion)
        setLinearHeight(llPopular)
    }

    private fun booksList(): ArrayList<Book> {
        bookList.add(Book(R.drawable.book_1, "Business Creativity", 359))
        bookList.add(Book(R.drawable.book_2, "City One The Edge", 505))
        bookList.add(Book(R.drawable.book_3, "The change nature of work", 109))
        for (i in 0..10) {
            if (i % 2 == 0) {
                bookList.add(Book(R.drawable.book_1, "Business Creativity", 359))
            } else {
                bookList.add(Book(R.drawable.book_2, "City One The Edge", 505))
            }
        }
        return bookList
    }

    private fun setLinearHeight(layout: LinearLayout) {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val heightPx = displayMetrics.heightPixels

        val heightInDp: Int = heightPx / resources.displayMetrics.density.toInt()

        val params: ViewGroup.LayoutParams = layout.layoutParams
        params.height = heightInDp
        layout.layoutParams = params
    }

    private fun favoriteList(): ArrayList<Favorite> {
        favoriteList.add(Favorite("Oculus", R.drawable.img_oculus))
        favoriteList.add(Favorite("Oculus", R.drawable.im_gamer_2))
        favoriteList.add(Favorite("Oculus", R.drawable.img_game2))
        favoriteList.add(Favorite("Oculus", R.drawable.im_game))
        favoriteList.add(Favorite("Oculus", R.drawable.img_game3))
        favoriteList.add(Favorite("Oculus", R.drawable.img_game4))
        favoriteList.add(Favorite("Oculus", R.drawable.img_oculus))
        favoriteList.add(Favorite("Oculus", R.drawable.img_game2))

        return favoriteList
    }
    private fun exList(): ArrayList<Explore> {
        exList.add(Explore(R.drawable.ima_1,"Beauty"))
        exList.add(Explore(R.drawable.ima_2,"Beauty"))
        exList.add(Explore(R.drawable.im_game,"Beauty"))
        exList.add(Explore(R.drawable.img_cam1,"Beauty"))
        exList.add(Explore(R.drawable.img_oculus,"Beauty"))
        exList.add(Explore(R.drawable.im_game,"Beauty"))
        return exList
    }
}