package com.example.macstudent.myapplication.Acitvities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by ADMIN on 7/10/2018.
 */

public class HomeActivityHomeActivity extends AppCompatActivity {

    Button alertCheckbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//
//        DBHelper mDBHelper = new DBHelper(this);
//        SQLiteDatabase mSQLiteDatabase = mDBHelper.getWritableDatabase();

//        AlertMessageFragment frag = new AlertMessageFragment();
//        FragmentManager manager= getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.add(R.id.AlertCheck, frag, "thirdFragment");
//        transaction.commit();
    }
    public void showDialog(View view)
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(HomeActivity.this);
        alertDialogBuilder.setTitle("Alert Message");
        alertDialogBuilder.setMessage("Here we will show the details");
        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                showMessage("Cancel - no");
            }
        });

        alertDialogBuilder.setPositiveButton("ok", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                showMessage("OK - Record Saved Successfully");
                dialogInterface.dismiss();
                // TODO
                // change the class to whereeve the final destination
                Intent mIntent = new Intent(HomeActivity.this, HomeActivity.class);
                startActivity(mIntent);
            }
        });

        alertDialogBuilder.setNeutralButton("Ignore", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                showMessage("Ignore");
            }
        });

        AlertDialog mAlertDialog = alertDialogBuilder.create();
        mAlertDialog.show();
    }

    public void showMessage(String msg)
    {
        Toast toast = Toast.makeText(HomeActivity.this, msg, Toast.LENGTH_SHORT);
        toast.show();
