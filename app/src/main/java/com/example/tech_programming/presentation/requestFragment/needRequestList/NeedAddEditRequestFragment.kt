package com.example.tech_programming.presentation.requestFragment.needRequestList

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.tech_programming.R
import com.example.tech_programming.databinding.FragmentNeedAddEditRequestBinding
import com.example.tech_programming.domain.model.RequestItem
import com.example.tech_programming.domain.model.StorageItem
import com.example.tech_programming.presentation.AppApplication
import com.example.tech_programming.presentation.ViewModelFactory
import com.google.android.material.textfield.TextInputLayout
import javax.inject.Inject

class NeedAddEditRequestFragment : Fragment() {


    private lateinit var viewModel: NeedAddEditRequestViewModel
    private lateinit var onEditingFinishedListener: OnEditingFinishedListener


    private var _binding: FragmentNeedAddEditRequestBinding? = null
    private val binding
        get() = _binding!!

    private var screenMode: String = MODE_UNKNOWN
    private var shopId:Int = 0

    private var NeedRequestItemId: Int = StorageItem.Unknown_ID

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
        _binding = FragmentNeedAddEditRequestBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel = ViewModelProvider(this, viewModelFactory)[NeedAddEditRequestViewModel::class.java]
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
            MODE_EDIT_REQUEST_ITEM -> launchEdit(shopId)
            MODE_ADD_REQUEST_ITEM -> launchAdd(shopId)
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
        viewModel.getRequestItem(NeedRequestItemId, shopId)
        viewModel.requestItem.observe(viewLifecycleOwner) {
            etName.setText(it.name)
            etCount.setText(it.count.toString())
        }
        binding.btnSave.setOnClickListener {
            viewModel.editRequestItem(etName.text?.toString(), etCount.text?.toString())
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
            viewModel.addRequestItem(etName.text?.toString(), etCount.text?.toString(), shopId)
        }
    }

    private fun parserMetod() {

        val args = requireArguments()

        val mode = args.getString(MODE_REQUEST_ITEM)
        if (mode != MODE_EDIT_REQUEST_ITEM && mode != MODE_ADD_REQUEST_ITEM) {
            throw RuntimeException("UNKNOWN screen $mode")
        }
        screenMode = mode
        shopId = args.getInt(EXTRA_REQUEST_SHOP_ID)

        if (screenMode == MODE_EDIT_REQUEST_ITEM) {
            if (!args.containsKey(EXTRA_REQUEST_ITEM_ID)) {
                throw RuntimeException("Param Shop item id is absent")
            }
            NeedRequestItemId = args.getInt(EXTRA_REQUEST_ITEM_ID, RequestItem.Unknown_ID)
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
        private const val EXTRA_REQUEST_ITEM_ID = "extra_request_item_id"
        private const val EXTRA_REQUEST_SHOP_ID = "extra_request_shop_id"


        private const val MODE_UNKNOWN = ""


        private const val MODE_REQUEST_ITEM = "ModeRequestItem"
        private const val MODE_EDIT_REQUEST_ITEM = "edit_mode_RequestItem"
        private const val MODE_ADD_REQUEST_ITEM = "add_mode_RequestItem"


        fun newInstanceAdd(shopId:Int): NeedAddEditRequestFragment {
            return NeedAddEditRequestFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(MODE_REQUEST_ITEM, MODE_ADD_REQUEST_ITEM)
                    putSerializable(EXTRA_REQUEST_SHOP_ID, shopId)
                }
            }
        }

        fun newInstanceEdit(requestId: Int, shopId:Int): NeedAddEditRequestFragment {
            return NeedAddEditRequestFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(MODE_REQUEST_ITEM, MODE_EDIT_REQUEST_ITEM)
                    putSerializable(EXTRA_REQUEST_ITEM_ID, requestId)
                    putSerializable(EXTRA_REQUEST_SHOP_ID, shopId)
                }
            }
        }
    }

}