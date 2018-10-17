package com.example.liaoruochen.myeye.ui

interface MainNavigationFragment {
    fun onBackPressed():Boolean{
        return false
    }

    fun onUserInteraction(){}
}