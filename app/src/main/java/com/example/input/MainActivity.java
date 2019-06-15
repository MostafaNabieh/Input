package com.example.input;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner=findViewById(R.id.label_spinner);
        if(spinner != null)
        {
            spinner.setOnItemSelectedListener(this);

        }
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this,R.array.spinner,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if(spinner !=null)
        {
            spinner.setAdapter(adapter);


        }


    }

    public void onRadioButtonClicked(View view) {
        boolean checked=((RadioButton)view).isChecked();
        switch (view.getId())
        {
            case R.id.sameday:
                displaytoast("Same day messenger service");
                break;
            case R.id.nextday:
                displaytoast("Next day ground delivery");
                break;
            case R.id.pickup:
                displaytoast("Pick up");
                break;
                default:
                    break;
        }
    }

    public void displaytoast(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String spinner_string;
        spinner_string=parent.getItemAtPosition(position).toString();
        displaytoast(spinner_string);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
