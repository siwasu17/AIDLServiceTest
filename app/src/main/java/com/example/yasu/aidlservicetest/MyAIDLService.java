package com.example.yasu.aidlservicetest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

public class MyAIDLService extends Service {
    private IMyAidlInterface.Stub mBinder = new IMyAidlInterface.Stub() {
        private String message = "Hello!! ";

        @Override
        public void doSomething(int i) throws RemoteException {
            //Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
            Log.i("MyAIDLService", message + i);
        }

        @Override
        public void setString(String s) throws RemoteException {
            message = s;
        }
    };

    public MyAIDLService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("MyAIDLService", "AIDL Service Bind");
        return mBinder;
    }
}
