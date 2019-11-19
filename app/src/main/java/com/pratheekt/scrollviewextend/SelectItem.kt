package com.pratheekt.scrollviewextend

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class SelectItem(private var mNameList: List<String>, var listener: ItemClickListener) :
    androidx.recyclerview.widget.RecyclerView.Adapter<SelectItem.ViewHolder>() {


    /**
     * an interface object declaration
     */
    companion object {
        var mClickListener: ItemClickListener? = null
    }

    /**
     * attach view to the recycler view
     */
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        mClickListener = listener
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    /**
     * return the number of item present in the list
     */
    override fun getItemCount(): Int {
        return mNameList.size
    }

    /**
     * bind data to the view
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.nameTextView.text = mNameList[position]
        /**
         * call the interface method on click of item in recycler view
         */

        holder.itemView.setOnClickListener {

            mClickListener!!.onBtnClick(mNameList[position])
        }
    }

    class ViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        var nameTextView: TextView = itemView.findViewById(R.id.add_member_checkbox)

    }

    /**
     * an Interface which needs to be implemented whenever the adapter is attached to the recyclerview
     */
    interface ItemClickListener {
        fun onBtnClick(name: String?)
    }
}