package com.marcin.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver chargerConnectedReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "Charger connected!",
                    Toast.LENGTH_SHORT).show();
        }
    };

    BroadcastReceiver chargerDisconnectedReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "Charger disconnected!",
                    Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerReceiver(chargerConnectedReceiver, new IntentFilter(Intent.ACTION_POWER_CONNECTED));
        registerReceiver(chargerDisconnectedReceiver, new IntentFilter(Intent.ACTION_POWER_DISCONNECTED));
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(chargerConnectedReceiver);
        unregisterReceiver(chargerDisconnectedReceiver);
        super.onDestroy();
    }
}
