package com.example.calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calculadora.classes.Produtos
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var lista = arrayListOf<Produtos>()
    var adapter = ProdutoAdapter(lista)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_add.setOnClickListener(View.OnClickListener {
            add()

        })
    }

    fun add(){
        if(edit_marca.text.toString().length>3){
            val produto =Produtos(edit_marca.text.toString(),edit_volume.text.toString().toDouble(),edit_valor.text.toString().toDouble())
            edit_marca.text.clear()
            edit_volume.text.clear()
            edit_valor.text.clear()
            lista.add(produto)
            initRecyclerView()
        }else{
            Toast.makeText(this,"texto Muito Curto",Toast.LENGTH_SHORT).show()
        }
    }
    fun initRecyclerView(){
        rvDados.adapter = adapter
        val layout = LinearLayoutManager(this)
        rvDados.layoutManager = layout

    }

}
