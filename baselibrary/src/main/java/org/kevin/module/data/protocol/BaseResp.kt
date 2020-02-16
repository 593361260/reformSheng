package org.kevin.module.data.protocol

class BaseResp<out T>(val status: Int, val message: String, val data: T) {
}