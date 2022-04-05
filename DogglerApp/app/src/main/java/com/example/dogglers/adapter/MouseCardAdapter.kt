
package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.const.Layout
import com.example.dogglers.data.DataSource
import com.example.dogglers.model.Mouse

class MouseCardAdapter(
    private val context: Context?,
    private val layout: Int

): RecyclerView.Adapter<MouseCardAdapter.MouseCardViewHolder>() {

    val mouseList = DataSource.mouses

    class MouseCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        val mouseImageView : ImageView? = view?.findViewById(R.id.mouse_img)
        val mouseNameText : TextView? = view?.findViewById(R.id.mouse_name)
        val mouseTypeText : TextView? = view?.findViewById(R.id.mouse_type)
        val mouseConText : TextView? = view?.findViewById(R.id.mouse_con)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MouseCardViewHolder {

        val adapterLayout = when (layout) {
            Layout.GRID -> LayoutInflater.from(parent.context).inflate(R.layout.grid_list_item, parent, false)
            else -> LayoutInflater.from(parent.context).inflate(R.layout.vertical_horizontal_list_item, parent, false)
        }
        return MouseCardViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return mouseList.size
    }

    override fun onBindViewHolder(holder: MouseCardViewHolder, position: Int) {

        val mouseData = mouseList[position]
        holder.mouseImageView?.setImageResource(mouseData.imageResourceId)
        holder.mouseNameText?.text = mouseData.name
        val resources = context?.resources
        holder.mouseTypeText?.text = resources?.getString(R.string.mouse_type, mouseData.type)

        holder.mouseConText?.text = resources?.getString(R.string.mouse_con, mouseData.con)



    }
}
