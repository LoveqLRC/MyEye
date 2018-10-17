package com.example.liaoruochen.myeye.ui.notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.liaoruochen.myeye.databinding.FragmentNotificationBinding
import com.example.liaoruochen.myeye.ui.MainNavigationFragment

class NotificationFragment : Fragment(), MainNavigationFragment {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var binding = FragmentNotificationBinding.inflate(inflater, container, false).apply {
            setLifecycleOwner(this@NotificationFragment)
        }
        return binding.root
    }
}