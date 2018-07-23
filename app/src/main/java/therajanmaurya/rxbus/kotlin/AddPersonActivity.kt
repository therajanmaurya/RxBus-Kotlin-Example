package therajanmaurya.rxbus.kotlin

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_person.*

/**
 * @author Rajan Maurya
 * On 23/07/18.
 */
class AddPersonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_person)

        btnAdd.setOnClickListener {
            if (etPersonName.text.toString().isEmpty()) {
                Snackbar.make(findViewById(android.R.id.content), "Enter Person Name", Snackbar.LENGTH_SHORT).show()
            } else {
                RxBus.publish(RxEvent.EventAddPerson(etPersonName.text.toString()))
                finish()
            }
        }
    }
}
