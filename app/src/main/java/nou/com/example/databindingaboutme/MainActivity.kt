package nou.com.example.databindingaboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import nou.com.example.databindingaboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // TODO 3: Create a binding object in the MainActivity
    private lateinit var binding: ActivityMainBinding

    // TODO 10: Create instance myName
    private val myName: MyName = MyName("Nolverto Urias")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        // TODO 4: In onCreate(), use DataBindingUtil to set the layout for MainActivity
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)


        // TODO 11: Set binding to instance myName
        binding.myName = myName

        // TODO 5: Use the binding object to replace all calls to findViewId
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }


    private fun addNickname(view: View){
        // Use binding.apply to make the code easier to read
        binding.apply {
            // TODO 12: Set the nickname in the binding object and invalidateAll()
            myName?.nickname = nicknameEdit.text.toString() // Gets the input from editText using dataBinding
            invalidateAll()                                 // Refresh UI with the new data
            nicknameEdit.visibility = View.GONE             // Hides the editText element
            view.visibility = View.GONE                     // Hides the view element (doneButton)
            nicknameText.visibility = View.VISIBLE          // Shows the nicknameTextView
        }

        // Hide the keyboard after input is complete
        hideKeyboard(view)
    }

    /**
     * This function hides the keyboard after input is complete
     */
    private fun hideKeyboard(view: View){
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}