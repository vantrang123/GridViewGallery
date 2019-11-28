package com.trangdv.gridviewgallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements GalleryAdapter.onAdd{

    private ArrayList<Users> users;
    private ArrayList<Users> tempUsers;
    private GridView gallery;
    private GalleryAdapter galleryAdapter;
    int count=1;
    private String[] names={
            "Asif KhanDefault","Tanvir Ahmed1","Nafis Iqbal2","Rahim Islam3","Abir Hasan4",
            "Asif Khan5","Tanvir Ahmed6","Nafis Iqbal7","Rahim Islam8","Abir Hasan9",
            "Asif Khan10","Tanvir Ahmed11","Nafis Iqbal12","Rahim Islam12","Abir Hasan13",
            "Asif Khan14","Tanvir Ahmed15","Nafis Iqbal16","Rahim Islam17","Abir Hasan18",
            "Asif Khan19","Tanvir Ahmed20","Nafis Iqbal21","Rahim Islam22","Abir Hasan23"
    };
    private String[] professions={
            "Android Developer","Web Developer","Python Programmer","iOS Programmer","Data Analyst",
            "Android Developer","Web Developer","Python Programmer","iOS Programmer","Data Analyst",
            "Android Developer","Web Developer","Python Programmer","iOS Programmer","Data Analyst",
            "Android Developer","Web Developer","Python Programmer","iOS Programmer","Data Analyst",
            "Android Developer","Web Developer","Python Programmer","iOS Programmer","Data Analyst"
    };
    private int[] photos={
            R.drawable.sample_5,R.drawable.sample_1,R.drawable.sample_6,R.drawable.sample_5,R.drawable.sample_5,
            R.drawable.sample_0,R.drawable.sample_2,R.drawable.sample_3,R.drawable.sample_5,R.drawable.sample_2,
            R.drawable.sample_6,R.drawable.sample_1,R.drawable.sample_4,R.drawable.sample_6,R.drawable.sample_4,
            R.drawable.sample_0,R.drawable.sample_3,R.drawable.sample_3,R.drawable.sample_5,R.drawable.sample_4,
            R.drawable.sample_7,R.drawable.sample_1,R.drawable.sample_5,R.drawable.sample_5,R.drawable.sample_0
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        users=new ArrayList<>();
        tempUsers=new ArrayList<>();
        gallery=(GridView)findViewById(R.id.gallery);
        users.add(new Users(names[0],professions[0],photos[0]));
        tempUsers.add(new Users(names[0],professions[0],photos[0]));
        galleryAdapter=new GalleryAdapter(tempUsers,this, this);
        gallery.setAdapter(galleryAdapter);
//        getDatas();
    }

    // getting all the datas
    private void getDatas(int count){
        tempUsers.clear();
        users.add(new Users(names[count],professions[count],photos[count]));
        swap();
        galleryAdapter.notifyDataSetChanged();
        count++;

    }

    private void swap() {
        for(int count=users.size()-1;count>=0;count--){
            tempUsers.add(new Users(names[count],professions[count],photos[count]));
        }
    }

    @Override
    public void onClickAdd() {
        getDatas(count);
    }
}
