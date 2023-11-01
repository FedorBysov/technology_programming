package com.example.tech_programming.presentation.shopFragment

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.tech_programming.R
import com.example.tech_programming.databinding.FragmentShopNameAddBinding
import com.example.tech_programming.databinding.FragmentShopNameBinding
import com.example.tech_programming.databinding.FragmentStorageEditAddBinding
import com.example.tech_programming.domain.model.StorageItem
import com.example.tech_programming.presentation.AppApplication
import com.example.tech_programming.presentation.ViewModelFactory
import com.example.tech_programming.presentation.storageItemFragment.StorageEditAddFragment
import com.example.tech_programming.presentation.storageItemFragment.StorageEditAddViewModel
import com.google.android.material.textfield.TextInputLayout
import javax.inject.Inject


class ShopNameAddFragment : Fragment() {


    private lateinit var viewModel: ShopNameAddViewModel
    private lateinit var onEditingFinishedListener: OnEditingFinishedListener


    private var _binding: FragmentShopNameAddBinding? = null
    private val binding
        get() = _binding!!

    private var screenMode: String = MODE_UNKNOWN

    private lateinit var tilName: TextInputLayout
    private lateinit var etName: EditText

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
        _binding = FragmentShopNameAddBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel = ViewModelProvider(this, viewModelFactory)[ShopNameAddViewModel::class.java]
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



        when (screenMode) {
            MODE_ADD_SHOP_NAME_ITEM -> launchAdd()
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


    private fun observeViewModel() {
        viewModel.shouldCloseScreen.observe(viewLifecycleOwner) {
            onEditingFinishedListener.onEditingFinished()
        }
    }

    private fun launchAdd() {
        binding.btnSave.setOnClickListener {
            Log.d("asdasdasd", "clicked")
            viewModel.addShopName(etName.text?.toString())
        }
    }

    private fun parserMetod() {

        val args = requireArguments()

        val mode = args.getString(MODE_SHOP_NAME_ITEM)
        if (mode != MODE_ADD_SHOP_NAME_ITEM) {
            throw RuntimeException("UNKNOWN screen $mode")
        }
        screenMode = mode

    }


    private fun initViews() {
        tilName = binding.tilName
        etName = binding.etName
    }

    interface OnEditingFinishedListener {
        fun onEditingFinished()
    }


    companion object {

        private const val MODE_UNKNOWN = ""


        private const val MODE_SHOP_NAME_ITEM = "ModeShopNameItem"
        private const val MODE_ADD_SHOP_NAME_ITEM = "add_mode_StorageItem"


        fun newInstanceAdd(): ShopNameAddFragment {
            return ShopNameAddFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(MODE_SHOP_NAME_ITEM, MODE_ADD_SHOP_NAME_ITEM)
                }
            }
        }
    }
}