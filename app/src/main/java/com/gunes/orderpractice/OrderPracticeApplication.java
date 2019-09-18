package com.gunes.orderpractice;

import android.app.Application;

import com.gunes.orderpractice.network.ApiClient;
import com.gunes.orderpractice.network.RestInterface;

/**
 * Created by MGunes on 2019-09-18.
 */
public class OrderPracticeApplication extends Application {

    private static OrderPracticeApplication instance;
    private RestInterface restInterface;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        restInterface = ApiClient.getClient().create(RestInterface.class);
    }

    public synchronized static OrderPracticeApplication getInstance() {
        return instance;
    }

    public RestInterface getRestInterface() {
        return restInterface;
    }

    public void setRestInterface(RestInterface restInterface) {
        this.restInterface = restInterface;
    }
}
