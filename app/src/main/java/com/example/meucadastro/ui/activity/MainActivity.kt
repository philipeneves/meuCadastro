package com.example.meucadastro

import com.example.meucadastro.ui.activity.CadastrarActivity
import com.example.meucadastro.ui.activity.ListarActivity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
//Classe criada utilizando como base uma classe base "genérica" chamada "AppCompatActivity()"
// que dá suporte aos recursos de ActionBar
class MainActivity : AppCompatActivity() {

    //Função que cria a activity quando essa é chamada pela primeira vez ou executada
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Seleciona como Content view o arquivo activity_main.xml
        setContentView(R.layout.activity_main)
        //Define o titulo da página
        setTitle("Menu Principal")
        //Instância da classe App (Singleton)

        //Variáveis que usam os componentes que irão compor a tela, estes componentes foram criados no arquivo
        // activity_main.xml
        var btCadastrar = findViewById(R.id.btcad) as Button
        var btListar = findViewById(R.id.btlist) as Button
        var btDeletar = findViewById(R.id.btdel) as Button
        val contexto: Context = this
        //Chama a tela de cadastro
        btCadastrar.setOnClickListener{
            val int = Intent(contexto, CadastrarActivity::class.java)
            startActivity(int)
        }
        //Chama a tela de listagem
        btListar.setOnClickListener{
            val int = Intent(contexto, ListarActivity::class.java)
            startActivity(int)
        }
        //Chama a tela de deleção
        btDeletar.setOnClickListener{
        }
    }
}
