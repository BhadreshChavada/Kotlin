package com.dekotlinapp.Adapter

import android.content.Context
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.dekotlinapp.R

/**
 * Created by AMD21 on 1/6/17.
 */

open class navigationAdapter(val context: Context, val NavigationItem: LinkedHashMap<String, ArrayList<String>>, val fm: FragmentManager) : BaseExpandableListAdapter() {

    internal var HeaderItem: java.util.ArrayList<String> = ArrayList(NavigationItem.keys)
    var vi: LayoutInflater

    init {

        this.vi = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getGroup(groupPosition: Int): Any {
        return groupPosition
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {

        var retView: View
        if (convertView == null) {

            retView = vi.inflate(R.layout.layout_navigation_item_header, null)
        } else {
            retView = convertView
        }

        val tv_navigation_header = retView.findViewById(R.id.tv_navigation_header) as TextView
        tv_navigation_header.text = " - " + HeaderItem.get(groupPosition)
        return retView
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return NavigationItem.get(HeaderItem.get(groupPosition))!!.size
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return null!!
    }

    override fun getGroupId(groupPosition: Int): Long {

        return groupPosition.toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        var retView: View
        if (convertView == null) {

            retView = vi.inflate(R.layout.layout_navigation_item_child, null)
        } else {
            retView = convertView
        }

        val tv_navigation_child = retView.findViewById(R.id.tv_navigation_child) as TextView
        tv_navigation_child.text = " - " + NavigationItem.get(HeaderItem.get(groupPosition))!!.get(childPosition)


        return retView
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return HeaderItem.size
    }


    class viewHolder() {
        var tv_navigation_child: TextView? = null
        var tv_navigation_header: TextView? = null

    }


}