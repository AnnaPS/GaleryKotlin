package com.example.apolosan.myplayer

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.media_item.view.*
import kotlin.properties.Delegates

//La lista es obligatoria y si no recibe nada sera un emptyList()
class MediaAdapter( items: List<MediaItem> = emptyList(), val listener: (MediaItem) -> Unit) : RecyclerView.Adapter<MediaAdapter.ViewHolder>() {

    //Uso de observable cuando se notifica de cambios
    var items: List<MediaItem> by Delegates.observable(items){ _, _, _ ->
        notifyDataSetChanged()
    }

    interface onMediaClickListener {
        fun onClick(mediaItem: MediaItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        // inflar la vista
        // val v = LayoutInflater.from(parent.context).inflate(R.layout.media_item, parent, false)

        val v = parent.inflate(R.layout.media_item)
        // devolver el viewHolder con la vista
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)// los corchetes es equivalente al get
        holder.itemView.setOnClickListener { listener(item) }
    }

    override fun getItemCount(): Int = items.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //Se pueden recuperar y setear de esta manera

        /* val title = view.find<TextView>(R.id.media_title)
         val image = view.find<ImageView>(R.id.media_thumb)
         val videoIndicator = view.find<ImageView>(R.id.media_video_indicator)
         fun bind(item : MediaItem){
             title.text = item.title
             image.loadUrl(item.thumbUrl)
             //When sustituye al switch de JAVA
             videoIndicator.visibility = when(item.type){
                 MediaItem.Type.VIDEO -> View.VISIBLE
                 MediaItem.Type.PHOTO -> View.GONE
             }
         }*/
        // o se pueden recuperar de esta manera
        fun bind(item: MediaItem) = with(itemView) {
            //de esta manera hace el findViewById
            media_title.text = item.title
            media_thumb.loadUrl(item.thumbUrl)
            media_video_indicator.visibility = when (item.type) {
                MediaItem.Type.VIDEO -> View.VISIBLE
                MediaItem.Type.PHOTO -> View.GONE
            }
        }
    }
}