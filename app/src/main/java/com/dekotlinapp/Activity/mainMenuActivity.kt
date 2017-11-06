package com.dekotlinapp.Activity

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.content.res.ResourcesCompat
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ExpandableListView
import android.widget.Toast
import com.dekotlinapp.Adapter.navigationAdapter
import com.dekotlinapp.BaseClass.ActivityBaseClass
import com.dekotlinapp.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_list.*
import kotlinx.android.synthetic.main.toolbar.*
import java.util.*

/**
 * Created by AMD21 on 1/6/17.
 */

class mainMenuActivity : ActivityBaseClass(), NavigationView.OnNavigationItemSelectedListener, ExpandableListView.OnGroupClickListener {


    var mNavigationDrawerItemTitles: Array<out String>? = null
    private var HeaderItem: ArrayList<String>? = null
    private var lastExpandedPosition = -1
    val NaviItem = LinkedHashMap<String, ArrayList<String>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()

        init();
    }


    fun init() {

        tv_home.text = "Home"
        mNavigationDrawerItemTitles = resources.getStringArray(R.array.navigation_drawer_items_array)
        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.setDrawerListener(toggle)
        toggle.syncState()
        toggle.isDrawerIndicatorEnabled = false

        val drawable = ResourcesCompat.getDrawable(resources, R.drawable.navi_icon, theme)
        toggle.setHomeAsUpIndicator(drawable)
        toggle.toolbarNavigationClickListener = View.OnClickListener {
            if (drawer_layout.isDrawerVisible(GravityCompat.START)) {
                drawer_layout.closeDrawer(GravityCompat.START)
            } else {
                drawer_layout.openDrawer(GravityCompat.START)
            }
        }

        // TODO: 12/5/17 set up Expandablelist in navigaton drawer

//        val inflater = layoutInflater
//        val header = inflater.inflate(R.layout.layout_navigation_header, left_drawer, false) as ViewGroup
//        left_drawer.addHeaderView(header, null, false)


        // TODO: 12/5/17 Add the value in hashmap and set in expadable list

        var NaviChildItem = ArrayList<String>()

        NaviChildItem.add("Book Car")
        NaviChildItem.add("List of Booked Car")
        NaviItem.put("Booking History", NaviChildItem)
        NaviChildItem = ArrayList<String>()

        NaviChildItem.add("Pre Booking Car")
        NaviChildItem.add("List of Pre Booking Car")
        NaviItem.put("Pre Booking", NaviChildItem)
        NaviChildItem = ArrayList<String>()

        NaviItem.put("Car Driver Mapping", NaviChildItem)
        NaviChildItem = ArrayList<String>()

        NaviItem.put("Expense", NaviChildItem)
        NaviChildItem = ArrayList<String>()

        NaviChildItem.add("Payment Management")
        NaviItem.put("Account", NaviChildItem)
        NaviChildItem = ArrayList<String>()

        NaviChildItem.add("Driver")
        NaviChildItem.add("Customer")
        NaviItem.put("Cancel Request", NaviChildItem)
        NaviChildItem = ArrayList<String>()

        NaviItem.put("Logout", NaviChildItem)

        HeaderItem = ArrayList(NaviItem.keys)

        val adapter = navigationAdapter(this, NaviItem, supportFragmentManager)
        left_drawer.setAdapter(adapter)

        toolbar.setVisibility(View.VISIBLE)
//        getSupportFragmentManager().beginTransaction().add(R.id.content_frame, new CustomerCancelRequestFragment()).commit();

        left_drawer.setOnItemClickListener(DrawerItemClickListener())

        val navigationView = findViewById(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)



        left_drawer.setOnGroupExpandListener(ExpandableListView.OnGroupExpandListener { groupPosition ->
            if (lastExpandedPosition != -1 && groupPosition != lastExpandedPosition) {
                left_drawer.collapseGroup(lastExpandedPosition)
            }
            lastExpandedPosition = groupPosition
        })

        left_drawer.setOnChildClickListener(ExpandableListView.OnChildClickListener { parent, v, groupPosition, childPosition, id ->
            if (drawer_layout.isDrawerVisible(GravityCompat.START)) {
                drawer_layout.closeDrawer(GravityCompat.START)
            } else {
                drawer_layout.openDrawer(GravityCompat.START)
            }

            val str_child = NaviItem[HeaderItem?.get(groupPosition)]?.get(childPosition)

            Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show()
            if (str_child == "BookCar") {


//                supportFragmentManager.beginTransaction().replace(R.id.content_frame, BookCarFragment()).commit()
                tv_home.text = "Book Car"

            } else if (str_child == "List of Booked Car") {

//                supportFragmentManager.beginTransaction().replace(R.id.content_frame, BookedCarListFragment()).commit()
                tv_home.text = "Booked Car"

            } else if (str_child == "Pre Booking Car") {

//                supportFragmentManager.beginTransaction().replace(R.id.content_frame, BookCarInvoiceFragment()).commit()
                tv_home.text = "PreBooking Car"

            } else if (str_child == "List of Pre Booking Car") {

//                supportFragmentManager.beginTransaction().replace(R.id.content_frame, BookedCarListFragment()).commit()
                tv_home.text = "Booked Car"

            } else if (str_child == "Driver") {
//                supportFragmentManager.beginTransaction().replace(R.id.content_frame, DriverCancelRequestFragment()).commit()
                tv_home.text = "Driver Cancel Request"

            } else if (str_child == "Customer") {
//                supportFragmentManager.beginTransaction().replace(R.id.content_frame, CustomerCancelRequestFragment()).commit()
                tv_home.text = "Customer Cancel Request"

            } else if (str_child == "Payment Management") {

            }

            false
        })

    }

    inner class DrawerItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            selectItem(position)
        }

    }


    private fun selectItem(i: Int) {
        val fragment: Fragment? = null

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return false
    }


    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onGroupClick(parent: ExpandableListView?, v: View?, groupPosition: Int, id: Long): Boolean {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        if (NaviItem[HeaderItem?.get(groupPosition)]?.size == 0) {
            if (drawer_layout.isDrawerVisible(GravityCompat.START)) {
                drawer_layout.closeDrawer(GravityCompat.START)
            } else {
                drawer_layout.openDrawer(GravityCompat.START)
            }

            Toast.makeText(this, HeaderItem?.get(groupPosition), Toast.LENGTH_SHORT).show()
            val str_header = HeaderItem?.get(groupPosition)
            if (str_header == "Car Driver Mapping") {
//                supportFragmentManager.beginTransaction().replace(R.id.content_frame, CarDriverMappingFragment()).commit()
                tv_home.text = "Car Driver Mapping"
            } else if (str_header == "Expense") {
                tv_home.text = "Expense"
            } else if (str_header == "Logout") {
                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show()
            }
        }
        return false
    }




}