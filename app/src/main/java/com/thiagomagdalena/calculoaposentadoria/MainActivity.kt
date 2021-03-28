package com.thiagomagdalena.calculoaposentadoria

import android.app.Activity
import android.os.Bundle
import android.widget.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //definindo o arquivo de layout
        setContentView(R.layout.activity_main)

        //aceessando o spinner
        val spn_sexo = findViewById<Spinner>(R.id.spn_sexo)

        //acessando a caixa da idade
        val txt_idade = findViewById<EditText>(R.id.txt_idade)

        //acessando o botão calcular
        val btn_calcular = findViewById<Button>(R.id.btn_calcular)

        //acessando o resultado
        val txt_resultado = findViewById<TextView>(R.id.txt_resultado)

        spn_sexo.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listOf("masculino", "feminino"))

        btn_calcular.setOnClickListener {
            val sexo = spn_sexo.selectedItem as String
            val idade = txt_idade.text.toString().toInt()
            var resultado = 0
            if(sexo == "masculino"){
                resultado = 65 - idade
            } else {
                resultado = 60 - idade
            }

            txt_resultado.text = "Faltam $resultado anos para você se aposentar"
        }

    }
}