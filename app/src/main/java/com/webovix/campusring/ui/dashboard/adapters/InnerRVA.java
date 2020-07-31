package com.webovix.campusring.ui.dashboard.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.webovix.campusring.R;
import com.webovix.campusring.ui.dashboard.models.ImagesList;

import java.util.List;

public class InnerRVA extends RecyclerView.Adapter<InnerRVA.ViewHolder> {
    private Context context;
    private List<ImagesList> imagesList;

    public InnerRVA(Context context, List<ImagesList> imageslist) {
        this.context = context;
        this.imagesList = imageslist;
    }

    @NonNull
    @Override
    public InnerRVA.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dashboard_list_image, parent, false);
        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerRVA.ViewHolder holder, int position) {
        ImagesList datamodelImages = imagesList.get(position);
       // holder.postImage.()
        holder.imageURL.setText(datamodelImages.getImageURL());
    }

    @Override
    public int getItemCount() {
        return imagesList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView postImage;
        TextView imageURL;
        public ViewHolder(@NonNull View itemView, final Context context) {
            super(itemView);
            postImage = itemView.findViewById(R.id.imageView);
            imageURL = itemView.findViewById(R.id.textImageUrl);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    ImagesList img = imagesList.get(position);
                    Toast.makeText(context, img.getImageURL(), Toast.LENGTH_SHORT).show();
                }
            });


        }

        @Override
        public void onClick(View v) {
            //when something inside row is to be clicked
        }
    }
}
