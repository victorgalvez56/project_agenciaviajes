package com.example.project_agenciaviajes.Adapters;

import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.project_agenciaviajes.R;
import com.example.project_agenciaviajes.model.Packages;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Packages> users;

    public ProductAdapter(List<Packages> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // return null;
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_user, viewGroup, false);
        return new ProductViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int i) {
        User user = users.get(i);
        userViewHolder.txvName.setText(user.getName());
        userViewHolder.txvSurname.setText(user.getSurname());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class UserViewHolder extends ViewHolder {

        private TextView txvName, txvSurname;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            txvName = itemView.findViewById(R.id.txv_name);
            txvSurname = itemView.findViewById(R.id.txv_surname);
        }
    }
}