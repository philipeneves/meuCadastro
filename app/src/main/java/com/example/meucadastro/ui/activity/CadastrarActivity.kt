package com.example.meucadastro.ui.activity

import com.example.meucadastro.R
import com.example.meucadastro.database.AppDatabase
import com.example.meucadastro.database.dao.ProdutoDao
import com.example.meucadastro.model.Produto
import android.arch.persistence.room.Room
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_cadastrar.*

class CadastrarActivity : AppCompatActivity() {

    private lateinit var ProdutoDao: ProdutoDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar)
        val database = Room.databaseBuilder(
                this,
                AppDatabase::class.java,
                "meuBanco")
                .allowMainThreadQueries()
                .build()
        ProdutoDao = database.ProdutoDao()
        configureSaveButton()
    }

    private fun configureSaveButton() {
        btnSalvar.setOnClickListener {
            saveProduto()
            finish()
        }
    }

    private fun saveProduto() {
        val createdProduto = create()
        ProdutoDao.add(createdProduto)
    }

    private fun create(): Produto {
        val nome = inpnome.text.toString()
        val descricao = inpdesc.text.toString()
        val categoria = inpCat.text.toString()
        val preco = inppreco.text.toString().toDouble()
        return Produto(nome = nome, descricao = descricao, categoria = categoria, preco = preco)
    }
}
