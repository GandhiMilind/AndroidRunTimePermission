package com.example.permissionlib;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class PermissionMessageDilaogbox extends Dialog {


    /**
     * Interface Listener variable
     */
    private onDialogclickListener onDialogclickListener;


    /**
     * Extra variable
     */
    private TextView PermissionMessage;
    public TextView grantpermissionclick,cancel;
    private String message;


    public PermissionMessageDilaogbox(@NonNull Context context, @NonNull String message) {
        super(context);
        this.message = message;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.permission_message_dialog);

        PermissionMessage = (TextView) findViewById(R.id.permissionmessage);
        grantpermissionclick = (TextView) findViewById(R.id.grantpermissionclick);
        cancel = (TextView) findViewById(R.id.cancel);

        PermissionMessage.setText(message);

        grantpermissionclick.setOnClickListener(view -> {

            if (onDialogclickListener != null) {
                onDialogclickListener.onPermissionclick();
            }
        });

        cancel.setOnClickListener(view -> {

            if(onDialogclickListener!=null){
                onDialogclickListener.onCancleclick();
            }

        });

    }

    /**
     * Interface for Dialog Box click.
     */
    public interface onDialogclickListener {
        void onPermissionclick();
        void onCancleclick();
    }

    public void SetOnDialogclickListener(onDialogclickListener onDialogclickListener) {
        this.onDialogclickListener = onDialogclickListener;
    }

}
