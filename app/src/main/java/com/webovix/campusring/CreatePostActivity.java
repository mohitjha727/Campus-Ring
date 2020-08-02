package com.webovix.campusring;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class CreatePostActivity extends AppCompatActivity {
    private TextView takepicture,takevideo,gallaryimg,gallaryvid,adddoc;
    private static final int pic_id = 152;
    private static final int REQUEST_CAPTURE_IMAGE = 100;
    private static final int VIDEO_CAPTURE = 101;
    private static final int REQUEST_TAKE_GALLERY_VIDEO = 150;
    private static final int REQUEST_CODE_DOC = 140;
    Uri imageUri,viduri1;
    private EditText editpost;
    private ImageView imgpost;
    private Button seevid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);
        getSupportActionBar().setTitle("Create Post");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        takepicture=(TextView)findViewById(R.id.takepic);
        takevideo=(TextView)findViewById(R.id.takevideo);
        gallaryimg=(TextView)findViewById(R.id.takepicgallary);
        gallaryvid=(TextView)findViewById(R.id.takevideogallary);
        adddoc=(TextView)findViewById(R.id.addattachments);
        editpost=(EditText)findViewById(R.id.addpost);
        imgpost=(ImageView)findViewById(R.id.imagepost);
        seevid=(Button)findViewById(R.id.seevideo);

        seevid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!viduri1.toString().isEmpty()){
                Intent intent=new Intent(getApplicationContext(), SeeVideo.class);
                intent.putExtra("uri",viduri1.toString());
                startActivity(intent);
            }
                else{
                    Toast.makeText(getApplicationContext(),"Please add video first",Toast.LENGTH_SHORT).show();
                }
            }
        });

        adddoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("application/msword,application/pdf");
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                // Only the system receives the ACTION_OPEN_DOCUMENT, so no need to test.
                startActivityForResult(intent, REQUEST_CODE_DOC);
            }
        });

        gallaryimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inti = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(inti, pic_id);
            }
        });

        takepicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,REQUEST_CAPTURE_IMAGE);
            }
        });

        takevideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(intent, VIDEO_CAPTURE);
            }
        });

        gallaryvid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("video/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select Video"),REQUEST_TAKE_GALLERY_VIDEO);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == pic_id) {

            imageUri = data.getData();
            imgpost.setImageURI(imageUri);
        }

        if (requestCode == REQUEST_CAPTURE_IMAGE &&
                resultCode == RESULT_OK) {
            if (data != null && data.getExtras() != null) {

                Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
                imgpost.setImageBitmap(imageBitmap);

            }
        }

        if (requestCode == REQUEST_TAKE_GALLERY_VIDEO
                &&
                resultCode == RESULT_OK) {
            if (data != null) {

                viduri1 = data.getData();
                Toast.makeText(getApplicationContext(),"Video added successfully",Toast.LENGTH_SHORT).show();
                seevid.setVisibility(View.VISIBLE);
                seevid.setEnabled(true);

            }
        }

        if(resultCode== RESULT_OK &&  requestCode== VIDEO_CAPTURE)
        {

            if (data != null) {

                viduri1 = data.getData();
                Toast.makeText(getApplicationContext(),"Video added successfully",Toast.LENGTH_SHORT).show();
                seevid.setVisibility(View.VISIBLE);
                seevid.setEnabled(true);

            }
        }

        }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.post_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.post_item)
        {
            Toast.makeText(getApplicationContext(),"Posted Successfully.",Toast.LENGTH_SHORT).show();
            finish();
        }
        if(item.getItemId()==android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}

