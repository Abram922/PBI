package org.tugasakhir.abram_pbi_mobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.tugasakhir.abram_pbi_mobile.ui.models.NewHeadLines;
import org.tugasakhir.abram_pbi_mobile.ui.models.NewsApiResponse;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private Context context;
    private List<NewHeadLines> headlines;

    public CustomAdapter(OnFetchDataListener<NewsApiResponse> context, List<NewHeadLines> headlines){
        this.context = context;
        this.headlines = headlines;
    }
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.headline_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.text_title.setText(headlines.get(position).getTitle());
        holder.text_source.setText(headlines.get(position).getSource().getName());
        if (headlines.get(position).getUrlToImage()!=null){
            Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.img_headline);

        }
    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }
}
