package com.example.meucadastro.database.dao

import com.example.meucadastro.model.Produto
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface ProdutoDao {

    @Query("SELECT * FROM Produto")
    fun all(): List<Produto>

    @Insert
    fun add(vararg Produto: Produto)

}