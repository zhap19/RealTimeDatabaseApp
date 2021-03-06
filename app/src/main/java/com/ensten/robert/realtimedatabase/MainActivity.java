package com.ensten.robert.realtimedatabase;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    NavigationView navView;
    DrawerLayout drawerLayout;

    public String nombre="";
    //Login login = new Login();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.content_frame, new Graphs());
        tx.commit();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            String email = user.getEmail();

            TextView tvname = (TextView) findViewById(R.id.name);
            TextView tvmail = (TextView) findViewById(R.id.mail);

            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            email, Toast.LENGTH_SHORT);

            nombre=user.getEmail();
            toast1.show();


            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getToken() instead.

        }

        // Hide the status bar.

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_drawer);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);

        navView = (NavigationView)findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                boolean fragmentTransaction = false;
                Fragment fragment = null;

                switch (item.getItemId()) {
                    case R.id.nav_client:
                        fragment = new AddClients();
                        fragmentTransaction = true;
                        break;
                    case R.id.nav_charts:
                        fragment = new Graphs();
                        fragmentTransaction = true;
                        break;
                    //case R.id.nav_logout:
                    //    FirebaseAuth.getInstance().signOut();
                    case R.id.nav_exit:
                        finish();
                        break;
                    case android.R.id.home:
                        drawerLayout.openDrawer(GravityCompat.START);
                        return true;

                }

                if(fragmentTransaction) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content_frame, fragment)
                            .commit();

                    item.setChecked(true);
                    getSupportActionBar().setTitle(item.getTitle());
                }

                drawerLayout.closeDrawers();

                return true;
            }
        });

    }

    public String getName(){
        return nombre;
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
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.action_settings:
                return true;
            //...
        }

        return super.onOptionsItemSelected(item);
    }


}
