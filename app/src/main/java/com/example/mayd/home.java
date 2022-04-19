package com.example.mayd;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AlertDialogLayout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class home extends AppCompatActivity {
    Button btn;
 ListView listView;

String[] school={"Alnoor","Faisal","Govt","Unique","Spirit","Alnoor","Aaisal","Govt","Unique","Spirit","Alnoor","Aaisal","Govt","Unique","Spirit"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        listView=findViewById(R.id.lstView);
        btn=findViewById(R.id.AlertDialouge);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,school);
                listView.setAdapter(adapter);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builder=new AlertDialog.Builder(home.this);
                                builder.setMessage("Are you want to Exit");
                                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        home.this.finish();
                                    }
                                }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.cancel();
                                    }
                                });
                                AlertDialog alert= builder.create();
                                alert.show();

                    }
                });

    }
}