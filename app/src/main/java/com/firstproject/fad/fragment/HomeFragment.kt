package com.firstproject.fad.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Paint
import android.os.Bundle
import android.text.Spannable
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.CheckBox
import android.widget.EditText
import androidx.core.content.ContextCompat.getColor
import androidx.fragment.app.Fragment
import com.firstproject.fad.R
import io.github.muddz.styleabletoast.StyleableToast
import kotlinx.android.synthetic.main.fragment_home.main_title
import kotlinx.android.synthetic.main.fragment_home_test.*


class HomeFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_test, container, false)
    }

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE)

//        (main_title!!.text as Spannable).apply {
//            setSpan(ForegroundColorSpan(getColor(requireContext(), R.color.pastel_violet)), 12, 13, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
//            setSpan(ForegroundColorSpan(getColor(requireContext(), R.color.pastel_blue)), 11, 12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
//            setSpan(ForegroundColorSpan(getColor(requireContext(), R.color.pastel_green)), 10, 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
//            setSpan(ForegroundColorSpan(getColor(requireContext(), R.color.pastel_yellow)), 8, 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
//            setSpan(ForegroundColorSpan(getColor(requireContext(), R.color.pastel_orange)), 7, 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
//            setSpan(ForegroundColorSpan(getColor(requireContext(), R.color.pastel_red)), 6, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
//            setSpan(ForegroundColorSpan(getColor(requireContext(), R.color.pastel_blue)), 4, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
//            setSpan(ForegroundColorSpan(getColor(requireContext(), R.color.pastel_green)), 3, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
//            setSpan(ForegroundColorSpan(getColor(requireContext(), R.color.pastel_yellow)), 2, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
//            setSpan(ForegroundColorSpan(getColor(requireContext(), R.color.pastel_orange)), 1, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
//            setSpan(ForegroundColorSpan(getColor(requireContext(), R.color.pastel_red)), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
//        }

        // EditText의 입력 완료 이벤트 처리
         fun setupEditTextListener(et: EditText, key: String) {
            et.setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    // SharedPreferences에 작성한 텍스트 저장
                    val editor = sharedPreferences.edit()
                    editor.putString(key, et.text.toString())
                    editor.apply()
                    // 완료 버튼 누를 시 깜빡임 숨김
                    et.isCursorVisible = false
                    // 완료 버튼 누를 시 키보드 숨김
                    val inputMethodManager = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
                    // true 반환하여 이벤트 처리 완료를 알림
                    true
                } else {
                    false
                }
            }
        }

        // 체크박스의 입력 이벤트 처리
        fun setupCheckBoxtListener(cb: CheckBox, key: String) {
            val isChecked = sharedPreferences.getBoolean(key, false) // SharedPreferences에서 key에 해당하는 값을 가져오는데, 만약 해당하는 값이 없다면 기본값으로 false를 반환
            cb.isChecked = isChecked
            cb.setOnCheckedChangeListener { _, isChecked ->
                // 체크 여부와 취소선 상태를 SharedPreferences에 저장
                val editor = sharedPreferences.edit()
                editor.putBoolean(key, isChecked)
//            editor.putInt("goal_paint_flags", et_text_goal.paintFlags)
                editor.apply()
                if(cb.isChecked) {
                    StyleableToast.makeText(requireContext(), "clear", R.style.clearToast).show()
                }
            }
        }


        // 리셋 버튼을 눌러 처음 상태로 되돌리는 메서드
        fun resetViewValues(editText: EditText, checkBox: CheckBox) {
            editText.setText("")
            checkBox.isChecked = false
        }

        button_reset.setOnClickListener {
            resetViewValues(et_text_goal, checkbox)
            resetViewValues(et_text_goal2, checkbox2)
            resetViewValues(et_text_goal3, checkbox3)
            resetViewValues(et_text_goal4, checkbox4)
            resetViewValues(et_text_goal5, checkbox5)
        }

        setupEditTextListener(et_text_goal, "goal_text")
        setupEditTextListener(et_text_goal2, "goal_text2")
        setupEditTextListener(et_text_goal3, "goal_text3")
        setupEditTextListener(et_text_goal4, "goal_text4")
        setupEditTextListener(et_text_goal5, "goal_text5")

        setupCheckBoxtListener(checkbox, "goal_checked")
        setupCheckBoxtListener(checkbox2, "goal_checked2")
        setupCheckBoxtListener(checkbox3, "goal_checked3")
        setupCheckBoxtListener(checkbox4, "goal_checked4")
        setupCheckBoxtListener(checkbox5, "goal_checked5")

        // 기존에 저장된 텍스트와 체크 여부 불러오기
        val goalText = sharedPreferences.getString("goal_text", "")
        val goalText2 = sharedPreferences.getString("goal_text2", "")
        val goalText3 = sharedPreferences.getString("goal_text3", "")
        val goalText4 = sharedPreferences.getString("goal_text4", "")
        val goalText5 = sharedPreferences.getString("goal_text5", "")

        val goalChecked = sharedPreferences.getBoolean("goal_checked", false)
        val goalChecked2 = sharedPreferences.getBoolean("goal_checked2", false)
        val goalChecked3 = sharedPreferences.getBoolean("goal_checked3", false)
        val goalChecked4 = sharedPreferences.getBoolean("goal_checked4", false)
        val goalChecked5 = sharedPreferences.getBoolean("goal_checked5", false)
//        val goalPaintFlags = sharedPreferences.getInt("goal_paint_flags", 0)

        et_text_goal.setText(goalText)
        et_text_goal2.setText(goalText2)
        et_text_goal3.setText(goalText3)
        et_text_goal4.setText(goalText4)
        et_text_goal5.setText(goalText5)

        checkbox.isChecked = goalChecked
        checkbox2.isChecked = goalChecked2
        checkbox3.isChecked = goalChecked3
        checkbox4.isChecked = goalChecked4
        checkbox5.isChecked = goalChecked5

//        et_text_goal.paintFlags = goalPaintFlags
//        if (goalChecked) {
//            et_text_goal.paintFlags = et_text_goal.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
//        }


            // EditText의 스타일을 업데이트합니다.
//            if (isChecked) {
//                et_text_goal.paintFlags = et_text_goal.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
//            } else {
//                et_text_goal.paintFlags = et_text_goal.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
//            }
        }

    override fun onPause() { // onPause 함수는 액티비티가 일시 중지되는 시점에서 호출
        super.onPause()

        // onPause 함수에서는 SharedPreferences를 사용하여 EditText와 CheckBox의 값을 저장
        val sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("goal_text", et_text_goal.text.toString())
        editor.putBoolean("checkbox_goal", checkbox.isChecked)
        editor.putString("goal_text2", et_text_goal2.text.toString())
        editor.putBoolean("checkbox_goal2", checkbox2.isChecked)
        editor.putString("goal_text3", et_text_goal3.text.toString())
        editor.putBoolean("checkbox_goal3", checkbox3.isChecked)
        editor.putString("goal_text4", et_text_goal4.text.toString())
        editor.putBoolean("checkbox_goal4", checkbox4.isChecked)
        editor.putString("goal_text5", et_text_goal5.text.toString())
        editor.putBoolean("checkbox_goal5", checkbox5.isChecked)
        editor.apply()
    }

    override fun onResume() { // onResume 함수는 액티비티가 다시 시작될 때 호출
        super.onResume()

        //  onResume 함수에서는 저장된 값을 불러와서 초기화
        val sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE)
        et_text_goal.setText(sharedPreferences.getString("goal_text", ""))
        checkbox.isChecked = sharedPreferences.getBoolean("checkbox_goal", false)
        et_text_goal2.setText(sharedPreferences.getString("goal_text2", ""))
        checkbox2.isChecked = sharedPreferences.getBoolean("checkbox_goal2", false)
        et_text_goal3.setText(sharedPreferences.getString("goal_text3", ""))
        checkbox3.isChecked = sharedPreferences.getBoolean("checkbox_goal3", false)
        et_text_goal4.setText(sharedPreferences.getString("goal_text4", ""))
        checkbox4.isChecked = sharedPreferences.getBoolean("checkbox_goal4", false)
        et_text_goal5.setText(sharedPreferences.getString("goal_text5", ""))
        checkbox5.isChecked = sharedPreferences.getBoolean("checkbox_goal5", false)
    }

}

