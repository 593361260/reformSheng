package com.kevin.calcbtc.tools

import android.content.Context
import android.content.SharedPreferences

class SPUtils {
    companion object {
        private const val SP_NAME = "calcBtcChange"
        private fun getSp(context: Context): SharedPreferences =
            context.applicationContext.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)

        fun setString(context: Context, key: String, value: String) {
            getSp(context).edit().putString(key, value).apply()
        }

        fun setBoolean(context: Context, key: String, value: Boolean) {
            getSp(context).edit().putBoolean(key, value).apply()
        }

        fun setFloat(context: Context, key: String, value: Float) {
            getSp(context).edit().putFloat(key, value).apply()
        }

        fun getString(context: Context, key: String, defValue: String) =
            getSp(context).getString(key, defValue)

        fun getBoolean(context: Context, key: String, defValue: Boolean) =
            getSp(context).getBoolean(key, defValue)

        fun getFloat(context: Context, key: String, defValue: Float) =
            getSp(context).getFloat(key, defValue)

    }
}