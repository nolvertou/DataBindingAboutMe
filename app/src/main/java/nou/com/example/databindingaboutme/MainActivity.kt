package nou.com.example.databindingaboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import nou.com.example.databindingaboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)

        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }


    private fun addNickname(view: View){
        val nicknameEditText = binding.nicknameEdit
        val nicknameTextView = binding.nicknameText

        // Use binding.apply to make the code easier to read
        binding.apply {
            nicknameTextView.text = nicknameEditText.text   // Gets the input from editText
            invalidateAll()                                 // Refresh UI with the new data
            nicknameEditText.visibility = View.GONE         // Hides the editText element
            view.visibility = View.GONE                     // Hides the view element
            nicknameTextView.visibility = View.VISIBLE      // Shows the nicknameTextView
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