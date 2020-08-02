package com.webovix.campusring.ui.dashboard.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.webovix.campusring.R;
import com.webovix.campusring.ui.dashboard.models.ImagesList;
import com.webovix.campusring.ui.dashboard.models.Story;

import java.util.List;

public class OuterRVA extends RecyclerView.Adapter<OuterRVA.ViewHolder> {
    private Context context;
    private List<Story> postlist;
    RecyclerView recyclerView2;
    List<ImagesList> images;
    InnerRVA innerRVA;


    public OuterRVA(Context context, List<Story> postlist) {
        this.context = context;
        this.postlist = postlist;
    }

    @NonNull
    @Override
    public OuterRVA.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dashboard_list_story, parent, false);
        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull OuterRVA.ViewHolder holder, int position) {
        Story datamodel = postlist.get(position);
        holder.name.setText(datamodel.getName());

        images = datamodel.getImageList();
        innerRVA = new InnerRVA(context, images);
        recyclerView2.setAdapter(innerRVA);
        innerRVA.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return postlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
        ImageView profilePhoto;
        TextView date;


        public ViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            name = itemView.findViewById(R.id.textView2);
            recyclerView2 = itemView.findViewById(R.id.innerRVA);
            recyclerView2.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();
            Log.d("check", "onClick: clicked");
        }
    }
}