package com.example.profile.presentation.view.fragment

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.getSystemService
import androidx.fragment.app.Fragment
import com.example.profile.R
import com.example.profile.databinding.FrgNotificationBinding
import com.example.profile.presentation.view.Activity.ActLogin

class FrgNotification : Fragment() {
    private lateinit var binding: FrgNotificationBinding
    companion object {
        private const val CHANNEL_DESC = "Prueba"
        private const val CHANNEL_NAME = "Prueba 2"
        private const val CHANNEL_ID = "id"
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FrgNotificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createChannelId()
        binding.btnSimple.setOnClickListener {
            val builder = NotificationCompat.Builder(requireContext(), CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_user)
                .setContentTitle("NOTIFICACION PRUEBA")
                .setContentText(
                    "ddfbdgbfgnfbrgsrtbsrtbrdtbfgfffffffffffffffffffffffffff " +
                        "dfxfgfcggcghnhgncghdfvjbsduSIDVBNN"
                )
                .setPriority(NotificationCompat.PRIORITY_HIGH)
            val vibrate = longArrayOf(0, 100, 200, 300)
            builder.setVibrate(vibrate)
            with(NotificationManagerCompat.from(requireContext())) {
                notify(0, builder.build())
            }
        }
        binding.btnLarge.setOnClickListener {
            val builder = NotificationCompat.Builder(requireContext(), CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_user)
                .setContentTitle("NOTIFICACION PRUEBA")
                .setContentText(
                    "ddfbdgbfgnfbrgsrtbsrtbrdtbfgfffffffffffffffffffffffffff " +
                        "dfxfgfcggcghnhgncghdfvjbsduSIDVBNN"
                )
                .setStyle(
                    NotificationCompat.BigTextStyle()
                        .bigText(
                            "sdvsdvdfvdfvvdf"
                        )
                )
                .setPriority(NotificationCompat.PRIORITY_HIGH)
            val vibrate = longArrayOf(0, 100, 200, 300)
            builder.setVibrate(vibrate)
            with(NotificationManagerCompat.from(requireContext())) {
                notify(0, builder.build())
            }
        }
        binding.btnIntent.setOnClickListener {
            val intent = Intent(requireContext(), ActLogin::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            }
            val pendingIntent: PendingIntent =
                PendingIntent.getActivity(requireContext(), 0, intent, PendingIntent.FLAG_IMMUTABLE)

            val builder = NotificationCompat.Builder(requireContext(), CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_user)
                .setContentTitle("NOTIFICACION PRUEBA")
                .setContentText("vdzv fxg f")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
            with(NotificationManagerCompat.from(requireContext())) {
                notify(0, builder.build())
            }
        }
    }

    private fun notify(builder: NotificationCompat.Builder) {
        with(NotificationManagerCompat.from(requireContext())) {
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createChannelId() {
        /*if(Build.VERSION.SDK >= Build.VERSION_CODES.0) {
        }*/
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, importance).apply {
            description = CHANNEL_DESC
        }
        val notificationManager: NotificationManager =
            requireContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}
