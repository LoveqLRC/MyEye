package com.example.liaoruochen.myeye.util

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


inline fun consume(f: () -> Unit): Boolean {
    f()
    return true
}

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}