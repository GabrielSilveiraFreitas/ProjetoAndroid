package com.example.calculadora

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.calculadora.classes.Produtos
import kotlinx.android.synthetic.main.item.view.*

class ProdutoAdapter(private val produtos: List<Produtos>): RecyclerView.Adapter<ProdutoAdapter.VH> (){



    class VH(itemView: View):RecyclerView.ViewHolder(itemView){
        val txtMarca:TextView =itemView.txtMarca
        val txtVolume:TextView =itemView.txtVolume
        val txtValor:TextView =itemView.txtValor
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v =LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        val vh = VH(v)
        return vh
    }
    override fun getItemCount(): Int {
        return produtos.size
    }
    override fun onBindViewHolder(holder: VH, position: Int) {
        var produto =produtos[position]
        holder.txtMarca.text = produto.marca
        holder.txtVolume.text = produto.volume.toString()
        holder.txtValor.text = produto.valor.toString()
    }
}