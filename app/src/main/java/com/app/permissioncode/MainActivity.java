package com.app.permissioncode;
import android.app.Fragment;
import android.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.permissionlib.PermissionFragment;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.INTERNET;
import static android.Manifest.permission.PROCESS_OUTGOING_CALLS;
import static android.Manifest.permission.READ_CONTACTS;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.RECEIVE_BOOT_COMPLETED;
import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity {

    private static String[] Permissionstring = {WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE, RECORD_AUDIO};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("MainActivity", "onCreate: ");

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);

        button1.setOnClickListener(view -> {

            new PermissionFragment().CheckForPermission(Permissionstring
                    , "App Need You to Grant All the Permission."
                    , new PermissionFragment.OnPermissionresult() {
                        @Override
                        public void onSuccess() {
                            Log.e("MainActivity", "inside of onSuccess button1");
                        }

                        @Override
                        public void onFail() {
                            Log.e("MainActivity", "inside of Fail button1");
                        }
                    }).show(getFragmentManager(), "dialogframent");

//            Utils.permissionFragment.show();

        });

        button2.setOnClickListener(view -> {

            Utils.permissionFragment.CheckForPermission(new String[]{CAMERA, PROCESS_OUTGOING_CALLS, RECEIVE_BOOT_COMPLETED, INTERNET, READ_CONTACTS}
                    , "WPee need Call rmission for Callmanagment"
                    ,"Grant All the Permission Inside Your App setting."
                    , new PermissionFragment.OnPermissionresult() {
                        @Override
                        public void onSuccess() {
                            Log.e("MainActivityXXX", "inside of onSuccess button2");
                        }

                        @Override
                        public void onFail() {
                            Log.e("MainActivityXXX", "inside of Fail button2");
                        }
                    }).show(getFragmentManager(), "dialogframent");

        });

//        Utils.permissionFragment.show(getSupportFragmentManager(),"dialogframent");


//        androidPermissionClass = new AndroidPermissionClass();
//        androidPermissionClass.CheckForPermission(this,new OnPermissionresult() {
//            @Override
//            public void onSuccess() {
//                Log.d("MainActivityXXX","inside of onSuccess");
//            }
//
//            @Override
//            public void onFail() {
//                Log.d("MainActivityXXX","inside of Fail");
//            }
//        });


        Fragment someFragment = new TempPermissionFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentview, someFragment ); // give your fragment container id in first parameter
        transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
        transaction.commit();

//        getSupportFragmentManager().beginTransaction()
//                .add(R.id.fragmentview, new TempPermissionFragment())
//                .commit();

        Log.d("MainActivityXXX", "after permission call");

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
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
////                            if(onPermissionresult!=null){
////                                onPermissionresult.onFail();
////                            }
////                            showMessageOKCancel("You need to allow access all the permissions",
////                                    new DialogInterface.OnClickListener() {
////                                        @Override
////                                        public void onClick(DialogInterface dialog, int which) {
////                                            RequestPermission();
////                                        }
////                                    });
//                            return;
//                        }
//                        break;
//                    }
//                }
//
//                if (permissiongranted) {
////                    performafterpermission();
//                    Log.d("MainActivityXXX","inside of onsuccesspermisssion");
////                    if(onPermissionresult!=null){
////                        onPermissionresult.onSuccess();
////                    }
//
//                }
//                break;
//        }
//
//    }


//    //---------------------------------permission code--------------------------------
//
//    private void performafterpermission() {
//
//        if (CheckPermission()) {
//
//        } else {
//            RequestPermission();
//        }
//    }
//
//    private Boolean performafterpermission(String[] permission) {
//
//        Permissionstring = permission;
//
//        if (CheckPermission()) {
//                return true;
//        } else {
//            RequestPermission();
//        }
//        return permissiongranted;
//    }
//
//    public boolean CheckPermission() {
//
//        int result;
//        for (String str : Permissionstring) {
//            result = ContextCompat.checkSelfPermission(getApplicationContext(), str);
//            if (result != 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public void RequestPermission() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            requestPermissions(Permissionstring, PERMISSION_REQUEST_CODE);
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//
//        switch (requestCode) {
//            case PERMISSION_REQUEST_CODE:
//                permissiongranted = true;
//                for (int check : grantResults) {
//                    if (check != 0) {
//                        permissiongranted = false;
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//
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
//                    performafterpermission();
//                }
//                break;
//        }
//
//    }
//
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
//
//    private void Createappfolder() {
//
//    }
//
//    //---------------------------------

}
