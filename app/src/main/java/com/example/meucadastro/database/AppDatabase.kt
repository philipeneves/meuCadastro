package com.example.meucadastro.database

import com.example.meucadastro.database.dao.ProdutoDao
import com.example.meucadastro.model.Produto
import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [Produto::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun ProdutoDao(): ProdutoDao
}