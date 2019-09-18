package com.gunes.orderpractice;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Toast;

import com.gunes.orderpractice.Data.Order;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnCancelListener {

    private Call<ArrayList<Order>> orderCall;
    private Dialog serviceDialog;
    private ArrayList<Order> orderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, R.color.colorAccent)));
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);

        serviceDialog = Utils.getDialog(this, "Sipariş bilgileri getiriliyor.");

        orderCall = OrderPracticeApplication.getInstance().getRestInterface().getOrders();
        orderCall.enqueue(new Callback<ArrayList<Order>>() {
            @Override
            public void onResponse(Call<ArrayList<Order>> call, Response<ArrayList<Order>> response) {
                serviceDialog.dismiss();
                if(response.isSuccessful()
                        && response.body() != null) {
                        orderList = response.body();
                } else {
                    Toast.makeText(MainActivity.this, "Sipariş bilgilerine ulaşılamadı.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Order>> call, Throwable t) {
                serviceDialog.dismiss();
                Toast.makeText(MainActivity.this, "Sipariş bilgilerine ulaşılamadı.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onCancel(DialogInterface dialog) {
        if(orderCall != null && orderCall.isExecuted()) {
            orderCall.cancel();
        }
    }
}
