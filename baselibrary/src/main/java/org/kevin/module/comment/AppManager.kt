package org.kevin.module.comment

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*

class AppManager private constructor() {

    private val activityStack = Stack<Activity>()

    companion object {
        val instances = AppManager()
    }

    fun addStack(activity: Activity) {
        activityStack.add(activity)
    }

    fun finishActivity(activity: Activity) {
        activity.finish()
        activityStack.remove(activity)
    }

    fun topActivity(): Activity {
        return activityStack.lastElement()
    }

    fun finishAllActivity() {
        activityStack.forEach {
            it.finish()
        }
        activityStack.clear()
    }

    @SuppressLint("MissingPermission")
    fun exitProcess(context: Context) {
        finishAllActivity()
        val manager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        manager.killBackgroundProcesses(context.packageName)
    }

}