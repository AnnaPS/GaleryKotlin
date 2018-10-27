package com.example.apolosan.myplayer

import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


//Este MediaProvider hace lo mismo que el get media de abajo
object MediaProvider {
    //pagina que nos provee de imagenes para poder cargarlas en el layout
    private val thumbBase = "https://picsum.photos/400/400/?random"
    //CACHE DE MEMORIA
    private var data = emptyList<MediaItem>()

    //Ejemplo de simulacion de peticion a un servidor usando la libreria Anko para que no ejecute en el mismo hilo para evitar que se bloquee
    fun dataAsync(callback: (List<MediaItem>) -> Unit) {

        doAsync {
            if (data.isEmpty()) {
                Thread.sleep(2000)
                data = (1..20).map {
                    MediaItem("Title $it", "$thumbBase$it", if (it % 3 == 0) MediaItem.Type.VIDEO else MediaItem.Type.PHOTO)
                }
            }
            uiThread {
                callback(data)
            }
        }


    }
}

/*    fun getMedia(): MutableList<MediaItem>{
var mediaItems : MutableList<MediaItem> = ArrayList()
    mediaItems.add(MediaItem("Title 1", "${thumbBase}",MediaItem.Type.PHOTO))
    mediaItems.add(MediaItem("Title 2", "${thumbBase}",MediaItem.Type.PHOTO))
    mediaItems.add(MediaItem("Title 3", "${thumbBase}",MediaItem.Type.VIDEO))
    mediaItems.add(MediaItem("Title 4", "${thumbBase}",MediaItem.Type.PHOTO))
    mediaItems.add(MediaItem("Title 5", "${thumbBase}",MediaItem.Type.PHOTO))
    mediaItems.add(MediaItem("Title 6", "${thumbBase}",MediaItem.Type.VIDEO))
    mediaItems.add(MediaItem("Title 7", "${thumbBase}",MediaItem.Type.VIDEO))
    mediaItems.add(MediaItem("Title 8", "${thumbBase}",MediaItem.Type.PHOTO))
    mediaItems.add(MediaItem("Title 9", "${thumbBase}",MediaItem.Type.PHOTO))
    mediaItems.add(MediaItem("Title 10", "${thumbBase}",MediaItem.Type.VIDEO))

    return mediaItems

}*/
