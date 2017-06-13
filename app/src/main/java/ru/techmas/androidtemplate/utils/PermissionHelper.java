package ru.techmas.androidtemplate.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

/**
 * Created by reg on 07.02.2017.
 */

public class PermissionHelper {

    //@formatter:off
    private PermissionHelper(){};
    //@formatter:on

    public static final int LOCATION = 101;

    private static boolean isLocationPermissionEnabled(Context context) {
        return ActivityCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED;
    }


    public static void requestLocationPermission(Activity activity) {
        if (weDontHaveLocationPermission(activity)) locationRequest(activity);
    }

    private static void locationRequest(Activity activity) {
        ActivityCompat.requestPermissions(activity, new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION}, LOCATION);
    }


    public static boolean isLocationGranted(@NonNull int[] grantResults) {
        return grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED;
    }


}
