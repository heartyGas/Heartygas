package com.heartygas;

import android.content.DialogInterface;

import com.google.android.material.navigation.NavigationView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class CustomerHomeActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home);

        drawerLayout = findViewById(R.id.activityMainIDWithDrawer);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        NavigationView navigationView = findViewById(R.id.naviViewHome);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setUpDrawerContent(navigationView);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected((item))) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void selectItemDrawer (MenuItem item) {
        Fragment myFragment = null;
        Class fragmentClass = null;
        switch (item.getItemId()) {
            case R.id.freeGas:

                Toast.makeText(getApplicationContext(), "FVFVFDDV", Toast.LENGTH_LONG).show();

                fragmentClass = FreeGasFragment.class;
                break;
            case R.id.payment:
                fragmentClass = PaymentFragment.class;
                break;
            case R.id.history:
                fragmentClass = HistoryFragment.class;
                break;
            case R.id.referral:
                fragmentClass = ReferralFragment.class;
                break;
            case R.id.support:
                fragmentClass = SupportFragment.class;
                break;
            case R.id.about:
                fragmentClass = AboutFragment.class;
                break;
            case R.id.signOut:
                break;

        }
        try{
            myFragment = (Fragment) fragmentClass.newInstance();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frameHomeLayout, myFragment).commit();
        item.setChecked(true);
        setTitle(item.getTitle());
        drawerLayout.closeDrawers();
    }

    private void setUpDrawerContent (NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(menuItem -> {
            selectItemDrawer(menuItem);
            return true;
        });
    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(CustomerHomeActivity.this);
        builder.setMessage("Do you want to Exit?");
        builder.setCancelable(true);
        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setPositiveButton("Oh No!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
