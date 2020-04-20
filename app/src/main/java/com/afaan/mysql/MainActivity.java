package com.afaan.mysql;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.afaan.mysql.RecyclerPackage.DbAdapter;
import com.afaan.mysql.RecyclerPackage.DbModelClass;
import com.afaan.mysql.SQLitePackage.MyDbClass;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MyDbClass objMyDbClass;
    ArrayList<DbModelClass> objDbModelClassArrayList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objMyDbClass=new MyDbClass(this);
        objDbModelClassArrayList=new ArrayList<>();
        recyclerView=findViewById(R.id.dataRV);
    }

    public void showData(View view)
    {
        try {
           objDbModelClassArrayList=objMyDbClass.getAllData();
            DbAdapter objDbAdapter=new DbAdapter(objDbModelClassArrayList);

            recyclerView.hasFixedSize();
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(objDbAdapter);


        }
        catch (Exception e)
        {
            Toast.makeText(this, "show Data:-"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}
