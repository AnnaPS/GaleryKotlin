package com.example.apolosan.myplayer

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso

// esta funcion se comportatá como si todo estuviera dentro del contexto.
//Al ser utilizado Context
fun Context.toast(message : String, length : Int = Toast.LENGTH_SHORT){
    Toast.makeText(this,message,length).show()

}

fun ViewGroup.inflate(layoutRes : Int) : View{
    return LayoutInflater.from(context).inflate(layoutRes,this,false)
}

fun ImageView.loadUrl(url : String){
    Picasso.with(context).load(url).into(this)
}

// asi conseguimos hacerlo generico y evitamos hacer castings
inline fun <reified T : View>View.find(idRes : Int): T{
    return findViewById(idRes) as T

}


inline fun <reified T : View> RecyclerView.ViewHolder.find(idRes : Int): T{
    return itemView.find(idRes)

}
//funcion de extension sobre cualquier objeto. El valor de retorno es del mismo tipo del valor de entrada
// La funcion de lambda no recibe parametros y devuelve "nada" asi que es Unit
fun <T> T.apply2(f: T.()-> Unit): T{
    f()
    return this
}