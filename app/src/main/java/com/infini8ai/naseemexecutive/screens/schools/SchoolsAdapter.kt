package com.infini8ai.naseemexecutive.screens.schools

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.infini8ai.naseemexecutive.R
import com.infini8ai.naseemexecutive.databinding.CustomRowSchoolsBinding
import com.infini8ai.naseemexecutive.model.School

class SchoolsAdapter  (val context: Context ) : RecyclerView.Adapter<SchoolsAdapter.ViewHolder>() {

    lateinit var schoolList: ArrayList<School>
    lateinit var onClickRowSchool: OnClickRowSchoolListener



    fun setOrganizationList(schoolList: ArrayList<School>) {
        this.schoolList = schoolList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: CustomRowSchoolsBinding = CustomRowSchoolsBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(position)

        holder.setIsRecyclable(false)
    }

    override fun getItemCount(): Int {

        return schoolList.size

    }

    inner class ViewHolder(view: CustomRowSchoolsBinding) : RecyclerView.ViewHolder(view.root) {
        var schoolName = view.schoolNameTv
        var schoolImage=view.schoolIm
        fun bind(position: Int) {
            val school: School = schoolList[position]
            schoolName.text = school.schoolName
            schoolImage.setImageResource(R.drawable.ic_school1_new)


            itemView.setOnClickListener {
                onClickRowSchool.onClickSchools(position,school)

            }






        }

    }


    fun setOnClickMenuListener(onClickRowSchoolListener: OnClickRowSchoolListener) {
        this.onClickRowSchool = onClickRowSchoolListener
    }

    interface OnClickRowSchoolListener {
        fun onClickSchools(position: Int, school: School?)

    }

}