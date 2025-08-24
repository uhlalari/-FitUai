package com.example.fituai.presentation.activity

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.bold
import com.example.fituai.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CarouselBottomSheet : BottomSheetDialogFragment() {

    companion object {
        private const val ARG_IMAGE_RES_ID = "imageResId"
        private const val ARG_DESCRIPTION = "description"

        fun newInstance(imageResId: Int, description: String): CarouselBottomSheet {
            val fragment = CarouselBottomSheet()
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
        val imageView = view.findViewById<ImageView>(R.id.imageViewBannerDetail)
        val textView = view.findViewById<TextView>(R.id.textViewBannerDetail)

        val imageResId = arguments?.getInt(ARG_IMAGE_RES_ID) ?: 0
        val rawDescription = arguments?.getString(ARG_DESCRIPTION) ?: ""

        imageView.setImageResource(imageResId)
        textView.text = formatText(rawDescription)
    }

    private fun formatText(input: String): CharSequence {
        val spannable = SpannableStringBuilder()
        val lines = input.split("\n")

        for (line in lines) {
            when {
                line.startsWith("🍽️") || line.startsWith("📋") || line.startsWith("👩‍🍳") || line.startsWith("🔥") || line.startsWith("⏱️") || line.startsWith("👥") || line.startsWith("📌") -> {
                    spannable.bold { append(line + "\n") }
                }
                line.startsWith("*") && line.endsWith("*") -> {
                    val clean = line.removePrefix("*").removeSuffix("*")
                    val start = spannable.length
                    spannable.append(clean + "\n")
                    spannable.setSpan(StyleSpan(Typeface.BOLD), start, spannable.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                }
                else -> {
                    spannable.append(line + "\n")
                }
            }
        }

        return spannable
    }
}
