package com.example.tech_programming.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.tech_programming.R
import com.example.tech_programming.databinding.ActivityMainBinding
import com.example.tech_programming.presentation.requestFragment.AllRequestShopNameFragment
import com.example.tech_programming.presentation.requestFragment.needRequestList.NeedAddEditRequestFragment
import com.example.tech_programming.presentation.shopItemFragment.NeedAddEditShopItemFragment
import com.example.tech_programming.presentation.shopNameFragment.ShopNameAddEditFragment
import com.example.tech_programming.presentation.shopNameFragment.ShopNameListFragment
import com.example.tech_programming.presentation.storageItemFragment.StorageEditAddFragment
import com.example.tech_programming.presentation.storageItemFragment.StorageItemListFragment

class MainActivity : AppCompatActivity(), StorageEditAddFragment.OnEditingFinishedListener,
    ShopNameAddEditFragment.OnEditingFinishedListener,
    NeedAddEditRequestFragment.OnEditingFinishedListener,
    NeedAddEditShopItemFragment.OnEditingFinishedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        fragmentTransactions(StorageItemListFragment())

        binding.bottomBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.storage -> fragmentTransactions(StorageItemListFragment())
                R.id.shops -> fragmentTransactions(ShopNameListFragment())
                R.id.required -> fragmentTransactions(AllRequestShopNameFragment())
                else -> {}
            }
            true
        }

    }

    fun fragmentTransactions(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onEditingFinished() {
        Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_SHORT).show()
        supportFragmentManager.popBackStack()
    }
}