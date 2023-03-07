package com.firstproject.fad.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Spannable
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getColor
import androidx.fragment.app.Fragment
import com.firstproject.fad.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (main_title!!.text as Spannable).apply {
            setSpan(ForegroundColorSpan(getColor(requireContext(), R.color.pastel_violet)),12,13, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            setSpan(ForegroundColorSpan(getColor(requireContext(), R.color.pastel_blue)),11,12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            setSpan(ForegroundColorSpan(getColor(requireContext(), R.color.pastel_green)),10,11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            setSpan(ForegroundColorSpan(getColor(requireContext(), R.color.pastel_yellow)),8,9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            setSpan(ForegroundColorSpan(getColor(requireContext(), R.color.pastel_orange)),7,8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            setSpan(ForegroundColorSpan(getColor(requireContext(), R.color.pastel_red)),6,7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            setSpan(ForegroundColorSpan(getColor(requireContext(), R.color.pastel_blue)),4,5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            setSpan(ForegroundColorSpan(getColor(requireContext(), R.color.pastel_green)),3,4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            setSpan(ForegroundColorSpan(getColor(requireContext(), R.color.pastel_yellow)),2,3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            setSpan(ForegroundColorSpan(getColor(requireContext(), R.color.pastel_orange)),1,2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            setSpan(ForegroundColorSpan(getColor(requireContext(), R.color.pastel_red)),0,1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        }

    }

}