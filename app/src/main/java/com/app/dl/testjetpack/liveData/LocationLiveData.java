package com.app.dl.testjetpack.liveData;

import android.Manifest;
import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;


/**
 * 扩展LiveData
 */
public class LocationLiveData extends LiveData<Location> {
    private static LocationLiveData sInstance;
    private LocationManager locationManager;


    public static LocationLiveData get(Context context) {
        if (sInstance == null) {
            sInstance = new LocationLiveData(context.getApplicationContext());
        }
        return sInstance;
    }

    private SimpleLocationListener listener = new SimpleLocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            setValue(location);
        }
    };

    private LocationLiveData(Context context) {
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    }

    @SuppressLint("MissingPermission")
    @Override
    protected void onActive() { //当LiveData对象具有活动观察者时调用该方法
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
    }

    @Override
    protected void onInactive() { //当LiveData对象没有任何活动观察者时调用该方法
        locationManager.removeUpdates(listener);
    }


}
