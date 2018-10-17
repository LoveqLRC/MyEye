package com.example.liaoruochen.myeye.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.liaoruochen.myeye.databinding.FragmentHomeBinding
import com.example.liaoruochen.myeye.ui.MainNavigationFragment

class HomeFragment : Fragment(), MainNavigationFragment {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val homeBinding = FragmentHomeBinding.inflate(inflater, container, false).apply {
            setLifecycleOwner(this@HomeFragment)
        }
        return homeBinding.root
    }
}