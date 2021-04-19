package com.iCan.infotech.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.iCan.infotech.R
import com.iCan.infotech.model.product.Product

class ProductAdapter(private var products: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bindProduct(products[position])
    }

    override fun getItemCount(): Int {
        return products.size
    }

    fun update(data: List<Product>) {
        products = data
        notifyDataSetChanged()
    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ivProductImage:AppCompatImageView = itemView.findViewById(R.id.ivProductImage)
        private val tvProductName:AppCompatTextView = itemView.findViewById(R.id.tvProductName)
        private val tvMRP:AppCompatTextView = itemView.findViewById(R.id.tvMRP)
        private val tvSellingPrice:AppCompatTextView = itemView.findViewById(R.id.tvSellingPrice)
        private val tvStock:AppCompatTextView = itemView.findViewById(R.id.tvStock)

        @SuppressLint("SetTextI18n")
        fun bindProduct(product: Product) {
            Glide
                .with(ivProductImage.context)
                .load(product.cImage)
                .into(ivProductImage)

            tvProductName.text = product.cName
            tvMRP.text = "${product.currency} ${product.fMRP}"
            tvSellingPrice.text = "${product.currency} ${product.fPrice}"
            tvStock.text = product.fStock.toString()
        }
    }
}