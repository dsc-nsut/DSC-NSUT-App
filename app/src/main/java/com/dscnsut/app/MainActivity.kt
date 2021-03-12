package com.dscnsut.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val DrawerLayout= findViewById<DrawerLayout>(R.id.ll_main)
        toggle= ActionBarDrawerToggle(this, DrawerLayout, R.string.open,R.string.close)
        DrawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navView= findViewById<NavigationView>(R.id.navView)
        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miItem1-> Toast.makeText(applicationContext,"Item 1", Toast.LENGTH_SHORT).show()
                R.id.miItem2-> Toast.makeText(applicationContext,"Item 2", Toast.LENGTH_SHORT).show()
                R.id.miItem3-> Toast.makeText(applicationContext,"Item 3", Toast.LENGTH_SHORT).show()
            }
            true
        }

        val homefragment= start_activity()
        val blogContent= blog_content()
        val eventContent= event_detail_fragment()
        val eventMain= events_fragment()
        val memberContent= member_detail_fragment()
        val memberMain= member_fragment()

        makeCurrentFragment(homefragment)

        val bottom_navigation= findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.action_blogs -> makeCurrentFragment(homefragment)
                R.id.action_events -> makeCurrentFragment(eventMain)
                R.id.action_members-> makeCurrentFragment(memberMain)
            }
            true
        }

    }

    private fun makeCurrentFragment(fragment : Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}