package org.tugasakhir.abram_pbi_mobile;

import android.content.Context;
import android.widget.Toast;

import org.tugasakhir.abram_pbi_mobile.ui.models.NewsApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RequestManager {
    Context context;

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create()).build();

    public void getNewHeadLines(OnFetchDataListener listener,String category, String query){
        CallNewsApi callNewsApi = retrofit.create(CallNewsApi.class);
        Call<NewsApiResponse> call = callNewsApi.callhHeadLines("id",category,query, context.getString(R.string.api_key));

        try {
            call.enqueue(new Callback<NewsApiResponse>() {
                @Override
                public void onResponse(Call<NewsApiResponse> call, Response<NewsApiResponse> response) {
                    if (response.isSuccessful()){
                        Toast.makeText(context, "API tidak terhubung", Toast.LENGTH_SHORT).show();
                    }
                    listener.onFecthData(response.body().getArticles(),response.message());
                }

                @Override
                public void onFailure(Call<NewsApiResponse> call, Throwable throwable) {
                    listener.onError("Request Gagal");

                }
            });
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public RequestManager(Context context) {
        this.context = context;
    }

    public interface CallNewsApi{
        @GET("top-headlines")
        Call<NewsApiResponse> callhHeadLines(
                @Query("country") String country,
                @Query("category") String category,
                @Query("q") String query,
                @Query("apiKey") String api_Key
        );
    }
}
