package com.example.apolosan.myplayer

import android.support.v7.widget.RecyclerView
import android.util.Log
import kotlin.properties.Delegates

//Ejemplo lazy que es un property delegation
//val myRecycler by lazy { findViewById<RecyclerView>(R.id.myRecycler) }

//Ejemplo observable, que esta escuchando para saber si una variable cambia de valor en algun momento
val observableNumber by Delegates.observable(0){ p, old, new -> Log.d("Observable","old value: $old, new value: $new")}

// Ejemplo de vetoable. Parecido al obsevable pero con la diferencia que esto se produce justo antes. El valor solo se asigna si es igual o mayor a 0
val positiveNumber by Delegates.vetoable(0){p, old, new -> new >=0}

//Ejemplo de lateinit. Permite definir una propiedad sin valor inicial, indicando que en algun momento del codigo sera inicializado
lateinit var recyclerView: RecyclerView
