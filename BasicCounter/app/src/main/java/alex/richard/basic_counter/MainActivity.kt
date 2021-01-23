package alex.richard.basic_counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import alex.richard.basic_counter.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {
    private var count: Int = 0;
    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.btnToast.setOnClickListener { showCount() }
        binding.btnUp.setOnClickListener {count(true)}
        binding.btnDown.setOnClickListener {count(false)}
    }

    private fun showCount(){
        Toast.makeText(this, "The current count is: $count", Toast.LENGTH_SHORT).show();
    }

    private fun count(up: Boolean) {
        if(up) {
            count++;
        } else {
            count--;
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", count);
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState);
        count = savedInstanceState.getInt("count");
    }
}