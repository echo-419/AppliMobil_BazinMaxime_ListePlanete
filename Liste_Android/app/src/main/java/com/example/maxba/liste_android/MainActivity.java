package com.example.maxba.liste_android;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView MaListe ;
    private void initList(ArrayList<AndroidVersion> androidList){

        AndroidVersion version3= new AndroidVersion();
        version3.setVersionName("Mercure");
        version3.setVersionNumber("\"La distance actuelle Vénus - Terre est de 102,58 millions de km");
        androidList.add(version3);

        AndroidVersion version2= new AndroidVersion();
        version2.setVersionName("Vénus");
        version2.setVersionNumber("La distance actuelle Vénus - Terre est de 66,38 millions de km");
        androidList.add(version2);

        AndroidVersion version= new AndroidVersion();
        version.setVersionName("Mars");
        version.setVersionNumber("La distance actuelle Mars - Terre est de 151,11 millions de km");
        androidList.add(version);

        AndroidVersion version4= new AndroidVersion();
        version4.setVersionName("Jupiter");
        version4.setVersionNumber("La distance actuelle Jupiter - Terre est de 949,16 millions de km");
        androidList.add(version4);

        AndroidVersion version5= new AndroidVersion();
        version5.setVersionName("Saturne");
        version5.setVersionNumber("La distance actuelle Saturne - Terre est de 1,63 milliards de km");
        androidList.add(version5);

        AndroidVersion version6= new AndroidVersion();
        version6.setVersionName("Uranus");
        version6.setVersionNumber("La distance actuelle Uranus - Terre est de 2,86 milliards de km");
        androidList.add(version6);

        AndroidVersion version7= new AndroidVersion();
        version7.setVersionName("Neptune");
        version7.setVersionNumber("La distance actuelle Neptune - Terre est de 4,46 milliards de km");
        androidList.add(version7);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*MaListe = (ListView) findViewById(R.id.Liste);
        Resources res = getResources();
        String[]Nom = res.getStringArray(R.array.Planete);
        String[]info = res.getStringArray(R.array.InfoPlanete);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,Nom);
        MaListe.setAdapter(adapter);*/


        setContentView(R.layout.activity_main);
        ArrayList<AndroidVersion> androidList = new ArrayList<AndroidVersion>();
        initList(androidList); AndroidAdapter adapter = new AndroidAdapter(this,R.layout.modele_ligne,androidList);
        final ListView list = (ListView) findViewById(R.id.Liste);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                AndroidVersion selectedItem = (AndroidVersion)adapter.getItemAtPosition(position);
                int duration = Toast.LENGTH_LONG;
                Toast.makeText(MainActivity.this, selectedItem.getVersionName(), duration).show();
                Log.v("ListPersonnalisée", "Element selectionné : " + selectedItem.getVersionName());
            }
                });





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
