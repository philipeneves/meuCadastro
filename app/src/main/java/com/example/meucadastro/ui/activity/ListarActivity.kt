package com.example.meucadastro.ui.activity

import com.example.meucadastro.R
import com.example.meucadastro.database.AppDatabase
import com.example.meucadastro.database.dao.ProdutoDao
import com.example.meucadastro.ui.activity.recyclerview.ProdutosListAdapter
import android.arch.persistence.room.Room
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_listar.*


class ListarActivity : AppCompatActivity() {

    private lateinit var ProdutoDao: ProdutoDao
    private lateinit var adapter: ProdutosListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar)
        val database = Room.databaseBuilder(
                this,
                AppDatabase::class.java,
                "meuBanco")
                .allowMainThreadQueries()
                .build()
        ProdutoDao = database.ProdutoDao()
        configureRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        adapter.replaceAllProdutos(ProdutoDao.all())
    }

    private fun configureRecyclerView() {
        this.adapter = ProdutosListAdapter(context = this)
        Produtos_list_recyclerview.adapter = adapter
    }

}
