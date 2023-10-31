package com.example.tech_programming.presentation.storageItemFragment

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tech_programming.R
import com.example.tech_programming.domain.model.StorageItem

class StorageEditAddActivity : AppCompatActivity() ,  StorageEditAddFragment.OnEditingFinishedListener {



    private var storageItemId = StorageItem.Unknown_ID
    private var screenMode = MODE_UNKNOWN



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage_edit_add)


        parserIntent()


        if (savedInstanceState == null) {
            launchRightMode()
        }


    }

    private fun launchRightMode() {
        val fragment = when (screenMode) {
            MODE_EDIT -> StorageEditAddFragment.intentEditFragment(storageItemId)
            MODE_ADD -> StorageEditAddFragment.newIntentAddFragment()
            else -> throw RuntimeException("UNKNOWN screen $screenMode")
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.storage_item_container, fragment)
            .commit()
    }


    private fun parserIntent() {
        if (!intent.hasExtra(EXTRA_SCREEN_MODE)) {
            throw RuntimeException("Param Screen Mode is Absent")
        }
        val mode = intent.getStringExtra(EXTRA_SCREEN_MODE)
        if (mode != MODE_EDIT && mode != MODE_ADD) {
            throw RuntimeException("UNKNOWN screen $mode")
        }
        screenMode = mode
        if (screenMode == MODE_EDIT) {
            if (!intent.hasExtra(EXTRA_SHOP_ITEM_ID)) {
                throw RuntimeException("Param Shop item id is absent")
            }
            storageItemId = intent.getIntExtra(EXTRA_SHOP_ITEM_ID, -1)

        }

    }

    companion object {
        private const val EXTRA_SCREEN_MODE = "extra_mode"
        private const val EXTRA_SHOP_ITEM_ID = "extra_shop_item_id"
        private const val MODE_EDIT = "edit_mode"
        private const val MODE_ADD = "add_mode"

        private const val MODE_UNKNOWN = ""

        fun newIntentStorageItemActivity(context: Context): Intent {
            val intent = Intent(context, StorageEditAddActivity::class.java)
            intent.putExtra(EXTRA_SCREEN_MODE, MODE_ADD)
            return intent
        }

        fun editIntentStorageItemActivity(context: Context, storageItemId: Int): Intent {
            val intent = Intent(context, StorageEditAddActivity::class.java)
            intent.putExtra(EXTRA_SCREEN_MODE, MODE_EDIT)
            intent.putExtra(EXTRA_SHOP_ITEM_ID, storageItemId)
            return intent
        }
    }

    override fun finishEditing() {
        finish()
    }
}