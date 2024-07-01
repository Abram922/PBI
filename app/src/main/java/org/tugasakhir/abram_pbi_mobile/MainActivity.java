package org.tugasakhir.abram_pbi_mobile;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.tugasakhir.abram_pbi_mobile.ui.models.NewHeadLines;
import org.tugasakhir.abram_pbi_mobile.ui.models.NewsApiResponse;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    RecyclerView recyclerView;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestManager manager = new RequestManager(this);
        manager.getNewHeadLines(listener,"general",null);
    }

    private final OnFetchDataListener<NewsApiResponse> listener = new OnFetchDataListener<NewsApiResponse>() {
        @Override
        public void onFecthData(List<NewHeadLines> list, String message) {
            showNews(list);

        }

        private void showNews(List<NewHeadLines> list) {
            recyclerView = findViewById(R.id.recycler_main);
            recyclerView.setHasFixedSize(true);
            adapter = new CustomAdapter(this,list);
            recyclerView.setAdapter(adapter);

        }

        @Override
        public  void onError(String message){

        }



    };
}
