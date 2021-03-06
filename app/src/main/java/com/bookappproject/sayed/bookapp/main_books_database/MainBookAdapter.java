package com.bookappproject.sayed.bookapp.main_books_database;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bookappproject.sayed.bookapp.R;
import com.bookappproject.sayed.bookapp.book_detail.book_deteil_ui.BookCover;

import java.util.ArrayList;

public class MainBookAdapter extends RecyclerView.Adapter<MainBookAdapter.MainBookHolder>{
    Context context;
    ArrayList<MainBookObject>bookObjects;

    public MainBookAdapter(Context context, ArrayList<MainBookObject> bookObjects){
        this.context = context;
        this.bookObjects = bookObjects;
    }

    @NonNull
    @Override
    public MainBookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.single_book_rv, parent, false);

        return new MainBookHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MainBookHolder holder, int position) {
        holder.imageView.setImageResource(getImage(bookObjects.get(position).getImage()));
        holder.textView.setText(bookObjects.get(position).getBookTitle());
    }

    // get suitable Image
    private int getImage(String img){
        switch (img){
            case "one":
                return R.drawable.sample_cover_photo;
            case "Two":
                return R.drawable.sample_cover_photo;
            case "Three":
                return R.drawable.sample_cover_photo;
            default:
                return R.drawable.sample_cover_photo;
        }
    }

    @Override
    public int getItemCount() {
        return bookObjects.size();
    }

    class MainBookHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        MainBookHolder(final View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.main_book_IV_Adapter);
            textView = itemView.findViewById(R.id.main_book_TV_adapter);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*int position = getAdapterPosition();
                    Toast.makeText(context, ""+bookObjects.get(position).getFirebaseID(), Toast.LENGTH_SHORT).show();*/
                    context.startActivity(new Intent(context, BookCover.class)
                                            .putExtra("BOOK_ID", bookObjects.get(getAdapterPosition()).getFirebaseID()));
                }
            });
        }
    }
}
