package com.molette.app.joursferies.core.common.extensions

import android.content.Context
import com.molette.app.joursferies.R
import java.util.*

fun Date.getWeekDay(context: Context): String {
    val calendar = Calendar.getInstance().apply { time = this@getWeekDay }
    return when(calendar.get(Calendar.DAY_OF_WEEK)) {
        1 -> context.getString(R.string.sunday)
        2 -> context.getString(R.string.monday)
        3 -> context.getString(R.string.tuesday)
        4 -> context.getString(R.string.wednesday)
        5 -> context.getString(R.string.thursday)
        6 -> context.getString(R.string.friday)
        else -> context.getString(R.string.saturday)
    }
}

fun Date.getDay(): String {
    val calendar = Calendar.getInstance().apply { time = this@getDay }
    return calendar.get(Calendar.DATE).toString()
}

fun Date.getMonth(context: Context): String {
    val calendar = Calendar.getInstance().apply { time = this@getMonth }
    return when(calendar.get(Calendar.MONTH)) {
        0 -> context.getString(R.string.january)
        1 -> context.getString(R.string.february)
        2 -> context.getString(R.string.march)
        3 -> context.getString(R.string.april)
        4 -> context.getString(R.string.may)
        5 -> context.getString(R.string.june)
        6 -> context.getString(R.string.july)
        7 -> context.getString(R.string.august)
        8 -> context.getString(R.string.september)
        9 -> context.getString(R.string.october)
        10 -> context.getString(R.string.november)
        else -> context.getString(R.string.december)
    }
}