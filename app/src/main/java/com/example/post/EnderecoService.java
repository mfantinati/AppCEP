package com.example.post;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EnderecoService {

    @GET("cep/{cep}")
    Call<Endereco> getEndereco(@Path("cep")String cep);

}
