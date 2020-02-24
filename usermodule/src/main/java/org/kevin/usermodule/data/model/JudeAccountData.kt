package org.kevin.usermodule.data.model

class JudeAccountData {
    /**null
     * is_exist : 0
     * is_forbidden : 0
     */
    private var is_exist //是否注册
            = 0
    private var is_forbidden //是否被拉黑
            = 0

    fun getIs_exist(): Int {
        return is_exist
    }

    fun setIs_exist(is_exist: Int) {
        this.is_exist = is_exist
    }

    fun getIs_forbidden(): Int {
        return is_forbidden
    }

    fun setIs_forbidden(is_forbidden: Int) {
        this.is_forbidden = is_forbidden
    }
}