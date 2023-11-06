package com.example.tech_programming.presentation.shopItemFragment

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
import com.example.tech_programming.presentation.adapter.AdapterShopItem
import com.example.tech_programming.presentation.adapter.AdapterStorageItem
import javax.inject.Inject

class NeedListShopItemFragment : Fragment(), NeedAddEditShopItemFragment.OnEditingFinishedListener{

    private lateinit var _binding: FragmentListItemsBinding
    private val binding
        get() = _binding!!
    private lateinit var viewModel: NeedListShopItemViewModel
    private lateinit var mainAdapter: AdapterShopItem

    private var shopId:Int = 0

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy{
        (requireActivity().application as AppApplication).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)

        super.onAttach(context)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseMetod()
    }

    private fun parseMetod() {
        val args = requireArguments()

        shopId = args.getInt(NeedListShopItemFragment.MODE_SHOP_ITEM_LIST)

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

        viewModel = ViewModelProvider(this, viewModelFactory)[NeedListShopItemViewModel::class.java]


        val buttonAddItem = binding.btnAdd
        buttonAddItem.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment, NeedAddEditShopItemFragment.newInstanceAdd(shopId))
                .addToBackStack(null)
                .commit()
        }

        setupAdapter()
        setupClick(shopId)
        setupItemTouchHelper(shopId)


        viewModel.shopItemList(shopId).observe(requireActivity()) {
            Log.d("TEST_LOADING_LIVE_DATA", "${it.toString()}")
            mainAdapter.submitList(it)
        }

    }

    private fun setupAdapter() {
        mainAdapter = AdapterShopItem()
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

    private fun setupItemTouchHelper(shopId: Int) {
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
                viewModel.deleteShopItemList(item, shopId)
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(binding.listRV)
    }



    private fun setupClick(shopId: Int) {
        mainAdapter.onShopItemClickListener= {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment, NeedAddEditShopItemFragment.newInstanceEdit(it.id, shopId))
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onEditingFinished() {
        requireActivity().finish()
    }

    companion object {


        private const val MODE_SHOP_ITEM_LIST = "ModeShopItemList"


        fun newInstance(shopId:Int): NeedListShopItemFragment {
            return NeedListShopItemFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(MODE_SHOP_ITEM_LIST, shopId)
                }
            }
        }
    }

}