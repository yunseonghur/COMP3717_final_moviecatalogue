package ca.bcit.moviecatalogue;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MovieViewHolder extends RecyclerView.ViewHolder {

    public TextView movie_title, movie_desc, movie_link;

    public MovieViewHolder(@NonNull View itemView){
        super(itemView);

        movie_title = itemView.findViewById(R.id.movie_title);
        movie_desc = itemView.findViewById(R.id.movie_desc);
        movie_link = itemView.findViewById(R.id.movie_link);
    }
}