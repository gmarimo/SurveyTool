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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Stocks extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //Button wosbtn, osbtn, csbtn;
    EditText et_wbrand, et_wpacksize, et_wquantitycounted, et_wbreakages_brand, et_wquantity_breakages,
    et_brand, et_packsize, et_quantitycounted, et_breakages_brand, et_quantity_breakages, et_cbrand,
    et_cpacksize, et_cquantitycounted, et_sales, et_cswarehouse;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stocks);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        et_wbrand = (EditText)findViewById(R.id.wbrand);
        et_wpacksize = (EditText)findViewById(R.id.wpacksize);
        et_wquantitycounted = (EditText)findViewById(R.id.wquantitycounted);
        et_wbreakages_brand = (EditText)findViewById(R.id.wbreakages_brand);
        et_wquantity_breakages = (EditText)findViewById(R.id.wquantity_breakages);
        et_brand = (EditText)findViewById(R.id.brand);
        et_packsize = (EditText)findViewById(R.id.packsize);
        et_quantitycounted = (EditText)findViewById(R.id.quantitycounted);
        et_breakages_brand = (EditText)findViewById(R.id.breakages_brand);
        et_quantity_breakages = (EditText)findViewById(R.id.quantity_breakages);
        et_cbrand = (EditText)findViewById(R.id.cbrand);
        et_cpacksize = (EditText)findViewById(R.id.cpacksize);
        et_cquantitycounted = (EditText)findViewById(R.id.cquantitycounted);
        et_sales = (EditText)findViewById(R.id.sales);
        et_cswarehouse = (EditText)findViewById(R.id.cswarehouse);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
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

    //Saving warehouse data
    public void save_warehouse(View view) {
        Toast.makeText(getApplicationContext(), "Saving warehouse stocks ...", Toast.LENGTH_LONG).show();

        String str_et_wbrand = et_wbrand.getText().toString();
        String str_et_wpacksize = et_wpacksize.getText().toString();
        String str_et_wquantitycounted = et_wquantitycounted.getText().toString();
        String str_et_wbreakages_brand = et_wbreakages_brand.getText().toString();
        String str_et_wquantity_breakages = et_wquantity_breakages.getText().toString();

        String type = "openStock_warehouse";

        MerchantBackend merchantBackend = new MerchantBackend(this);
        merchantBackend.execute(type, str_et_wbrand, str_et_wpacksize, str_et_wquantitycounted,
                str_et_wbreakages_brand, str_et_wquantity_breakages);

    }

    //Saving opening stock data
    public void saveos(View view){

        Toast.makeText(getApplicationContext(), "Saving opening stocks ...", Toast.LENGTH_LONG).show();

        String str_et_brand = et_brand.getText().toString();
        String str_et_packsize = et_packsize.getText().toString();
        String str_et_quantitycounted = et_quantitycounted.getText().toString();
        String str_et_breakages_brand = et_breakages_brand.getText().toString();
        String str_et_quantity_breakages = et_quantity_breakages.getText().toString();

        String type = "openStock";

        MerchantBackend merchantBackend = new MerchantBackend(this);
        merchantBackend.execute(type, str_et_brand, str_et_packsize, str_et_quantitycounted,
                str_et_breakages_brand, str_et_quantity_breakages);

    }

    //Saving closing stock data
    public void savecs(){

        Toast.makeText(getApplicationContext(), "Saving closing stocks ...", Toast.LENGTH_LONG).show();

        String str_et_cbrand = et_cbrand.getText().toString();
        String str_et_cpacksize = et_cpacksize.getText().toString();
        String str_et_cquantitycounted = et_cquantitycounted.getText().toString();
        String str_et_sales = et_sales.getText().toString();
        String str_et_cswarehouse = et_cswarehouse.getText().toString();

        String type = "closingStock";

        MerchantBackend merchantBackend = new MerchantBackend(this);
        merchantBackend.execute(type, str_et_cbrand, str_et_cpacksize, str_et_cquantitycounted,
                str_et_sales, str_et_cswarehouse);


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
        getMenuInflater().inflate(R.menu.stocks, menu);
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
