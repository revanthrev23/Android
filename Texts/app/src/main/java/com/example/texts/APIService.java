package com.example.texts;

import com.example.texts.Notifications.MyResponse;
import com.example.texts.Notifications.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers({
            "Content-Type:application/json",
            "Authorization:key=AAAAmZNrbKI:APA91bHAAY2SNCxn8jr_PphjgxXIglpbb2RGT9iDeWCRoY7sr8BkCsxjb7ffEyxHXBnI1xJw2LFMYE00hQyaeM05RUx6AZkKc5PS-szmF6vxwnK4MDSNY_JKqOqW-2_oHHTghdcklxYZ"
    })

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
