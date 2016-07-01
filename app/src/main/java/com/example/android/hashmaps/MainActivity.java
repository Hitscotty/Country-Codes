package com.example.android.hashmaps;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    Map<String, String> countries = new HashMap<String, String>();
    Map<String, String>    code   = new HashMap<String, String>();

    TextView output;
    TextView outputTitle;
    EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        populate();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        output      = (TextView) findViewById(R.id.output);
        outputTitle = (TextView) findViewById(R.id.outputTitle);
        search      = (EditText) findViewById(R.id.search);

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String in  = search.getText().toString();
                int size   = in.length();

                if(size == 3){
                    output.setText(countries.get(in.toUpperCase()));
                    outputTitle.setText("Country");

                }

                if(size < 3){
                    output.setText("Null");
                    outputTitle.setText("Invalid Input");

                }

                if(size > 3){
                    output.setText(code.get(in));
                    outputTitle.setText("Country Code");
                }
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

    //hardcoded debugging tests
    //preferablly loads up from file or webpage
    public void populate(){
        countries.put("AFG", "Afghanistan");
        countries.put("ALA", "Aland Islands");
        countries.put("ALB", "Albania");

        code.put("Afghanistan"  , "004");
        code.put("Aland Islands", "248");
        code.put("Albania"      , "008");

    }
}
