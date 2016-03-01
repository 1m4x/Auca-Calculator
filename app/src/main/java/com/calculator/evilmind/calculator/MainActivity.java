package com.calculator.evilmind.calculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.text.TextUtils;

public class MainActivity extends AppCompatActivity {

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
    public void getClickedButton(View view)
    {
        Button button_clicked = (Button) findViewById(view.getId());
        EditText screen = (EditText) findViewById(R.id.editText);
        if (button_clicked.getText() != "=") {
            screen.setText((CharSequence) screen.getText() + (String) button_clicked.getText());
        }
    }
    public int buffer_a, buffer_b, opcode;
    public void Sum(View view)
    {
        EditText screen = (EditText) findViewById(R.id.editText);
        int screenValue = Integer.parseInt( screen.getText().toString());
        buffer_a = screenValue;
        opcode = 1;
        screen.setText("");
    }
    public void Sub(View view)
    {
        EditText screen = (EditText) findViewById(R.id.editText);
        int screenValue = Integer.parseInt( screen.getText().toString());
        buffer_a = screenValue;
        opcode = 2;
        screen.setText("");
    }
    public void Mul(View view)
    {
        EditText screen = (EditText) findViewById(R.id.editText);
        int screenValue = Integer.parseInt( screen.getText().toString());
        buffer_a = screenValue;
        opcode = 3;
        screen.setText("");
    }
    public void Div(View view)
    {
        EditText screen = (EditText) findViewById(R.id.editText);
        int screenValue = Integer.parseInt( screen.getText().toString());
        buffer_a = screenValue;
        opcode = 4;
        screen.setText("");
    }
    public void Res(View view)
    {
        EditText screen = (EditText) findViewById(R.id.editText);
        int screenValue = Integer.parseInt( screen.getText().toString());
        int result = 0;
        buffer_b = screenValue;
        if (opcode == 1)
        {
            result = buffer_a + buffer_b;
        } else if (opcode == 2)
        {
            result = buffer_a - buffer_b;
        } else if (opcode == 3)
        {
            result = buffer_a * buffer_b;
        } else if (opcode == 4)
        {
            result = buffer_a / buffer_b;
        }
        screen.setText(""+result);
    }
}
