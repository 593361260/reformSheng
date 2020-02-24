package com.kevin.calcbtc

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.kevin.calcbtc.presenter.CalcBtcChangePresenter
import com.kevin.calcbtc.presenter.view.CalcView
import kotlinx.android.synthetic.main.activity_main.*
import org.kevin.module.baseAct.BaseMvpAct

/**
 * 在某个点买入, 必须比买入的点,加一个百分点,才算盈利,持平可以清仓
 *
 *列出盈利一个点和2个点,
 */
class MainActivity : BaseMvpAct<CalcBtcChangePresenter>(R.layout.activity_main), CalcView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = CalcBtcChangePresenter()
        presenter.controlView = this
        etOriginal.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
        etEnterPrice.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
        etSell.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        tvMinus.setOnClickListener {

        }
        tvPlus.setOnClickListener {

        }

    }
}
