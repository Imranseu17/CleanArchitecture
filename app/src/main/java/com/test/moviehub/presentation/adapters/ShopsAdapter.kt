package com.test.moviehub.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.moviehub.data.model.Shop
import com.test.moviehub.databinding.ItemMoviewBinding

class ShopsAdapter(private val listener: ShopItemListener) : RecyclerView.Adapter<ShopViewHolder>() {

    interface ShopItemListener {
        fun onClickedShops(shopId: String)
    }

    private val items = ArrayList<Shop>()

    fun setItems(items: ArrayList<Shop>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val binding: ItemMoviewBinding =
            ItemMoviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShopViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) = holder.bind(items[position])
}

class ShopViewHolder(private val itemBinding: ItemMoviewBinding,
                     private val listener: ShopsAdapter.ShopItemListener) :
    RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {

    private lateinit var shop: Shop

    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: Shop) {
        this.shop = item
        itemBinding.name.text = item.name
        itemBinding.access.text = item.access
        itemBinding.address.text = item.address
        Glide.with(itemBinding.root)
            .load(item.photo?.mobile?.longSize)
            .into(itemBinding.image)
    }

    override fun onClick(v: View?) {
       listener.onClickedShops(shop.id)
    }
}

