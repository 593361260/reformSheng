package org.kevin.module.data.protocol

class BaseResp<out T>(val code: Int, val msg: String, val data: T) {
}