package therajanmaurya.rxbus.kotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private var adapter: RecyclerViewAdapter = RecyclerViewAdapter()
    private var persons: ArrayList<String> = ArrayList()
    private lateinit var personDisposable: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            startActivity(Intent(this, AddPersonActivity::class.java))
        }

        persons.add("Rajan Maurya")
        persons.add("Devesh")
        persons.add("Pawan")
        persons.add("Sagar")

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.setHasFixedSize(true)
        adapter.showPersons(persons)
        recyclerView.adapter = adapter

        personDisposable = RxBus.listen(RxEvent.EventAddPerson::class.java).subscribe {
            adapter.addPerson(person = it.personName)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (!personDisposable.isDisposed) personDisposable.dispose()
    }
}
