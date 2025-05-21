package com.example.fituai.presentation.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.fituai.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BannerDetailBottomSheet : BottomSheetDialogFragment() {

    companion object {
        private const val ARG_IMAGE_RES_ID = "imageResId"
        private const val ARG_DESCRIPTION = "description"

        fun newInstance(imageResId: Int, description: String): BannerDetailBottomSheet {
            val fragment = BannerDetailBottomSheet()
            val args = Bundle()
            args.putInt(ARG_IMAGE_RES_ID, imageResId)
            args.putString(ARG_DESCRIPTION, description)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottomsheet_banner_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageView = view.findViewById<ImageView>(R.id.imageViewBannerDetail)
        val textView = view.findViewById<TextView>(R.id.textViewBannerDetail)

        val imageResId = arguments?.getInt(ARG_IMAGE_RES_ID) ?: 0
        val description = arguments?.getString(ARG_DESCRIPTION) ?: ""

        imageView.setImageResource(imageResId)
        textView.text = description
    }
}
