package mx.edu.ittepic.u2_practica2_loteria

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaPlayer
import android.provider.MediaStore

class Carta(M: MainActivity, carta: Int, audio: Int){
    var soundPlayer = MediaPlayer.create(M.baseContext,audio)
    var imagenCarta = BitmapFactory.decodeResource(M.resources,carta)

    fun mostrarCarta(): Bitmap{
        return imagenCarta
    }

    fun decirCarta(){
        soundPlayer.start()
    }
}