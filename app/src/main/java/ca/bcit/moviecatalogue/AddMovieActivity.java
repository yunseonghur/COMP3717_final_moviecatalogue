package ca.bcit.moviecatalogue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class AddMovieActivity extends AppCompatActivity {

    TextView titlePage, addTitle, addDesc, addLink;
    EditText titleMovie, descMovie, linkMovie;
    Button btnSave, btnCancel;

    FirebaseDatabase database;
    DatabaseReference movieDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);

        titlePage = findViewById(R.id.title_page);

        addTitle = findViewById(R.id.add_title);
        addDesc = findViewById(R.id.add_desc);
        addLink = findViewById(R.id.add_link);

        titleMovie = findViewById(R.id.title_movie);
        descMovie = findViewById(R.id.desc_movie);
        linkMovie = findViewById(R.id.link_movie);

        btnSave = findViewById(R.id.btn_save);
        btnCancel = findViewById(R.id.btn_cancel);

        database = FirebaseDatabase.getInstance();
        movieDB = database.getReference("MovieCatalogueApp");

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveToFirebase();
            }
        });
    }

    private void saveToFirebase(){
        String title = titleMovie.getText().toString();
        String desc = descMovie.getText().toString();
        String link = linkMovie.getText().toString();

        if(!TextUtils.isEmpty(title) && !TextUtils.isEmpty(desc) && !TextUtils.isEmpty(link)){
            Movie movie = new Movie(title, desc, link);

            movieDB.push().setValue(movie).addOnSuccessListener(new OnSuccessListener<Void>(){
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(AddMovieActivity.this, "Movie is added", Toast.LENGTH_SHORT).show();

                    titleMovie.setText("");
                    descMovie.setText("");
                    linkMovie.setText("");
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(AddMovieActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(this, "All fields should be filled.", Toast.LENGTH_SHORT).show();
        }
    }
}