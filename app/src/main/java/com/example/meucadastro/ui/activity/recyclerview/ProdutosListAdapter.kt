package com.example.meucadastro.ui.activity.recyclerview

import com.example.meucadastro.R
import com.example.meucadastro.model.Produto
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.custom_item.view.*

class ProdutosListAdapter(
        private val Produtos: MutableList<Produto> = mutableListOf(),
        private val context: Context) : RecyclerView.Adapter<ProdutosListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val createdView = LayoutInflater.from(context).inflate(R.layout.custom_item, parent, false)
        return ViewHolder(createdView)
    }

    override fun getItemCount(): Int {
        return Produtos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Produto = Produtos[position]
        holder.bind(Produto)
    }

    fun add(Produtos: List<Produto>) {
        this.Produtos.addAll(Produtos)
        notifyItemRangeInserted(0, Produtos.size)
    }

    fun replaceAllProdutos(Produtos: List<Produto>) {
        this.Produtos.clear()
        this.Produtos.addAll(Produtos)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val name: TextView = itemView.idNome
        private val description: TextView = itemView.idDesc
        private val quantity: TextView = itemView.idPreco

        fun bind(Produto: Produto) {
            name.text = Produto.nome
            description.text = Produto.descricao
            quantity.text = Produto.preco.toString()
        }
    }
}