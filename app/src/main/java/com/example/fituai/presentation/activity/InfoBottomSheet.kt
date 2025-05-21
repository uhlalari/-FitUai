package com.example.fituai.presentation.activity

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import com.example.fituai.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class InfoBottomSheet : BottomSheetDialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        val view = LayoutInflater.from(context).inflate(R.layout.bottomsheet_info, null)
        dialog.setContentView(view)
        return dialog
    }
}
