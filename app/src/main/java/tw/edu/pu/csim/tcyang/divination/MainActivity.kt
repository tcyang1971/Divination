package tw.edu.pu.csim.tcyang.divination

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun Start(v: View){
        var t: TextView = findViewById(R.id.txv)
        t.text = "開始擲茭..."

        var img1: ImageView = findViewById(R.id.img1)
        var img2: ImageView = findViewById(R.id.img2)
        var a: Int = (0..1).random()  //擲筊1
        if (a == 0) {
            img1.setImageResource(R.drawable.sunnyside1)
        } else {
            img1.setImageResource(R.drawable.nightside1)
        }
        var b: Int = (0..1).random()  //擲筊2
        if (b == 0) {
            img2.setImageResource(R.drawable.sunnyside2)
        } else {
            img2.setImageResource(R.drawable.nightside2)
        }

        when (a+b) {
            0 -> t.text = "笑筊(表示神明一笑、不解，或者考慮中)"
            1 -> t.text = "聖筊(表示神明允許、同意，或行事會順利)"
            else -> t.text = "陰筊(表示神明否定、憤怒，或者不宜行事)"
        }

    }

}