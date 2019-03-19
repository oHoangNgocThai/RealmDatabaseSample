package android.thaihn.realmdatabasesample.ui

import android.support.v7.widget.RecyclerView
import android.thaihn.realmdatabasesample.databinding.ItemStudentBinding
import android.thaihn.realmdatabasesample.entity.Student
import android.view.LayoutInflater
import android.view.ViewGroup

class StudentAdapter(
    private val items: ArrayList<Student>,
    private val listener: StudentListener
) : RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    interface StudentListener {
        fun onItemClick(item: Student)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bindData(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(ItemStudentBinding.inflate(LayoutInflater.from(parent.context)), listener)
    }

    class ViewHolder(
        private val binding: ItemStudentBinding,
        private val listener: StudentListener
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(item: Student) {
            binding.student = item

            binding.root.setOnClickListener {
                listener.onItemClick(item)
            }

            binding.executePendingBindings()
        }
    }

     fun updateData(newList: List<Student>) {
        items.clear()
        items.addAll(newList)
        notifyDataSetChanged()
    }
}