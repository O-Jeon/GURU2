package com.example.guruhw

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var myDb: DatabaseHelper
    lateinit var edtName: EditText
    lateinit var edtNumber: EditText
    lateinit var edtNameResult: EditText
    lateinit var edtNumberResult: EditText
    lateinit var btnInit: Button
    lateinit var btnInsert: Button
    lateinit var btnSelect: Button
    lateinit var btnUpdate: Button
    lateinit var btnDelete: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myDb = DatabaseHelper(this)

        edtName = findViewById(R.id.edtName)
        edtNumber = findViewById(R.id.edtNumber)
        edtNameResult = findViewById(R.id.edtNameResult)
        edtNumberResult = findViewById(R.id.edtNumberResult)

        btnInit = findViewById(R.id.btnInit)
        btnInsert = findViewById(R.id.btnInsert)
        btnSelect = findViewById(R.id.btnSelect)
        btnUpdate = findViewById(R.id.btnUpdate)
        btnDelete = findViewById(R.id.btnDelete)

        btnInsert.setOnClickListener {
            val isInserted = myDb.insertData(edtName.text.toString(), edtNumber.text.toString().toInt())
            if (isInserted)
                Toast.makeText(this@MainActivity, "Data Inserted", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this@MainActivity, "Data not Inserted", Toast.LENGTH_LONG).show()
        }

        btnUpdate.setOnClickListener {
            val isUpdated = myDb.updateData(edtName.text.toString(), edtNumber.text.toString().toInt())
            if (isUpdated)
                Toast.makeText(this@MainActivity, "Data Updated", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this@MainActivity, "Data not Updated", Toast.LENGTH_LONG).show()
        }

        btnDelete.setOnClickListener {
            val deletedRows = myDb.deleteData(edtName.text.toString())
            if (deletedRows > 0)
                Toast.makeText(this@MainActivity, "Data Deleted", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this@MainActivity, "Data not Deleted", Toast.LENGTH_LONG).show()
        }

        btnSelect.setOnClickListener {
            val res: Cursor = myDb.getAllData()
            if (res.count == 0) {
                Toast.makeText(this@MainActivity, "No Data Found", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val buffer = StringBuffer()
            while (res.moveToNext()) {
                buffer.append("Name: ${res.getString(0)}\n")
                buffer.append("Number: ${res.getInt(1)}\n\n")
            }

            edtNameResult.setText(buffer.toString())
            edtNumberResult.setText("")
        }

        btnInit.setOnClickListener {
            edtName.setText("")
            edtNumber.setText("")
            edtNameResult.setText("")
            edtNumberResult.setText("")
        }
    }
}
