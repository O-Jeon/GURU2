package com.example.guruhw

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "groupDB"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME = "groupTBL"
        const val COL_NAME = "gName"
        const val COL_NUMBER = "gNumber"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE $TABLE_NAME ($COL_NAME TEXT PRIMARY KEY, $COL_NUMBER INTEGER)"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertData(name: String, number: Int): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues().apply {
            put(COL_NAME, name)
            put(COL_NUMBER, number)
        }
        val result = db.insert(TABLE_NAME, null, contentValues)
        return result != -1L
    }

    fun updateData(name: String, number: Int): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues().apply {
            put(COL_NUMBER, number)
        }
        db.update(TABLE_NAME, contentValues, "$COL_NAME = ?", arrayOf(name))
        return true
    }

    fun deleteData(name: String): Int {
        val db = this.writableDatabase
        return db.delete(TABLE_NAME, "$COL_NAME = ?", arrayOf(name))
    }

    fun getAllData(): Cursor {
        val db = this.writableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }
}
