package com.example.tech_programming.presentation.requestFragment.needRequestList

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.tech_programming.R
import com.example.tech_programming.databinding.FragmentNeedListRequestBinding
import com.example.tech_programming.presentation.AppApplication
import com.example.tech_programming.presentation.ViewModelFactory
import com.example.tech_programming.presentation.adapter.AdapterRequestItem
import com.example.tech_programming.presentation.adapter.AdapterStorageItem
import javax.inject.Inject

class NeedListRequestFragment : Fragment(), NeedAddEditRequestFragment.OnEditingFinishedListener{

    private lateinit var _binding: FragmentNeedListRequestBinding
    private val binding
        get() = _binding!!
    private lateinit var viewModel: NeedListRequestViewModel
    private lateinit var mainAdapter: AdapterRequestItem

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

        shopId = args.getInt(NeedListRequestFragment.MODE_REQUEST_LIST)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNeedListRequestBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, viewModelFactory)[NeedListRequestViewModel::class.java]


        val buttonAddItem = binding.btnAdd
        buttonAddItem.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment, NeedAddEditRequestFragment.newInstanceAdd(shopId))
                .addToBackStack(null)
                .commit()
        }

        setupAdapter()
        setupClick(shopId)
        setupItemTouchHelper(shopId)


        viewModel.requestList(shopId).observe(requireActivity()) {
            Log.d("TEST_LOADING_LIVE_DATA", "${it.toString()}")
            mainAdapter.submitList(it)
        }

    }

    private fun setupAdapter() {
        mainAdapter = AdapterRequestItem()
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
                viewModel.deleteStorageList(item, shopId)
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(binding.listRV)
    }



    private fun setupClick(shopId: Int) {
        mainAdapter.onRequestItemClickListener= {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment, NeedAddEditRequestFragment.newInstanceEdit(it.id, shopId))
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onEditingFinished() {
        requireActivity().finish()
    }

    companion object {


        private const val MODE_REQUEST_LIST = "ModeRequestList"


        fun newInstance(shopId:Int): NeedListRequestFragment {
            return NeedListRequestFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(MODE_REQUEST_LIST, shopId)
                }
            }
        }
    }

}