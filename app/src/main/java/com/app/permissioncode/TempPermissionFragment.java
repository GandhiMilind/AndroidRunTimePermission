package com.app.permissioncode;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.permissionlib.PermissionFragment;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.INTERNET;
import static android.Manifest.permission.PROCESS_OUTGOING_CALLS;
import static android.Manifest.permission.READ_CONTACTS;
import static android.Manifest.permission.RECEIVE_BOOT_COMPLETED;


/**
 * A simple {@link Fragment} subclass.
 */
public class TempPermissionFragment extends Fragment {

    private TextView grantpermission;

    public TempPermissionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_temp_permission, container, false);

        grantpermission = (TextView)view.findViewById(R.id.grantpermissionclick);

        grantpermission.setOnClickListener(view1 -> {

            new PermissionFragment().CheckForPermission(new String[]{CAMERA, PROCESS_OUTGOING_CALLS, RECEIVE_BOOT_COMPLETED, INTERNET, READ_CONTACTS}
                    , "We need Call Permission for Callmanagment"
                    ,"Grant All the Permission Inside Your App setting."
                    ,"This Application REquired Storage and Internet Permissions. Please Grant this Permission."
                    , new PermissionFragment.OnPermissionresult() {
                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onFail() {

                        }
                    }).show(getFragmentManager(), "dialogframent");

        });

        return view;
    }

}
