package csu.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MainService.MyBinder binder = (MainService.MyBinder)service;
            MainService mainService = binder.getService();

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void serviceAction(View view) {
        if (view.getId() == R.id.startService) {
            startService(new Intent(this, MainService.class));
        } else {
            stopService(new Intent(this, MainService.class));
        }
    }

    public void intentServiceAction(View view) {
        if (view.getId() == R.id.startIntentService) {
            startService(new Intent(this, MainIntentService.class));
        } else {
            stopService(new Intent(this, MainIntentService.class));
        }
    }

    public void bindServiceAction(View view) {
        if (view.getId() == R.id.bindService) {
            bindService(new Intent(this, MainService.class), serviceConnection, Context.BIND_AUTO_CREATE);
        } else {
            unbindService(serviceConnection);
        }

    }
}
