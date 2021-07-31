package com.example.rentalhouse;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.HashMap;

public class imageupload extends AppCompatActivity {

    private ImageSwitcher imagesIs;
    EditText housename;
    private Button previousbutton, nextbutton, pickimagebutton, uploadimg;
    private ArrayList<Uri> imageUris= new ArrayList<Uri>();
    private int uploads = 0;
    ProgressDialog progressDialog;

    private static final int PICK_IMAGE_CODE = 1;
    private final DatabaseReference root = FirebaseDatabase.getInstance().getReference("user");
    private final StorageReference reference = FirebaseStorage.getInstance().getReference();
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageupload);
        imagesIs = findViewById(R.id.imageIs);
        previousbutton = findViewById(R.id.preciousbutton);
        nextbutton = findViewById(R.id.buttonnext);
        uploadimg = findViewById(R.id.uploadimg);
        pickimagebutton = findViewById(R.id.pickimagebutton);
        housename=findViewById(R.id.hou_name);
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Processing Please wait");
        imagesIs.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                return imageView;
            }
        });

        imageUris = new ArrayList<>();
        pickimagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pickImageIntent();
            }
        });

        previousbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position > 0) {
                    position--;
                    imagesIs.setImageURI(imageUris.get(position));
                } else {
                    Toast.makeText(imageupload.this, "No Image", Toast.LENGTH_SHORT).show();
                }

            }
        });
        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position < imageUris.size() - 1) {
                    position++;
                    imagesIs.setImageURI(imageUris.get(position));
                } else {
                    Toast.makeText(imageupload.this, "No Image", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

  //pick image

    private void pickImageIntent (){
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "select Image(s)"), 2);

        }


        @Override
        protected void onActivityResult ( int requestCode, int resultCode, @Nullable Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 2) {
                if (resultCode == Activity.RESULT_OK) {
                    assert data != null;
                    if (data.getClipData() != null) {
                        int cout = data.getClipData().getItemCount();
                        for (int i = 0; i < cout; i++) {
                            Uri imageUri = data.getClipData().getItemAt(i).getUri();
                            imageUris.add(imageUri);
                            Toast.makeText(imageupload.this,"You Have Selected"+imageUris.size()+" Files",Toast.LENGTH_SHORT).show();

                        }
                        imagesIs.setImageURI(imageUris.get(0));
                        position = 0;

                    } else {
                        Uri imageUri = data.getData();
                        imageUris.add(imageUri);
                        imagesIs.setImageURI(imageUris.get(0));
                        position = 0;

                    }
                }
            }
        }
//upload

    public  void uploadFiles(View view){
        String house_name = housename.getText().toString().trim();

        if (TextUtils.isEmpty(house_name)) {
            housename.setError("Housename is Required");
            return;
        }else{
            progressDialog.show();
        Toast.makeText(imageupload.this,"if Takes time ,You can press again",Toast.LENGTH_SHORT).show();
        for (int j=0;j<imageUris.size();j++){
            Uri perfile=imageUris.get(j);
            StorageReference folder=FirebaseStorage.getInstance().getReference().child("Files"+house_name);
            StorageReference filename=folder.child("file"+ perfile.getLastPathSegment());
            filename.putFile(perfile).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    filename.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference("user").child(house_name);
                            HashMap<String,String> hashMap=new HashMap<>();
                            hashMap.put("IMAGE",String.valueOf(uri));
                            databaseReference.push().setValue(hashMap);
                            progressDialog.dismiss();
                            imageUris.clear();
                        }
                    });
                }
            });
        }
        }
    }

    public void showall(View view) {
        startActivity(new Intent(getApplicationContext(),imageslider.class));

    }
}
