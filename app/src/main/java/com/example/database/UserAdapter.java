package com.example.database;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private static final String TAG = "UserAdapter";


    ArrayList<String> users;

    public UserAdapter(ArrayList<String> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        holder.input_Data.setText(users.get(position));
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: "+users.size());
        return users.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {   // odpowiada za pojedynczy rekord
        public TextView input_Data;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            input_Data = itemView.findViewById(R.id.input_Data);
        }
    }
}
