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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddMovieActivity extends AppCompatActivity {

    TextView titlePage, addTitle, addDesc, addLink;
    EditText editTitle, editDesc, editLink;
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

        editTitle = findViewById(R.id.title_movie);
        editDesc = findViewById(R.id.desc_movie);
        editLink = findViewById(R.id.link_movie);

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
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToMain();
            }
        });
    }

    private void saveToFirebase(){
        String title = editTitle.getText().toString();
        String desc = editDesc.getText().toString();
        String link = editLink.getText().toString();

        if(!TextUtils.isEmpty(title) && !TextUtils.isEmpty(desc) && !TextUtils.isEmpty(link)){
            Movie movie = new Movie(title, desc, link);

            movieDB.push().setValue(movie).addOnSuccessListener(new OnSuccessListener<Void>(){
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(AddMovieActivity.this, "Successfully added!", Toast.LENGTH_SHORT).show();

                    editTitle.setText("");
                    editDesc.setText("");
                    editLink.setText("");
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

    private void backToMain(){
        Intent intent = new Intent(AddMovieActivity.this, MainActivity.class);
        startActivity(intent);
    }
}