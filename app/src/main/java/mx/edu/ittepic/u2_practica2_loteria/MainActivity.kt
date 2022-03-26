package mx.edu.ittepic.u2_practica2_loteria

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import mx.edu.ittepic.u2_practica2_loteria.databinding.ActivityMainBinding
import java.util.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var baraja: Array<Carta>
    var estado = true
    var pausar = true

    var contador = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var vaViene = MediaPlayer.create(this, R.raw.prueba)

        var elGallo = Carta(this, R.drawable.carta1, R.raw.audio1)
        var elDiablo = Carta(this, R.drawable.carta2, R.raw.audio2)
        var laDama = Carta(this, R.drawable.carta3, R.raw.audio3)
        var elCatrin = Carta(this, R.drawable.carta4, R.raw.audio4)
        var elParaguas = Carta(this, R.drawable.carta5, R.raw.audio5)
        var laSirena = Carta(this, R.drawable.carta6, R.raw.audio6)
        var laEscalera = Carta(this, R.drawable.carta7, R.raw.audio7)
        var laBotella = Carta(this, R.drawable.carta8, R.raw.audio8)
        var elBarril = Carta(this, R.drawable.carta9, R.raw.audio9)
        var elArbol = Carta(this, R.drawable.carta10, R.raw.audio10)
        var elMelon = Carta(this, R.drawable.carta11, R.raw.audio11)
        var elValiente = Carta(this, R.drawable.carta12, R.raw.audio12)
        var elGorrito = Carta(this, R.drawable.carta13, R.raw.audio13)
        var laMuerte = Carta(this, R.drawable.carta14, R.raw.audio14)
        var laPera = Carta(this, R.drawable.carta15, R.raw.audio15)
        var laBandera = Carta(this, R.drawable.carta16, R.raw.audio16)
        var elBandolon = Carta(this, R.drawable.carta17, R.raw.audio17)
        var elVioloncello = Carta(this, R.drawable.carta18, R.raw.audio18)
        var laGarza = Carta(this, R.drawable.carta19, R.raw.audio19)
        var elPajaro = Carta(this, R.drawable.carta20, R.raw.audio20)
        var laMano = Carta(this, R.drawable.carta21, R.raw.audio21)
        var laBota = Carta(this, R.drawable.carta22, R.raw.audio22)
        var laLuna = Carta(this, R.drawable.carta23, R.raw.audio23)
        var elCotorro = Carta(this, R.drawable.carta24, R.raw.audio24)
        var elBorracho = Carta(this, R.drawable.carta25, R.raw.audio25)
        var elNegrito = Carta(this, R.drawable.carta26, R.raw.audio26)
        var elCorazon = Carta(this, R.drawable.carta27, R.raw.audio27)
        var laSandia = Carta(this, R.drawable.carta28, R.raw.audio28)
        var elTambor = Carta(this, R.drawable.carta29, R.raw.audio29)
        var elCamaron = Carta(this, R.drawable.carta30, R.raw.audio30)
        var lasJaras = Carta(this, R.drawable.carta31, R.raw.audio31)
        var elMusico = Carta(this, R.drawable.carta32, R.raw.audio32)
        var laAraña = Carta(this, R.drawable.carta33, R.raw.audio33)
        var elSoldado = Carta(this, R.drawable.carta34, R.raw.audio34)
        var laEstrella = Carta(this, R.drawable.carta35, R.raw.audio35)
        var elCazo = Carta(this, R.drawable.carta36, R.raw.audio36)
        var elMundo = Carta(this, R.drawable.carta37, R.raw.audio37)
        var elApache = Carta(this, R.drawable.carta38, R.raw.audio38)
        var elNopal = Carta(this, R.drawable.carta39, R.raw.audio39)
        var elAlacran = Carta(this, R.drawable.carta40, R.raw.audio40)
        var laRosa = Carta(this, R.drawable.carta41, R.raw.audio41)
        var laCalavera = Carta(this, R.drawable.carta42, R.raw.audio42)
        var laCampana = Carta(this, R.drawable.carta43, R.raw.audio43)
        var elCantarito = Carta(this, R.drawable.carta44, R.raw.audio44)
        var elVenado = Carta(this, R.drawable.carta45, R.raw.audio45)
        var elSol = Carta(this, R.drawable.carta46, R.raw.audio46)
        var laCorona = Carta(this, R.drawable.carta47, R.raw.audio47)
        var laChalupa = Carta(this, R.drawable.carta48, R.raw.audio48)
        var elPino = Carta(this, R.drawable.carta49, R.raw.audio49)
        var elPescado = Carta(this, R.drawable.carta50, R.raw.audio50)
        var laPalma = Carta(this, R.drawable.carta51, R.raw.audio51)
        var laMaceta = Carta(this, R.drawable.carta52, R.raw.audio52)
        var elArpa = Carta(this, R.drawable.carta53, R.raw.audio53)
        var laRana = Carta(this, R.drawable.carta54, R.raw.audio54)

        baraja = arrayOf(
            elGallo, elDiablo, laDama, elCatrin, elParaguas,
            laSirena, laEscalera, laBotella, elBarril, elArbol, elMelon, elValiente,
            elGorrito, laMuerte, laPera, laBandera, elBandolon, elVioloncello, laGarza,
            elPajaro, laMano, laBota, laLuna, elCotorro, elBorracho, elNegrito, elCorazon,
            laSandia, elTambor, elCamaron, lasJaras, elMusico, laAraña, elSoldado, laEstrella,
            elCazo, elMundo, elApache, elNopal, elAlacran, laRosa, laCalavera, laCampana,
            elCantarito, elVenado, elSol, laCorona, laChalupa, elPino, elPescado, laPalma,
            laMaceta, elArpa, laRana
        )

        binding.btnBasta.setOnClickListener {
            if(controlCorutinas.isActive){
                controlCorutinas.cancel()
                binding.btnBasta.setText("Comprobar")
                binding.btnJugar.setEnabled(true)
                return@setOnClickListener
            }
            if(controlCorutinas.isCancelled){
                controlCorutinasSeguir.start()
                mostrarLoOculto(binding.ultimas)
                binding.ultimas.setText("Mostrando Cartas Faltantes")
                binding.btnJugar.setEnabled(true)
                return@setOnClickListener
            }
            if (controlCorutinasSeguir.isActive){
                controlCorutinasSeguir.cancel()
                mostrarLoOculto(binding.ultimas)
                binding.btnBasta.setText("Loteria")
                binding.btnJugar.setEnabled(true)
                return@setOnClickListener
            }
            if (controlCorutinasSeguir.isCancelled){
                binding.btnBasta.setEnabled(false)
            }
            binding.btnJugar.setEnabled(true)
        }

        binding.btnJugar.setOnClickListener {
            //vaViene.start()
            controlCorutinas.start()
            binding.btnJugar.setEnabled(false)
            binding.btnBasta.setEnabled(true)
        }

        binding.btnBarajar.setOnClickListener {
            barajar(baraja)
        }
    }


    fun barajar(laBaraja: Array<Carta>) {
        laBaraja.shuffle()
    }

    val scope = CoroutineScope(Job()+Dispatchers.Main)
    val controlCorutinas = scope.launch (EmptyCoroutineContext,CoroutineStart.LAZY){
        while (contador<=baraja.size-1){
            runOnUiThread {
                binding.cartaImagen.setImageBitmap(baraja[contador].imagenCarta)
                baraja[contador].decirCarta()
                contador++
            }
            delay(4000L)
        }
    }
    val controlCorutinasSeguir = scope.launch (EmptyCoroutineContext,CoroutineStart.LAZY){
        while (contador<=baraja.size-1){
            runOnUiThread {
                binding.cartaImagen.setImageBitmap(baraja[contador].imagenCarta)
                baraja[contador].decirCarta()
                contador++
            }
            delay(4000L)
        }
    }
    fun mostrarLoOculto(view: TextView) {
        view.visibility = if (view.visibility == TextView.VISIBLE) {
            TextView.INVISIBLE
        } else {
            TextView.VISIBLE
        }
    }
}

