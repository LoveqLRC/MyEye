package com.example.liaoruochen.myeye.ui


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.liaoruochen.myeye.R
import com.example.liaoruochen.myeye.ui.follow.FollowFragment
import com.example.liaoruochen.myeye.ui.home.HomeFragment
import com.example.liaoruochen.myeye.ui.notification.NotificationFragment
import com.example.liaoruochen.myeye.util.consume
import com.example.liaoruochen.myeye.util.inTransaction
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import java.lang.IllegalStateException
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    companion object {
        private const val FRAGMENT_ID = R.id.fragment_container
    }

    private lateinit var currentFragment: MainNavigationFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> consume { replaceFragment(HomeFragment()) }
                R.id.navigation_follow -> consume { replaceFragment(FollowFragment()) }
                R.id.navigation_notification -> consume { replaceFragment(NotificationFragment()) }
                else -> false
            }
        }
        //添加listener防止reselected当作selected
        navigation.setOnNavigationItemReselectedListener { }

        if (savedInstanceState == null) {
            navigation.selectedItemId = R.id.navigation_follow
        } else {
            currentFragment = supportFragmentManager.findFragmentById(FRAGMENT_ID) as? MainNavigationFragment
                    ?: throw IllegalStateException("Activity recreated, but no fragment found!")
        }
    }


    private fun <F> replaceFragment(fragment: F) where F : Fragment, F : MainNavigationFragment {
        supportFragmentManager.inTransaction {
            currentFragment = fragment
            replace(FRAGMENT_ID, fragment)
        }

    }

    override fun onBackPressed() {
        if (!currentFragment.onBackPressed()) {
            super.onBackPressed()
        }
    }

    override fun onUserInteraction() {
        super.onUserInteraction()
        currentFragment.onUserInteraction()
    }


}
