package therajanmaurya.rxbus.kotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_view.view.*

/**
 * @author Rajan Maurya
 * On 23/07/18.
 */
class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private var persons: ArrayList<String> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_view, parent, false))
    }

    fun showPersons(persons: ArrayList<String>) {
        this.persons = persons
        notifyDataSetChanged()
    }

    fun addPerson(person: String) {
        persons.add(person)
        notifyItemChanged(persons.size - 1)
    }

    override fun getItemCount(): Int {
        return persons.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val personName = persons[position]
        holder.tvPersonName.text = personName
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvPersonName = itemView.tvPersonName!!
    }
}
