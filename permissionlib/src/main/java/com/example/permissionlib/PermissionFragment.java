package com.example.permissionlib;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

/**
 * A simple {@link Fragment} subclass.
 */
public class PermissionFragment extends DialogFragment {

    /** variable for Request permission
     */
    private String[] Permissionstring;
    private final int PERMISSION_REQUEST_CODE = 1;
    private boolean permissiongranted = false;

    /** variable for request permission activity in setting
     *
     */
    private final int REQUEST_PERMISSION_SETTING = 2;


    /** variable for result interface
     *
     */
    private OnPermissionresult onPermissionresult;
    private Context context;

    /** Extra variables
     *
     */
    private String PermissionMessage1, PermissionMessage2, PermissionMessage3;
    private boolean variable1 = false;
    private boolean variable2 = false;


    public PermissionFragment() {
        // Required empty public constructor
    }

    /**
     * Display message Regarding Permission using Bellow Methods
     * @param message
     */

    private void ShowMessagedialog_Befour_Request(String message) {

        /**---------------- Default Alert Dialog box view
         *
         **/

     /*
        new AlertDialog.Builder(getActivity())
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        RequestPermission();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (onPermissionresult != null) {
                            onPermissionresult.onFail();
                        }
                        dismiss();
                    }
                })
                .create()
                .show();

        */

        /**---------------- Custom Dialog Box View
         *
         **/

        final PermissionMessageDilaogbox permissionMessageDilaogbox = new PermissionMessageDilaogbox(context,message);
        permissionMessageDilaogbox.setCancelable(false);
        permissionMessageDilaogbox.getWindow().getDecorView().setBackgroundResource(android.R.color.transparent);
        permissionMessageDilaogbox.getWindow().setDimAmount(0.2f);

        permissionMessageDilaogbox.SetOnDialogclickListener(new PermissionMessageDilaogbox.onDialogclickListener() {
            @Override
            public void onPermissionclick() {
                RequestPermission();
                permissionMessageDilaogbox.cancel();
            }

            @Override
            public void onCancleclick() {
                if (onPermissionresult != null) {
                    onPermissionresult.onFail();
                }
                permissionMessageDilaogbox.cancel();
                dismiss();
            }


        });
        permissionMessageDilaogbox.show();


    }

    private void ShowMessagedialog_After_Permission(String message) {

        /**---------------- Default Alert Dialog box view
         *
         **/

   /*
        new AlertDialog.Builder(context)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        RequestPermission();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (onPermissionresult != null) {
                            onPermissionresult.onFail();
                        }
                        dismiss();
                    }
                })
                .create()
                .show();

   */



        /**---------------- Custom Dialog Box View
         *
         **/

        final PermissionMessageDilaogbox permissionMessageDilaogbox = new PermissionMessageDilaogbox(context,message);
        permissionMessageDilaogbox.setCancelable(false);
        permissionMessageDilaogbox.getWindow().getDecorView().setBackgroundResource(android.R.color.transparent);
        permissionMessageDilaogbox.getWindow().setDimAmount(0.2f);

        permissionMessageDilaogbox.SetOnDialogclickListener(new PermissionMessageDilaogbox.onDialogclickListener() {
            @Override
            public void onPermissionclick() {
                RequestPermission();
                permissionMessageDilaogbox.cancel();
            }

            @Override
            public void onCancleclick() {
                if (onPermissionresult != null) {
                    onPermissionresult.onFail();
                }
                permissionMessageDilaogbox.cancel();
                dismiss();
            }
        });
        permissionMessageDilaogbox.show();


    }

    private void ShowMessagedialog_If_NeverAsk_checked(String message) {

        /**---------------- Default Alert Dialog box view
         *
         **/
        /*
        new AlertDialog.Builder(getActivity())
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        Uri uri = Uri.fromParts("package", context.getPackageName(), null);
                        intent.setData(uri);
                        startActivityForResult(intent, REQUEST_PERMISSION_SETTING);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (onPermissionresult != null) {
                            onPermissionresult.onFail();
                        }
                        dismiss();
                    }
                })
                .create()
                .show();

        */

        /**---------------- Custom Dialog Box View
         *
         **/

        final PermissionMessageDilaogbox permissionMessageDilaogbox = new PermissionMessageDilaogbox(context,message);
        permissionMessageDilaogbox.setCancelable(false);
        permissionMessageDilaogbox.getWindow().getDecorView().setBackgroundResource(android.R.color.transparent);
        permissionMessageDilaogbox.getWindow().setDimAmount(0.2f);

        permissionMessageDilaogbox.SetOnDialogclickListener(new PermissionMessageDilaogbox.onDialogclickListener() {
            @Override
            public void onPermissionclick() {
                permissionMessageDilaogbox.cancel();
                dismiss();
//                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
//                Uri uri = Uri.fromParts("package", context.getPackageName(), null);
//                intent.setData(uri);
//                startActivityForResult(intent, REQUEST_PERMISSION_SETTING);
            }

            @Override
            public void onCancleclick() {

                if (onPermissionresult != null) {
                    onPermissionresult.onFail();
                }
                permissionMessageDilaogbox.cancel();
                dismiss();
            }

        });
        permissionMessageDilaogbox.show();
        permissionMessageDilaogbox.grantpermissionclick.setText("Ok");
        permissionMessageDilaogbox.cancel.setVisibility(View.GONE);



    }


    /**
     *
     * Start Code for Request Permissions
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_permission, container, false);
        context = view.getContext();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

            performafterpermission();
    }

    private void performafterpermission() {

        if (CheckPermission()) {

            /** If permissions are granted return success.
             **/
            if (onPermissionresult != null) {
                onPermissionresult.onSuccess();
                dismiss();
            }

        } else {

            RequestPermission();  // Request the Permission


            /**
             * code to Display Dialog box befour request the permission.

            if (PermissionMessage3 != null) {
                ShowMessagedialog_Befour_Request(PermissionMessage3);
            } else {
                RequestPermission();
            }

             **/


        }
    }

    /** Code for check Permissions. return false if all the permissions are not granted and vice versa.
    **/
    private boolean CheckPermission() {
        int result;
        if(Permissionstring!=null) {
            for (String str : Permissionstring) {
                result = ContextCompat.checkSelfPermission(context, str);
                if (result != 0) {
                    return false;
                }
            }
        }else{
            dismiss();
        }
        return true;
    }

    /** Code to Request for Permission
    */
    private void RequestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(Permissionstring, PERMISSION_REQUEST_CODE);
//           ActivityCompat.requestPermissions((Activity)context,Permissionstring, PERMISSION_REQUEST_CODE);
        }
    }


    /**
     * Request Permission Result function
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.d("MainActivityXXX", "inside of onResultpermission");
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                permissiongranted = true;
                for (int check : grantResults) {
                    if (check != 0) {
                        permissiongranted = false;

                        /**
                         * show dialog if permissions are not granted

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (onPermissionresult != null) {
                                onPermissionresult.onFail();
                            }
                            ShowMessagedialog_After_Permission("Please grant all the permission.");
                            return;
                        }
                        break;
                         
                         *
                         */


                    }
                }
                if (permissiongranted) {
                    if (onPermissionresult != null) {
                        onPermissionresult.onSuccess();
                        dismiss();
                    }
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        variable2 = false;
                        variable1 = false;
                        for (String aPermissionstring : Permissionstring) {
                            if (shouldShowRequestPermissionRationale(aPermissionstring)) {
                                variable1 = true;
                            } else {
                                if (ContextCompat.checkSelfPermission(context, aPermissionstring) != 0) {
                                    variable2 = true;
                                }
                            }
                        }

                        if (variable1) {
                            ShowMessagedialog_After_Permission(PermissionMessage1);
                        } else if (!variable1 && variable2) {
                            ShowMessagedialog_If_NeverAsk_checked(PermissionMessage2);
                        }
                    }
                }
                break;
        }
    }


    /**
     * Result after Application setting Activity
     */

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("PermissionFragment", "inside of activity result");

        if(CheckPermission()){
            if (onPermissionresult != null) {
                onPermissionresult.onSuccess();
            }
        }else{
            if (onPermissionresult != null) {
                onPermissionresult.onFail();
            }
        }
    }


    /**
     *  Request For permission using Interface ..
     * @param permisssion
     * @param permissionmessage1
     * @param permissionmessage2
     * @param permissionmessage3
     * @param onPermissionresult
     */

    public PermissionFragment CheckForPermission(@NonNull String[] permisssion, @NonNull String permissionmessage1, @NonNull String permissionmessage2, @NonNull String permissionmessage3, @NonNull OnPermissionresult onPermissionresult) {
        this.onPermissionresult = onPermissionresult;
        this.Permissionstring = permisssion;
        this.PermissionMessage1 = permissionmessage1;
        if(permissionmessage2==null){
            this.PermissionMessage2 ="Grant All the Permission Inside Your App setting.";
        }else {
            this.PermissionMessage2 = permissionmessage2;
        }
        this.PermissionMessage3 = permissionmessage3;
        Log.d("Permissionfragment", "Permission size:" + this.Permissionstring.length);
        return this;
    }

    public PermissionFragment CheckForPermission(@NonNull String[] permisssion, @NonNull String permissionmessage1, @NonNull String permissionmessage2, @NonNull OnPermissionresult onPermissionresult) {
        this.onPermissionresult = onPermissionresult;
        this.Permissionstring = permisssion;
        this.PermissionMessage1 = permissionmessage1;
        if(permissionmessage2==null){
            this.PermissionMessage2 ="Grant All the Permission Inside Your App setting.";
        }else {
            this.PermissionMessage2 = permissionmessage2;
        }
        this.PermissionMessage2 = permissionmessage2;
        this.PermissionMessage3 = permissionmessage1;
        Log.d("Permissionfragment", "Permission size:" + this.Permissionstring.length);
        return this;
    }

    public PermissionFragment CheckForPermission(@NonNull String[] permisssion, @NonNull String permissionmessage1, @NonNull OnPermissionresult onPermissionresult) {
        this.onPermissionresult = onPermissionresult;
        this.Permissionstring = permisssion;
        this.PermissionMessage1 = permissionmessage1;
        this.PermissionMessage2 ="Grant All the Permission Inside Your App setting.";
        this.PermissionMessage3 = permissionmessage1;
        Log.d("Permissionfragment", "Permission size:" + this.Permissionstring.length);
        return this;
    }

    /**
     * Request Permission Result Interface
     *
     */

    public interface OnPermissionresult {

        void onSuccess();
        void onFail();

    }

    @Override
    public void show(FragmentManager manager, String tag) {
        super.show(manager, tag);
    }
}
