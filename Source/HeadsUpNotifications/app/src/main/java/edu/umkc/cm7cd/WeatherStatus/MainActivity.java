package edu.umkc.cm7cd.WeatherStatus;

import android.content.Intent;
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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static EditText username;
    private static EditText password;
    private static TextView attemptsLeft;
    private static Button login;
    private static Button reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

    public void loginCredentials(View view){
        username = (EditText) findViewById(R.id.editText_uname);
        password = (EditText) findViewById(R.id.editText2_pswd);
        login = (Button) findViewById(R.id.button_login);
        reset = (Button) findViewById(R.id.button_reset);
        if((!username.getText().toString().isEmpty()) && (!password.getText().toString().isEmpty())){
            if((username.getText().toString().equals("Student")) && (password.getText().toString().equals("Student"))){
                Intent intent = new Intent(MainActivity.this,WeatherStatus.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(MainActivity.this, "Incorrect credentials. " +
                        "Try again...", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void resetData(View view){
        username = (EditText) findViewById(R.id.editText_uname);
        password = (EditText) findViewById(R.id.editText2_pswd);
        username.setText("");
        password.setText("");
    }

    public void newUser(View view){
        Intent intent= new Intent(MainActivity.this,RegisterActivity.class);
        startActivity(intent);
    }
}
