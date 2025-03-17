package br.edu.fatecpg.calculoohm

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


// 2. Desenvolva um app Cálculo da primeira lei de Ohm. V = R*I
//
//Caso receba tensão e resistência calcular corrente
//Caso receba tensão e corrente calcular resistência
//Caso receba resistência e corrente calcular tensão

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val corrente = findViewById<EditText>(R.id.edt_cor)
        val tensao = findViewById<EditText>(R.id.edt_ten)
        val resistencia = findViewById<EditText>(R.id.edt_res)
        val result = findViewById<TextView>(R.id.txv_result)
        val botao = findViewById<Button>(R.id.btn_calc)

        botao.setOnClickListener{

            val corrVal = corrente.text.toString().toDoubleOrNull()
            val tenVal = tensao.text.toString().toDoubleOrNull()
            val resVal = resistencia.text.toString().toDoubleOrNull()

            if(corrVal != null && tenVal != null && resVal == null) {
                // calculo de calcular resistencia
                val resCal = tenVal / corrVal
                result.text = "Resistencia: $resCal"

            } else if (tenVal != null && resVal != null && corrVal == null) {
                val corrCal = tenVal / resVal
                result.text = "Corrente: $corrCal"
                // calcular corrente

            } else if(resVal != null && corrVal != null && tenVal == null) {
                //calcular tensao
                val tenCal = resVal * corrVal
                result.text = "Tensão: $tenCal"

            } else {
                result.text = "Digitar somente dois valores"

            }

        }
    }
}