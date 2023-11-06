package com.example.tech_programming.presentation.storageItemFragment

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
import com.example.tech_programming.domain.model.StorageItem
import com.example.tech_programming.presentation.AppApplication
import com.example.tech_programming.presentation.ViewModelFactory
import com.google.android.material.textfield.TextInputLayout
import javax.inject.Inject


class StorageEditAddFragment : Fragment() {


    private lateinit var viewModel: StorageEditAddViewModel
    private lateinit var onEditingFinishedListener: OnEditingFinishedListener


    private var _binding: FragmentAddEditBinding? = null
    private val binding
        get() = _binding!!

    private var screenMode: String = MODE_UNKNOWN
    private var shopItemId: Int = StorageItem.Unknown_ID

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


        viewModel = ViewModelProvider(this, viewModelFactory)[StorageEditAddViewModel::class.java]
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
            MODE_EDIT_STORAGE_ITEM -> launchEdit()
            MODE_ADD_STORAGE_ITEM -> launchAdd()
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

    private fun launchEdit() {
        viewModel.getStorageItem(shopItemId)
        viewModel.storageItem.observe(viewLifecycleOwner) {
            etName.setText(it.name)
            etCount.setText(it.count.toString())
        }
        binding.btnSave.setOnClickListener {
            viewModel.editStorageItem(etName.text?.toString(), etCount.text?.toString())
        }
    }

    private fun observeViewModel() {
        viewModel.shouldCloseScreen.observe(viewLifecycleOwner) {
            onEditingFinishedListener.onEditingFinished()
        }
    }

    private fun launchAdd() {
        binding.btnSave.setOnClickListener {
            Log.d("asdasdasd", "clicked")
            viewModel.addStorageItem(etName.text?.toString(), etCount.text?.toString())
        }
    }

    private fun parserMetod() {

        val args = requireArguments()

        val mode = args.getString(MODE_STORAGE_ITEM)
        if (mode != MODE_EDIT_STORAGE_ITEM && mode != MODE_ADD_STORAGE_ITEM) {
            throw RuntimeException("UNKNOWN screen $mode")
        }
        screenMode = mode

        if (screenMode == MODE_EDIT_STORAGE_ITEM) {
            if (!args.containsKey(EXTRA_STORAGE_ITEM_ID)) {
                throw RuntimeException("Param Shop item id is absent")
            }
            shopItemId = args.getInt(EXTRA_STORAGE_ITEM_ID, StorageItem.Unknown_ID)
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
        private const val EXTRA_STORAGE_ITEM_ID = "extra_storage_item_id"

        private const val MODE_UNKNOWN = ""


        private const val MODE_STORAGE_ITEM = "ModeStorageItem"
        private const val MODE_EDIT_STORAGE_ITEM = "edit_mode_StorageItem"
        private const val MODE_ADD_STORAGE_ITEM = "add_mode_StorageItem"


        fun newInstanceAdd(): StorageEditAddFragment {
            return StorageEditAddFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(MODE_STORAGE_ITEM, MODE_ADD_STORAGE_ITEM)
                }
            }
        }

        fun newInstanceEdit(storageId: Int): StorageEditAddFragment {
            return StorageEditAddFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(MODE_STORAGE_ITEM, MODE_EDIT_STORAGE_ITEM)
                    putSerializable(EXTRA_STORAGE_ITEM_ID, storageId)
                }
            }
        }
    }

}


