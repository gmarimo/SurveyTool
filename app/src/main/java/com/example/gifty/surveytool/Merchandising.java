package com.example.gifty.surveytool;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Merchandising extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button savenext, nextbtn;
    Spinner locations, outlet, branchmanagement;

    //Defining EditText variables
    EditText projectname, fullname, phonenumber, email, businessaddress;

    ArrayAdapter<CharSequence> adapter1, adapter2, adapter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchandising);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        savenext = (Button)findViewById(R.id.savenext);
        nextbtn = (Button)findViewById(R.id.nextbtn);
        locations = (Spinner)findViewById(R.id.locations);
        outlet = (Spinner)findViewById(R.id.outlet);
        branchmanagement = (Spinner)findViewById(R.id.branchmanagement);

        //EditText variables
        projectname = (EditText)findViewById(R.id.etprojectname);
        fullname = (EditText)findViewById(R.id.etfullname);
        phonenumber = (EditText)findViewById(R.id.etphonenumber);
        email = (EditText)findViewById(R.id.emailentry);
        businessaddress = (EditText)findViewById(R.id.etba);





        savenext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent savenextbtn = new Intent(getApplicationContext(), Reports.class);
                startActivity(savenextbtn);
            }
        });

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent merch = new Intent(getApplicationContext(), Reports.class);
                startActivity(merch);
            }
        });

        //Initializing locations
        adapter1 = ArrayAdapter.createFromResource(this, R.array.geolocations, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locations.setAdapter(adapter1);

        //Initialing outlet spinner
        adapter2 = ArrayAdapter.createFromResource(this, R.array.outlet_name, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        outlet.setAdapter(adapter2);

        //Initializing management spinner
        adapter3 = ArrayAdapter.createFromResource(this, R.array.management, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        branchmanagement.setAdapter(adapter3);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "GPS continuous sampling ...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    //Onclick Save button
    public void btnNext(View view){
        String str_projectname = projectname.getText().toString();
        String str_fullname = fullname.getText().toString();
        String str_phonenumber = phonenumber.getText().toString();
        String str_email = email.getText().toString();
        String str_ba = businessaddress.getText().toString();

        String type = "savedata";

        BackendWork backendWork = new BackendWork(this);
        backendWork.execute(type, str_projectname, str_fullname, str_phonenumber, str_email, str_ba);

    }





    @Override
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
        getMenuInflater().inflate(R.menu.merchandising, menu);
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

        if (id == R.id.home) {
            // Handle the camera action
        } else if (id == R.id.options) {

        } else if (id == R.id.settings) {

        } else if (id == R.id.account) {

        } else if (id == R.id.logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
