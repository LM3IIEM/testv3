package com.example.exp4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {
    List<String> nameList;
    List<String> numberList;
    LayoutInflater layoutInflater;
    int images[];

    ContactAdapter(Context context, List<String> nameList, List<String> numberList, int images[]) {
        this.nameList = nameList;
        this.numberList = numberList;
        this.layoutInflater = layoutInflater.from(context);
        this.images=images;

    }


    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.contact_details,parent,false);
        return new ContactViewHolder(view,numberList);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.nameTextView.setText(nameList.get(position));
        holder.numberTextView.setText(numberList.get(position));
        holder.imageView.setImageResource(images[position]);

    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }
}
