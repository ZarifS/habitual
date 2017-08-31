package com.accentsoftware.habitual;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.util.ArrayList;

public class Repeat extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    ArrayList<String> days = new ArrayList(7);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repeat);
        initCheckBoxes();
    }

    public void initCheckBoxes(){
        CheckBox monday = (CheckBox) findViewById(R.id.mon_checkBox);
        CheckBox tuesday = (CheckBox) findViewById(R.id.tues_checkBox);
        CheckBox wednesday = (CheckBox) findViewById(R.id.wed_checkBox);
        CheckBox thursday = (CheckBox) findViewById(R.id.thurs_checkBox);
        CheckBox friday = (CheckBox) findViewById(R.id.fri_checkBox);
        CheckBox saturday = (CheckBox) findViewById(R.id.sat_checkBox);
        CheckBox sunday = (CheckBox) findViewById(R.id.sun_checkBox);

        monday.setOnCheckedChangeListener(this);
        tuesday.setOnCheckedChangeListener(this);
        wednesday.setOnCheckedChangeListener(this);
        thursday.setOnCheckedChangeListener(this);
        friday.setOnCheckedChangeListener(this);
        saturday.setOnCheckedChangeListener(this);
        sunday.setOnCheckedChangeListener(this);


    }

    public void setButton (View view){
        String result = getDaysString();
        Log.i("Set Button:", "Clicked");
        Log.i("Number of Days", ""+days.size());
        if(result == "") {
            Toast.makeText(this, "Please select at least one day to repeat.", Toast.LENGTH_SHORT).show();
            Log.i("Set Button:", "In If");
        }
        else {
            Log.i("Set Button:", "Finishing activity.");
            Intent returnIntent = new Intent();
            returnIntent.putExtra("result", result);
            returnIntent.putExtra("num", days.size());
            setResult(Activity.RESULT_OK, returnIntent);
            finish();
        }
    }

    private String getDaysString() {
        String res ="";
        for(int i=0;i<days.size();i++){
            res = res + days.get(i) + " ";
        }
        Log.i("getDaysString result:", res);
        return res;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch(buttonView.getId()){
            case R.id.mon_checkBox:
                if(isChecked){
                    days.add("M");
                }
                else if (days.contains("M")) {
                    days.remove("M");
                }
                break;

            case R.id.tues_checkBox:
                if(isChecked){
                    days.add("T");
                }
                else if (days.contains("T")) {
                    days.remove("T");
                }
                break;

            case R.id.wed_checkBox:
                if(isChecked){
                    days.add("W");
                }
                else if (days.contains("W")) {
                    days.remove("W");
                }
                break;

            case R.id.thurs_checkBox:
                if(isChecked){
                    days.add("Th");
                }
                else if (days.contains("Th")) {
                    days.remove("Th");
                }
                break;

            case R.id.fri_checkBox:
                if(isChecked){
                    days.add("F");
                }
                else if (days.contains("F")) {
                    days.remove("F");
                }
                break;

            case R.id.sat_checkBox:
                if(isChecked){
                    days.add("S");
                }
                else if (days.contains("S")) {
                    days.remove("S");
                }
                break;

            case R.id.sun_checkBox:
                if(isChecked){
                    days.add("Su");
                }
                else if (days.contains("Su")) {
                    days.remove("Su");
                }
                break;
        }
        Log.i("Days:", days.toString());
    }

}

