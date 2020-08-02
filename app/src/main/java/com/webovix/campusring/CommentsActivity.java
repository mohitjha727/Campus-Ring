package com.webovix.campusring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class CommentsActivity extends AppCompatActivity {
    private ImageView cmntsendbtn;
    private EditText editcmnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        cmntsendbtn=(ImageView) findViewById(R.id.cmntsendbtn);
        editcmnt=(EditText)findViewById(R.id.editcmnts);
        cmntsendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Comment added successfully.",Toast.LENGTH_SHORT).show();
                editcmnt.setText("");
            }
        });
    }
}
