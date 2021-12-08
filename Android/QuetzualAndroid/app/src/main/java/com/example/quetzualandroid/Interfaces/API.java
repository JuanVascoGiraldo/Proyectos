package com.example.quetzualandroid.Interfaces;

import com.example.quetzualandroid.Models.mes;
import com.example.quetzualandroid.Models.mpregunta;
import com.example.quetzualandroid.Models.mrespuesta;
import com.example.quetzualandroid.Models.publi;
import com.example.quetzualandroid.Models.status;
import com.example.quetzualandroid.Models.usuario;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface API {
    @POST("Iniciar/Sesion/Validar")
    Call<usuario> iniciarsesion(@Body usuario usu);

    @POST("Ranking/Mensual")
    Call<List<usuario>> ranking(@Body mes mess);

    @GET("Pendientes")
    Call<List<mpregunta>> pendientes();

    @POST("Pregunta/Rechazar")
    Call<ResponseBody> rechazar(@Body mrespuesta res);

    @POST("Pregunta/Responder")
    Call<ResponseBody> responder(@Body mrespuesta res);

    @GET("Historico/Doctor/Respondidas/{id}")
    Call<List<publi>> respondidas(@Path("id") int idusu);

    @GET("Historico/Doctor/Rechazadas/{id}")
    Call<List<publi>> rechazadas(@Path("id") int idusu);

}
