package com.gunes.orderpractice;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by MGunes on 2019-09-18.
 */
public class Utils {

    public static Dialog getDialog(Context context, String title) {
        Dialog serviceDialog = new Dialog(context);
        serviceDialog.setCanceledOnTouchOutside(false);
        LayoutInflater li = LayoutInflater.from(context);
        RelativeLayout theview = (RelativeLayout) li.inflate(R.layout.service_loading_dialog, null);
        ((TextView)theview.findViewById(R.id.service_loading_dialog_title)).setText(title);
        serviceDialog.setContentView(theview);
        serviceDialog.setOnCancelListener((DialogInterface.OnCancelListener) context);
        return serviceDialog;
    }

}
