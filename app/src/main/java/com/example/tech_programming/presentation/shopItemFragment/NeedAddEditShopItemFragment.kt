package com.example.tech_programming.presentation.shopItemFragment

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tech_programming.R
import com.example.tech_programming.databinding.FragmentAddEditBinding
import com.example.tech_programming.domain.model.ShopItem
import com.example.tech_programming.domain.model.StorageItem
import com.example.tech_programming.presentation.AppApplication
import com.example.tech_programming.presentation.ViewModelFactory
import com.google.android.material.textfield.TextInputLayout
import javax.inject.Inject

class NeedAddEditShopItemFragment : Fragment() {
    private lateinit var viewModel: NeedAddEditShopItemViewModel
    private lateinit var onEditingFinishedListener: OnEditingFinishedListener


    private var _binding: FragmentAddEditBinding? = null
    private val binding
        get() = _binding!!

    private var screenMode: String = MODE_UNKNOWN
    private var shopId: Int = 0

    private var NeedShopItemId: Int = StorageItem.Unknown_ID

    private lateinit var tilName: TextInputLayout
    private lateinit var tilCount: TextInputLayout
    private lateinit var etName: EditText
    private lateinit var etCount: EditText

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (requireActivity().application as AppApplication).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)

        if (context is OnEditingFinishedListener) {
            onEditingFinishedListener = context
        } else {
            throw RuntimeException("Activity must implement OnEditingFinishedListener")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parserMetod()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddEditBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel =
            ViewModelProvider(this, viewModelFactory)[NeedAddEditShopItemViewModel::class.java]
        initViews()

        etName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.resetInputName()
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        etCount.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.resetInputCount()
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        when (screenMode) {
            MODE_EDIT_SHOP_ITEM -> launchEdit(shopId)
            MODE_ADD_SHOP_ITEM -> launchAdd(shopId)
        }
        viewModel.errorInputCount.observe(viewLifecycleOwner) {
            val message = if (it) {
                getString(R.string.error_input_name)
            } else {
                null
            }
            tilCount.error = message
        }

        viewModel.errorInputName.observe(viewLifecycleOwner) {
            val message = if (it) {
                getString(R.string.error_input_count)
            } else {
                null
            }
            tilName.error = message
        }
        observeViewModel()


    }

    private fun launchEdit(shopId: Int) {
        viewModel.getShopItem(NeedShopItemId, shopId)
        viewModel.shopItem.observe(viewLifecycleOwner) {
            etName.setText(it.name)
            etCount.setText(it.count.toString())
        }
        binding.btnSave.setOnClickListener {
            viewModel.editShopItem(etName.text?.toString(), etCount.text?.toString())
        }
    }

    private fun observeViewModel() {
        viewModel.shouldCloseScreen.observe(viewLifecycleOwner) {
            onEditingFinishedListener.onEditingFinished()
        }
    }

    private fun launchAdd(shopId: Int) {
        binding.btnSave.setOnClickListener {
            Log.d("asdasdasd", "clicked")
            viewModel.addShopItem(etName.text?.toString(), etCount.text?.toString(), shopId)
        }
    }

    private fun parserMetod() {

        val args = requireArguments()

        val mode = args.getString(MODE_SHOP_ITEM)
        if (mode != MODE_EDIT_SHOP_ITEM && mode != MODE_ADD_SHOP_ITEM) {
            throw RuntimeException("UNKNOWN screen $mode")
        }
        screenMode = mode
        shopId = args.getInt(EXTRA_SHOP_ITEM_ID)

        if (screenMode == MODE_EDIT_SHOP_ITEM) {
            if (!args.containsKey(EXTRA_SHOP_LIST_ID)) {
                throw RuntimeException("Param Shop item id is absent")
            }
            NeedShopItemId = args.getInt(EXTRA_SHOP_LIST_ID, ShopItem.Unknown_ID)
        }
    }


    private fun initViews() {
        tilName = binding.tilName
        tilCount = binding.tilCount
        etCount = binding.etCount
        etName = binding.etName
    }

    interface OnEditingFinishedListener {
        fun onEditingFinished()
    }


    companion object {
        private const val EXTRA_SHOP_ITEM_ID = "extra_shop_item_id"
        private const val EXTRA_SHOP_LIST_ID = "extra_shop_list_id"



        private const val MODE_UNKNOWN = ""


        private const val MODE_SHOP_ITEM = "ModeRequestItem"
        private const val MODE_EDIT_SHOP_ITEM = "edit_mode_shop_item"
        private const val MODE_ADD_SHOP_ITEM = "add_mode_shop_item"


        fun newInstanceAdd(shopId: Int): NeedAddEditShopItemFragment {
            return NeedAddEditShopItemFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(MODE_SHOP_ITEM, MODE_ADD_SHOP_ITEM)
                    putSerializable(EXTRA_SHOP_ITEM_ID, shopId)
                }
            }
        }

        fun newInstanceEdit(id: Int, shopId: Int): NeedAddEditShopItemFragment {
            return NeedAddEditShopItemFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(MODE_SHOP_ITEM, MODE_EDIT_SHOP_ITEM)
                    putSerializable(EXTRA_SHOP_LIST_ID, id)
                    putSerializable(EXTRA_SHOP_ITEM_ID, shopId)
                }
            }
        }
    }

}