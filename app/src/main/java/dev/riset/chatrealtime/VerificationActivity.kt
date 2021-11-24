package dev.riset.chatrealtime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import dev.riset.chatrealtime.databinding.ActivityVerificationBinding

class VerificationActivity : AppCompatActivity() {

    var binding: ActivityVerificationBinding? = null
    var auth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerificationBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        auth = FirebaseAuth.getInstance()
        if (auth!!.currentUser != null) {
            val intent = Intent(this, SetupProfileActivity::class.java)
            startActivity(intent)
            finish()
        }

        supportActionBar?.hide()
        binding!!.edtNumber.requestFocus()
        binding!!.btnContinue.setOnClickListener {
            val intent = Intent(this, OtpActivity::class.java)
            intent.putExtra("phoneNumber", binding!!.edtNumber.text.toString())
            startActivity(intent)
        }
    }
}