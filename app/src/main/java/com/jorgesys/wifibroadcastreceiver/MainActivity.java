package com.jorgesys.wifibroadcastreceiver;

import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*
    * Exampe using https://developer.android.com/reference/android/net/NetworkInfo.html#isConnected()
    * */

    private static final String TAG = "MainActivity";
    private WifiReceiver wifiReceiver;

    private static MainActivity myself;

    public static MainActivity getInstance() {
        if (myself == null) {
            myself = new MainActivity();
        }
        return myself;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        wifiReceiver = new WifiReceiver();
        registerReceiver(wifiReceiver, intentFilter);

        Log.i(TAG, "* Registering Receiver.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(wifiReceiver);
        Log.i(TAG, "* Unregistering Receiver.");
    }


    public void showSnack(final String msg){
        //No action!
    }


}
