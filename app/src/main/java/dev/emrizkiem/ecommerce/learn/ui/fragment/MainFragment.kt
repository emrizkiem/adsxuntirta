package dev.emrizkiem.ecommerce.learn.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import dev.emrizkiem.ecommerce.R

class MainFragment : Fragment(), View.OnClickListener {

    private var edtLength: EditText? = null
    private var edtWidth: EditText? = null
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("Lifecycle", "Method onCreateView Fragment Started")
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_main, container, false)

        edtLength = view.findViewById(R.id.et_length)
        edtWidth = view.findViewById(R.id.et_width)
        btnCalculate = view.findViewById(R.id.btn_calculate)
        tvResult = view.findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)

        validation()

        return view
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_calculate) {
            val inputLength = edtLength?.text.toString().trim()
            val inputWidth = edtWidth?.text.toString().trim()

            val result = inputLength.toInt() * inputWidth.toInt()
            tvResult.text = result.toString()
        }
    }

    private fun validation() {
        btnCalculate.enable(false)
        edtWidth?.addTextChangedListener {
            btnCalculate.enable(
                (edtLength.toString().isNotEmpty()) and
                        (it.toString().isNotEmpty())
            )
        }
    }

    private fun View.enable(enabled: Boolean) {
        isEnabled = enabled
        alpha = if (enabled) 1f else 0.8f
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Lifecycle", "Method onViewCreated Fragment Started")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle", "Method onStart Fragment Started")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle", "Method onResume Fragment Started")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle", "Method onPause Fragment Started")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle", "Method onStop Fragment Started")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("Lifecycle", "Method onDestroyView Fragment Started")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle", "Method onDestroy Fragment Started")
    }
}