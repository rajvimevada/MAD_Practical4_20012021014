package com.example.mad_practical4_20012021014_1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.ContactsContract
import android.provider.MediaStore
import android.text.method.LinkMovementMethod
import androidx.core.view.WindowCompat
import com.example.mad_practical4_20012021014_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.webUrlButton.setOnClickListener{
            val webUrl = binding.webUrlEditText.text.toString()
            Intent(Intent.ACTION_VIEW).setData(Uri.parse(webUrl)).apply { startActivity(this) }
        }

        binding.callNumberButton.setOnClickListener{
            val callNow = binding.callNumberEditText.text.toString()
            Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:$callNow")).apply { startActivity(this) }
        }

        binding.contactListButton.setOnClickListener{
            Intent(Intent.ACTION_VIEW).setType(ContactsContract.Contacts.CONTENT_TYPE).apply { startActivity(this) }
        }

        binding.callLogButton.setOnClickListener{
            Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).apply { startActivity(this) }
        }

        binding.galleryButton.setOnClickListener{
            Intent(Intent.ACTION_VIEW).setType("image/*").apply { startActivity(this) }
        }

        binding.cameraButton.setOnClickListener{
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply { startActivity(this) }
        }

        binding.alarmButton.setOnClickListener{
            Intent(AlarmClock.ACTION_SHOW_ALARMS).apply { startActivity(this) }
        }

        binding.expliIntentBtn.setOnClickListener{
//            Intent(this, ExplicitIntent1::class.java).also { startActivity(it) }
//            binding.expliIntentBtn.movementMethod= LinkMovementMethod.getInstance();
            val message = binding.webUrlEditText.text.toString()
            val intent = Intent(this, ExplicitIntent1::class.java)
            intent.putExtra("message_key", message)
            startActivity(intent)
        }
    }
}