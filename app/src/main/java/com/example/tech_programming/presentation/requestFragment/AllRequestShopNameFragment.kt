package com.example.tech_programming.presentation.requestFragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.tech_programming.R
import com.example.tech_programming.databinding.FragmentListItemsBinding
import com.example.tech_programming.presentation.AppApplication
import com.example.tech_programming.presentation.ViewModelFactory
import com.example.tech_programming.presentation.adapter.AdapterShopName
import com.example.tech_programming.presentation.adapter.AdapterStorageItem
import com.example.tech_programming.presentation.requestFragment.needRequestList.NeedListRequestFragment
import com.example.tech_programming.presentation.shopNameFragment.ShopNameListViewModel
import javax.inject.Inject

class AllRequestShopNameFragment : Fragment() {


    private lateinit var _binding: FragmentListItemsBinding
    private val binding
        get() = _binding!!
    private lateinit var viewModel: ShopNameListViewModel
    private lateinit var mainAdapter: AdapterShopName

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy{
        (requireActivity().application as AppApplication).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListItemsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, viewModelFactory)[ShopNameListViewModel::class.java]

        binding.btnAdd.visibility = View.INVISIBLE

        setupAdapter()
        setupClick()
        setupItemTouchHelper()


        viewModel.shopNameList.observe(requireActivity()) {
            Log.d("TEST_LOADING_LIVE_DATA", "${it.toString()}")
            mainAdapter.submitList(it)
        }

    }

    private fun setupAdapter() {
        mainAdapter = AdapterShopName()
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
                viewModel.deleteShopNameItem(item)
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(binding.listRV)
    }

    private fun setupClick() {
        mainAdapter.onShopNameClickListener= {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment, NeedListRequestFragment.newInstance(it.id))
                .addToBackStack(null)
                .commit()
        }
    }
}