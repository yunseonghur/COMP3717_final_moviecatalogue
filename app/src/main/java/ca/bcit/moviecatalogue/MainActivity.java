package ca.bcit.moviecatalogue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView titlePage, subtitlePage;

    RecyclerView recyclerView;
    Button btnAdd;

    FirebaseDatabase database;
    DatabaseReference movieDB;

    FirebaseRecyclerOptions<Movie> options;
    FirebaseRecyclerAdapter<Movie, MovieViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titlePage = findViewById(R.id.title_page);
        subtitlePage = findViewById(R.id.subtitle_page);

        recyclerView = findViewById(R.id.my_movies);
        btnAdd = findViewById(R.id.fab);

        database = FirebaseDatabase.getInstance();
        movieDB = database.getReference("MovieCatalogueApp");

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        showTask();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddMovieActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showTask(){
        options = new FirebaseRecyclerOptions.Builder<Movie>()
                .setQuery(movieDB, Movie.class)
                .build();

        adapter = new FirebaseRecyclerAdapter<Movie, MovieViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int i, @NonNull Movie movie) {
                movieViewHolder.movie_title.setText(movie.getTitle());
                movieViewHolder.movie_desc.setText(movie.getDescription());
                movieViewHolder.movie_link.setText(movie.getLink());
            }

            @NonNull
            @Override
            public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.movie_item, parent, false);

                return new MovieViewHolder(itemView);
            }
        };
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
