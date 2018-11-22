package com.jmasagi.uptdjabar2

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.jmasagi.uptdjabar2.modules.account.AccountMainFragment
import com.jmasagi.uptdjabar2.modules.company.CompanyMainragment
import com.jmasagi.uptdjabar2.modules.home.HomeMainFragment
import com.jmasagi.uptdjabar2.modules.inspections.InspectionsMainFragment
import com.jmasagi.uptdjabar2.modules.inspectors.InspectorsMainFragment
import com.jmasagi.uptdjabar2.util.decoration.UnshiftingkBottomNavigation
import com.jmasagi.uptdjabar2.util.reDraw
import kotlinx.android.synthetic.main.activity_application.*

class MyApplication : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_application)
        initComponent()
    }

    private fun initComponent() {
        supportFragmentManager.reDraw(mainframe, InspectorsMainFragment())
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        UnshiftingkBottomNavigation().disableShiftMode(navigation)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.action_home -> {
                supportActionBar?.title = getString(R.string.app_name)
                supportFragmentManager.reDraw(mainframe, HomeMainFragment())
            }
            R.id.action_company -> {
                supportActionBar?.title = "Daftar Perusahaan"
                supportFragmentManager.reDraw(mainframe, CompanyMainragment())
            }
            R.id.action_feed -> {
                supportActionBar?.title = "Daftar Pemeriksaan"
                supportFragmentManager.reDraw(mainframe, InspectionsMainFragment())
            }
            R.id.action_users -> {
                supportActionBar?.title = "Daftar Pengawas"
                supportFragmentManager.reDraw(mainframe, InspectorsMainFragment())
            }
            R.id.action_setting -> {
                supportActionBar?.title = "Pengaturan"
                supportFragmentManager.reDraw(mainframe, AccountMainFragment())
            }
        }
        return@OnNavigationItemSelectedListener true
    }

}
