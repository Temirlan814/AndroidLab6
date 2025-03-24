package com.example.lab6android

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomListAdapter(
    private val context: Context,
    private val listData: List<Country>
) : BaseAdapter() {

    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return listData.size
    }

    override fun getItem(position: Int): Any {
        return listData[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val holder: ViewHolder
        val view: View

        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.list_item_layout, parent, false)
            holder = ViewHolder(
                flagView = view.findViewById(R.id.flag),
                countryNameView = view.findViewById(R.id.countryName),
                populationView = view.findViewById(R.id.population)
            )
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val country = listData[position]

        holder.countryNameView.text = country.countryName
        holder.populationView.text = "Population: ${country.population}"

        val imageId = getMipmapResIdByName(country.flagName)
        holder.flagView.setImageResource(imageId)

        return view
    }


    private fun getMipmapResIdByName(resName: String): Int {
        val pkgName = context.packageName
        val resId = context.resources.getIdentifier(resName, "mipmap", pkgName)
        Log.i("CustomListAdapter", "Res Name: $resName; Res ID = $resId")
        return resId
    }

    private data class ViewHolder(
        val flagView: ImageView,
        val countryNameView: TextView,
        val populationView: TextView
    )
}
