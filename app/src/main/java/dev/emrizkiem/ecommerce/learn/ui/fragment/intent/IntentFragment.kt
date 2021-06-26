package dev.emrizkiem.ecommerce.learn.ui.fragment.intent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import dev.emrizkiem.ecommerce.R

class IntentFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_intent, container, false)

        // Initialize button
        val btnMoveActivity: Button = view.findViewById(R.id.btn_move_activity)
        val btnMoveActivityWithData: Button = view.findViewById(R.id.btn_move_activity_with_data)
        val btnDialNumber: Button = view.findViewById(R.id.btn_dial_number)

        // Clicked button
        btnMoveActivity.setOnClickListener(this)
        btnMoveActivityWithData.setOnClickListener(this)
        btnDialNumber.setOnClickListener(this)

        return view
    }

    // Function when button clicked
    override fun onClick(v: View?) {
        when (v?.id) {
            
            
            
            
            R.id.btn_move_activity -> {
                val intent = Intent(context, DetailActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_move_activity_with_data -> {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra(DetailActivity.NAME, "M. Rizki Maulana")
                intent.putExtra(DetailActivity.AGE, 20)
                startActivity(intent)
            }
            R.id.btn_dial_number -> {
                val phoneNumber = "0123456789"
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(intent)
            }
        }
    }
}