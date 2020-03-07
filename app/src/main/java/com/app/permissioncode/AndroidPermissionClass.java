package com.app.permissioncode;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.permissionlib.PermissionFragment;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class AndroidPermissionClass{

    private static String[] Permissionstring = {WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE};
    private final int PERMISSION_REQUEST_CODE = 1;
    private boolean permissiongranted = false;

    private PermissionFragment.OnPermissionresult onPermissionresult;
    private Context context;

    //---------------------------------permission code--------------------------------

    private void performafterpermission() {

        if (CheckPermission()) {
            if(onPermissionresult!=null){
                onPermissionresult.onSuccess();
            }
        } else {
            RequestPermission();
        }
    }

    private Boolean performafterpermission(String[] permission) {

        Permissionstring = permission;

        if (CheckPermission()) {
            return true;
        } else {
            RequestPermission();
        }
        return permissiongranted;
    }

    public boolean CheckPermission() {

        int result;
        for (String str : Permissionstring) {
            result = ContextCompat.checkSelfPermission(context, str);
            if (result != 0) {
                return false;
            }
        }
        return true;
    }

    public void RequestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Log.d("MainActivityXXX","inside of requestpermission");
//            ActivityCompat.requestPermissions((Activity)context,Permissionstring, PERMISSION_REQUEST_CODE);
            ActivityCompat.requestPermissions((Activity)context,Permissionstring, PERMISSION_REQUEST_CODE);

        }
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        Log.d("MainActivityXXX","inside of onResultpermission");
//        switch (requestCode) {
//            case PERMISSION_REQUEST_CODE:
//                permissiongranted = true;
//                for (int check : grantResults) {
//                    if (check != 0) {
//                        permissiongranted = false;
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//
//                            Log.d("MainActivityXXX","inside of failpermission");
//                            if(onPermissionresult!=null){
//                                onPermissionresult.onFail();
//                            }
//                            showMessageOKCancel("You need to allow access all the permissions",
//                                    new DialogInterface.OnClickListener() {
//                                        @Override
//                                        public void onClick(DialogInterface dialog, int which) {
//                                            RequestPermission();
//                                        }
//                                    });
//                            return;
//                        }
//                        break;
//                    }
//                }
//
//                if (permissiongranted) {
////                    performafterpermission();
//                    Log.d("MainActivityXXX","inside of onsuccesspermisssion");
//                    if(onPermissionresult!=null){
//                        onPermissionresult.onSuccess();
//                    }
//
//                }
//                break;
//        }
//
//    }

//    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
//        new AlertDialog.Builder(getApplication())
//                .setMessage(message)
//                .setPositiveButton("OK", okListener)
//                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        finishAffinity();
//                        finish();
//                    }
//                })
//                .create()
//                .show();
//    }

    private void Createappfolder() {

    }

    //---------------------------------

    public void CheckForPermission(Context context,PermissionFragment.OnPermissionresult onPermissionresult){
        this.context = context;
        this.onPermissionresult = onPermissionresult;
        performafterpermission();
    }

}
