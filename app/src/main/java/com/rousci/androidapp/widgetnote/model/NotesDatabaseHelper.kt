package com.rousci.androidapp.widgetnote.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

/**
 * Created by rousci on 17-10-11.
 * a standard anko database
 * anko is simple to use
 * I do not not want to dear with complex api of tools
 * so I choose it
 */

class NotesDatabaseHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "Notes", null, 1) {

    /*I just copy this companion object from the doc of anko
    * in fact I really do not know what is the "@Synchronized" or "instance"*/
    companion object {
        private var instance: NotesDatabaseHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): NotesDatabaseHelper {
            if (instance == null) {
                instance = NotesDatabaseHelper(ctx.getApplicationContext())
            }
            return instance!!
        }
    }

    override fun onCreate(dataBase: SQLiteDatabase) {
        dataBase.createTable(
                "note_table",
                true,
                "id" to INTEGER + PRIMARY_KEY + AUTOINCREMENT + UNIQUE,
                "content" to TEXT + NOT_NULL
        )
    }

    override fun onUpgrade(dataBase: SQLiteDatabase, p1: Int, p2: Int) {
        dataBase.dropTable("note_table", true)
    }

}