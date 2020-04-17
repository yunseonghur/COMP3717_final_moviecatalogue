package ca.bcit.moviecatalogue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MovieViewHolder extends RecyclerView.ViewHolder {

    public TextView movie_title, movie_desc, movie_link;

    public MovieViewHolder(@NonNull View itemView){
        super(itemView);

        movie_title = itemView.findViewById(R.id.movie_title);
        movie_desc = itemView.findViewById(R.id.movie_desc);
        movie_link = itemView.findViewById(R.id.movie_link);
    }


}


//
//public class MovieViewHolder extends RecyclerView.Adapter<MovieViewHolder.MyViewHolder> {
//
//    Context context;
//    ArrayList<Movie> myMovies;
//
//    public MovieViewHolder(Context c, ArrayList<Movie> m){
//        context = c;
//        myMovies = m;
//    }
//
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false));
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int pos) {
//        holder.movieTitle.setText(myMovies.get(pos).getTitle());
//        holder.movieDesc.setText(myMovies.get(pos).getDescription());
//        holder.movieLink.setText(myMovies.get(pos).getLink());
//
//        final String getTitle = myMovies.get(pos).getTitle();
//        final String getDesc = myMovies.get(pos).getDescription();
//        final String getLink = myMovies.get(pos).getLink();
//
//        //holder.itemView.setOnClickListener(new View.OnClickListener() {
//        //    @Override
//        //    public void onClick(View v) {
//        //        Intent intent = new Intent(context, EditTaskDesk.class);
//        //        intent.putExtra("titledoes", getTitle);
//        //        intent.putExtra("descdoes", getDesc);
//        //        intent.putExtra("datedoes", getLink);
//        //        context.startActivity(intent);
//        //    }
//        //});
//    }
//
//    @Override
//    public int getItemCount() {
//        return myMovies.size();
//    }
//
//    class MyViewHolder extends RecyclerView.ViewHolder{
//
//        TextView movieTitle;
//        TextView movieDesc;
//        TextView movieLink;
//
//        public MyViewHolder(@NonNull View itemView){
//            super(itemView);
//            movieTitle = (TextView) itemView.findViewById(R.id.movie_title);
//            movieDesc = (TextView) itemView.findViewById(R.id.movie_desc);
//            movieLink = (TextView) itemView.findViewById(R.id.movie_link);
//        }
//    }
//}
