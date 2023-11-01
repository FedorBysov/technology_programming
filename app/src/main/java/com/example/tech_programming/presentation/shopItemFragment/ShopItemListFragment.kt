package com.example.tech_programming.presentation.shopItemFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tech_programming.R

class ShopItemListFragment : Fragment() {

    companion object {
        fun newInstance() = ShopItemListFragment()
    }

    private lateinit var viewModel: ShopItemListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shop_item_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ShopItemListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}