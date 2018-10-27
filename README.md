#GaleryKotlin
Aplicación escrita en Kotlin. Muestra ejemplos del lenguaje.
La aplicación carga en un recyclerview fotos de una página web gracias a Picasso.
Filtra entre fotos y videos.

- **ANKO**
- **Recyclerview**
- **Gridlayout**
- **Picasso**
- **Kotlin extensions**

Para poder utilizar Kotlin extensions se debe añadir el plugin en el fichero build.gradle ( Module.app)
```
apply plugin: 'kotlin-android-extensions'
```
##Dependecias utilizadas
```
 implementation "org.jetbrains.anko:anko:$anko_version"
 implementation 'com.android.support.constraint:constraint-layout:1.1.0'
 implementation "com.android.support:recyclerview-v7:+"
 implementation "com.squareup.picasso:picasso:2.5.2"
```
