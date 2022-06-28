package com.lulu.room.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lulu.room.R;
import com.lulu.room.database.entitas.User;

import java.util.List;


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewAdapter> {

    private final List <User> list;
    public Context context;

    public UserAdapter(Context context, List<User>list){
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public ViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_user, parent, false);
        return new ViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewAdapter holder, int position) {
        holder.fullName.setText(list.get(position).fullName);
        holder.email.setText(list.get(position).email);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewAdapter extends RecyclerView.ViewHolder{
        TextView fullName, email;

        public ViewAdapter(@NonNull View itemView){
            super(itemView);
            fullName = itemView.findViewById(R.id.full_name);
            email = itemView.findViewById(R.id.email);
        }
    }
}
