package com.example.admin;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

        Button record;
        EditText bookname, authorname;
        DatabaseReference bookdb;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            record = findViewById(R.id.add_record);
            bookname = findViewById(R.id.user);
            authorname = findViewById(R.id.pass);


            bookdb = FirebaseDatabase.getInstance().getReference("bookinfo");

            record.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String book_name = bookname.getText().toString();
                    String author_name = authorname.getText().toString();
                    user students = new user(book_name, author_name);
                    bookdb.child(book_name).setValue(students);

                    Toast.makeText(getApplicationContext(), "Record Added Successfully", Toast.LENGTH_SHORT).show();

                }
            });
        }
}