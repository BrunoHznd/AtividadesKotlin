package br.edu.fatecpg.conversortemperatuda

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

// Crie um App de conversão de temperatura:
// tenha um campo de texto (EditText) para digitar uma temperatura em Celsius,
// um botão que realize a conversão para Fahrenheit e um TextView para exibir o resultado
// da conversão.

//formula da conversão: F = C x 1,8 + 32

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val nm_temp = findViewById<EditText>(R.id.nm_temp)
        val btn_converter = findViewById<Button>(R.id.btn_converter)
        val txv_temp = findViewById<TextView>(R.id.txv_temp)

        btn_converter.setOnClickListener{

            val celsiusText = nm_temp.text.toString()
            val celsius = celsiusText.toDoubleOrNull()
            //conversão maldita...

            if(celsius != null) {

                val fahr = celsius * 1.8 + 32
                txv_temp.text = "Temperatura em F° $fahr"

            }
            else {
                txv_temp.text = "Digita o valor..."
            }



        }



    }
}