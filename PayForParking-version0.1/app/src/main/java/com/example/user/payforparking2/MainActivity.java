package com.example.user.payforparking2;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.payment) {
            Intent cinemaIntent = new Intent(MainActivity.this, PaymentActivity.class);
            startActivity(cinemaIntent);
            // Handle the camera action
        }
        if (id == R.id.monthlypayment) {
            Intent cinemaIntent = new Intent(MainActivity.this, CalculateActivity.class);
            startActivity(cinemaIntent);
        }else if (id == R.id.parking) {
            Intent cinemaIntent = new Intent(MainActivity.this, InsertActivity.class);
            startActivity(cinemaIntent);

        } else if (id == R.id.SearchBike) {
            Intent cinemaIntent = new Intent(MainActivity.this, SearchSQLiteActivity.class);
            startActivity(cinemaIntent);

        }
        else if (id == R.id.SearchCar) {
            Intent cinemaIntent = new Intent(MainActivity.this, carSearchActivity.class);
            startActivity(cinemaIntent);

        }
        else if (id == R.id.nav_share) {
            final AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Are you sure want to exist?");
            builder.setCancelable(true);
            builder.setPositiveButton("Ok",new DialogInterface.OnClickListener(){

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {





                    // TODO Auto-generated method stub
                    finish();
                }

            });

            builder.setNegativeButton("Cancel",new DialogInterface.OnClickListener(){

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    // TODO Auto-generated method stub
                    dialogInterface.cancel();
                }

            });

            AlertDialog alertDialog=builder.create();
            alertDialog.show();

        }




           /* AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this); //Home is name of the activity
            builder.setMessage("Do you want to exit?");
            builder.setCancelable(true);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                    finish();
                    Intent i=new Intent();
                    i.putExtra("finish", true);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // To clean up all activities
                    //startActivity(i);
                    finish();

                }
            });

            builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });

            AlertDialog alert=builder.create();
            alert.show();*/




        else if (id == R.id.nav_send) {
            Intent cinemaIntent = new Intent(MainActivity.this, AboutUs.class);
            startActivity(cinemaIntent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}