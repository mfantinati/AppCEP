package com.example.post;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {
    private final Retrofit retrofit;


    public RetrofitConfig(){
        this.retrofit =  new Retrofit.Builder()
                .baseUrl("https://api.postmon.com.br/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public EnderecoService getEnderecoService(){
        return this.retrofit.create(EnderecoService.class);
    }

}

