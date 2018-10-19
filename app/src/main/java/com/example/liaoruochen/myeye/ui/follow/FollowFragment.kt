package com.example.liaoruochen.myeye.ui.follow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.liaoruochen.myeye.databinding.FragmentFollowBinding
import com.example.liaoruochen.myeye.ui.MainNavigationFragment

class FollowFragment : Fragment(), MainNavigationFragment {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val followBinding = FragmentFollowBinding.inflate(inflater, container, false).apply {
            setLifecycleOwner(this@FollowFragment)
        }
        return followBinding.root
    }

}