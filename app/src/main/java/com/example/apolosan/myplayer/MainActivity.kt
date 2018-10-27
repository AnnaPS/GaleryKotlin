package com.example.apolosan.myplayer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    //Objeto que van a compartir todas las instancias de esta clase. Pueden ser compartidas con todas las activities.
    // Si alguna de las activities modifica el companion object, cambiará para todas, es igual que el static de Java
    companion object {
        var string: String =""
    }

    //val myRecyclerView by lazy { findViewById(R.id.myRecycler) as RecyclerView }
    val adapter = MediaAdapter{mediaItem -> toast(mediaItem.title) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Podemos recuperar el adaptador de esta manera gracias al plugin añadido a gradle apply plugin: 'kotlin-android-extensions'
        myRecycler.layoutManager = GridLayoutManager(this, 2)

        //it es una variable reservada para poder usar en cualquier lambda que solo recibe un parametro de entrada
        //myRecycler.adapter = MediaAdapter(getMedia()){toast(it.title)  }

        //myRecyclerView.adapter = MediaAdapter(getMedia()){mediaItem -> toast(mediaItem.title)  }
        myRecycler.adapter = adapter
        MediaProvider.dataAsync { adapter.items = it }


        //Ejemplo de function extension con lambda
        val textView = TextView(this).apply2 {
            text = "Hello"
            textSize = 20f
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    /*override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        //Filtramos por el tipo
        adapter.items = MediaProvider.data.let { media ->
            when (item?.itemId){
                R.id.filterAll -> media
                R.id.filterPhotos -> media.filter {it.type == MediaItem.Type.PHOTO}
                R.id.filterVideos -> media.filter { it.type == MediaItem.Type.VIDEO }
                else -> emptyList()
            }
        }
        return true

    }*/
    //Usamos el metodo async
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        //Filtramos por el tipo
        MediaProvider.dataAsync { media ->
            adapter.items = when (item?.itemId) {
                R.id.filterAll -> media
                R.id.filterPhotos -> media.filter { it.type == MediaItem.Type.PHOTO }
                R.id.filterVideos -> media.filter { it.type == MediaItem.Type.VIDEO }
                else -> emptyList()
            }
        }
        return true
    }

}
