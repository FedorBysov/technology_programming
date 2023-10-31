package com.example.tech_programming.presentation.storageItemFragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.tech_programming.R
import com.example.tech_programming.databinding.ActivityStorageItemListBinding
import com.example.tech_programming.presentation.AppApplication
import com.example.tech_programming.presentation.ViewModelFactory
import com.example.tech_programming.presentation.adapter.AdapterStorageItem
import javax.inject.Inject

class StorageItemListActivity:AppCompatActivity() , StorageEditAddFragment.OnEditingFinishedListener {

    private lateinit var binding: ActivityStorageItemListBinding
    private lateinit var viewModel: StorageItemListViewModel
    private lateinit var mainAdapter: AdapterStorageItem

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy{
        (application as AppApplication).component
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)

        super.onCreate(savedInstanceState)
        binding = ActivityStorageItemListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, viewModelFactory)[StorageItemListViewModel::class.java]


        val buttonAddItem = binding.btnAdd
        buttonAddItem.setOnClickListener {
                val intent = StorageEditAddActivity.newIntentStorageItemActivity(this)
                startActivity(intent)
        }

        setupAdapter()
        setupClick()
        setupItemTouchHelper()


        viewModel.storageList.observe(this) {
            Log.d("TEST_LOADING_LIVE_DATA", "${it.toString()}")
            mainAdapter.submitList(it)
        }

    }

    override fun finishEditing() {
        Toast.makeText(this@StorageItemListActivity, "Successful!!!", Toast.LENGTH_SHORT).show()
        supportFragmentManager.popBackStack()
    }

    private fun launchFragment(fragment: Fragment) {
        supportFragmentManager.popBackStack()
        supportFragmentManager.beginTransaction()
            .replace(R.id.storage_item_container, fragment)
            .addToBackStack(null)
            .commit()
    }


    private fun setupAdapter() {
        mainAdapter = AdapterStorageItem()
        binding.listRV.adapter = mainAdapter
        binding.listRV.recycledViewPool.setMaxRecycledViews(
            AdapterStorageItem.ENABLED_VIEW,
            AdapterStorageItem.POOL_VIEW_ACTIV
        )
        binding.listRV.recycledViewPool.setMaxRecycledViews(
            AdapterStorageItem.DISABLED_VIEW,
            AdapterStorageItem.POOL_VIEW_DISABLE
        )
    }

    private fun setupItemTouchHelper() {
        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = mainAdapter.currentList[viewHolder.adapterPosition]
                viewModel.deleteStorageList(item)
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(binding.listRV)
    }



    private fun setupClick() {
        mainAdapter.onStorageItemClickListener= {
            val intent = StorageEditAddActivity.editIntentStorageItemActivity(this, it.id)
            startActivity(intent)
        }
    }



}