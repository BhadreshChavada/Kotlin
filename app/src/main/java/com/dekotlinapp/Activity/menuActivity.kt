package com.dekotlinapp.Activity

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ExpandableListView
import android.widget.TextView
import android.widget.Toast
import com.dekotlinapp.Adapter.navigationAdapter
import com.dekotlinapp.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_list.*
import kotlinx.android.synthetic.main.toolbar.*
import java.util.*

class menuActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, ExpandableListView.OnGroupClickListener, ExpandableListView.OnChildClickListener {


    var mNavigationDrawerItemTitles: Array<out String>? = null
    private var HeaderItem: ArrayList<String>? = null
    val NaviItem = LinkedHashMap<String, ArrayList<String>>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
//
        val tv_toolbar = findViewById(R.id.tv_home) as TextView
        tv_toolbar.text = "Hello"



        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.setDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)

        setNavigationItem()


        left_drawer.setOnGroupClickListener(this)
        left_drawer.setOnChildClickListener(this)

    }

//    fun ViewGroup.myLayout() {
//        tv_home.text = "Hello"
//    }

    override fun onBackPressed() {
        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId
        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    fun setNavigationItem() {

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

        Toast.makeText(this, "" + NaviItem.size, Toast.LENGTH_SHORT).show()
        Toast.makeText(this, "" + HeaderItem?.size, Toast.LENGTH_SHORT).show()

        val adapter = navigationAdapter(this, NaviItem, supportFragmentManager)
        left_drawer.setAdapter(adapter)


    }

    override fun onGroupClick(parent: ExpandableListView?, v: View?, groupPosition: Int, id: Long): Boolean {
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

    override fun onChildClick(parent: ExpandableListView?, v: View?, groupPosition: Int, childPosition: Int, id: Long): Boolean {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        if (drawer_layout.isDrawerVisible(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            drawer_layout.openDrawer(GravityCompat.START)
        }

        val str_child = NaviItem[HeaderItem?.get(groupPosition)]?.get(childPosition)
        if (str_child == "BookCar") {


//            supportFragmentManager.beginTransaction().replace(R.id.content_frame, BookCarFragment()).commit()
            tv_home.text = "Book Car"

        } else if (str_child == "List of Booked Car") {

//            supportFragmentManager.beginTransaction().replace(R.id.content_frame, BookedCarListFragment()).commit()
            tv_home.text = "Booked Car"

        } else if (str_child == "Pre Booking Car") {

//            supportFragmentManager.beginTransaction().replace(R.id.content_frame, BookCarInvoiceFragment()).commit()
            tv_home.text = "PreBooking Car"

        } else if (str_child == "List of Pre Booking Car") {

//            supportFragmentManager.beginTransaction().replace(R.id.content_frame, BookedCarListFragment()).commit()
            tv_home.text = "Booked Car"

        } else if (str_child == "Driver") {
//            supportFragmentManager.beginTransaction().replace(R.id.content_frame, DriverCancelRequestFragment()).commit()
            tv_home.text = "Driver Cancel Request"

        } else if (str_child == "Customer") {
//            supportFragmentManager.beginTransaction().replace(R.id.content_frame, CustomerCancelRequestFragment()).commit()
            tv_home.text = "Customer Cancel Request"

        } else if (str_child == "Payment Management") {

        }
        return false
    }
}
