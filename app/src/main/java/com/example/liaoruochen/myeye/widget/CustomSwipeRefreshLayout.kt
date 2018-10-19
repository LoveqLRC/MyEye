package com.example.liaoruochen.myeye.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

//todo test CustomSwipeRefreshLayout
class CustomSwipeRefreshLayout : SwipeRefreshLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)


    private var startGestureX: Float = 0f


    private var startGestureY: Float = 0f

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                startGestureX = ev.x
                startGestureY = ev.y
            }
            else -> {
                if (Math.abs(ev.x -startGestureX)> Math.abs(ev.y-startGestureY)){
                    return false
                }

            }
        }
        return super.onInterceptTouchEvent(ev)
    }
}