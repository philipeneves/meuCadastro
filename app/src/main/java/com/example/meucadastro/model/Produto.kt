package com.example.meucadastro.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Produto(
        @PrimaryKey(autoGenerate = true)
        val id: Long = 0,
        val nome: String,
        val descricao: String,
        val preco: Double,
        val categoria: String)