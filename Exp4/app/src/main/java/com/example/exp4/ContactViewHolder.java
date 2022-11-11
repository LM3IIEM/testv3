package com.example.exp4;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public ImageView imageView;
    public TextView nameTextView, numberTextView;
    List<String> numberList;

    public ContactViewHolder(@NonNull View itemView, List<String> numberList) {
        super(itemView);
        itemView.setOnClickListener(this);
        this.imageView = itemView.findViewById(R.id.imageView);
        this.nameTextView = itemView.findViewById(R.id.nameId);;
        this.numberTextView = itemView.findViewById(R.id.numberId);;
        this.numberList = numberList;
    }
    @Override
    public void onClick(View view){
        int position = getLayoutPosition();
        String element = numberList.get(position);
        Context context = view.getContext();
        context.startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+element)));


    }


}
