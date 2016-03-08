package edu.utep.cs.cs43330.burgercaloriecounter;

import android.app.Activity;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity{

    //TASK 1: Declare UI Objects to be referenced
    private RadioGroup pattyRG;
    private CheckBox prosciuttoCBX;
    private RadioGroup cheeseRG;
    private SeekBar sauceSBR;
    private TextView caloriesTV;

    // TASK 2: Declare Variables for Computing Calories
    private Burger burger;

    @Override
    protected void onCreate(Bundle savedInstanceStat){
        super.onCreate(savedInstanceStat);
        setContentView(R.layout.activity_main);

        //TASK 4: initialize UI Objects and Variables
        burger = new Burger();
        initialize();

        //TASK 5: Registe change listeners
        registerChangeListener();
    }

    private void registerChangeListener() {
        pattyRG.setOnCheckedChangeListener(foodListener);
        prosciuttoCBX.setOnClickListener(baconListener);
        cheeseRG.setOnCheckedChangeListener(foodListener);
        sauceSBR.setOnSeekBarChangeListener(sauceListener);
    }

    private void initialize() {
        //TASkK 5: Get Reference to each of the UI Components
        pattyRG = (RadioGroup) findViewById(R.id.radioGroup1);
        prosciuttoCBX = (CheckBox) findViewById(R.id.checkbox1);
        cheeseRG = (RadioGroup) findViewById(R.id.radioGroup2);
        sauceSBR = (SeekBar) findViewById(R.id.seekBar1);
        caloriesTV = (TextView) findViewById(R.id.textView2);

        displayCalories();
    }

    private OnCheckedChangeListener foodListener = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup rbGroup, int radioId) {
            switch (radioId){
                case 0x7f080002: //Beef Patty
                    burger.setmPattyCalories(Burger.BEEF);
                    break;
                case 0x7f080003: //Lamb Patty
                    burger.setmPattyCalories(Burger.LAMB);
                    break;
                case 0x7f080004: //Ostrich Patty
                    burger.setmPattyCalories(Burger.OSTRICH);
                    break;
                case 0x7f080007: //Asiago Cheese
                    burger.setmCheeseCalories(Burger.ASIAGO);
                    break;
                case 0x7f080008: //Creme Fraiche
                    burger.setmCheeseCalories(Burger.CREME_FRAICHE);
                    break;
            }
            displayCalories();
        }
    };

    private OnClickListener baconListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if(((CheckBox) v).isChecked())
            burger.setProsciuttoCalories(Burger.PROSCIUTTO);
            else
                burger.clearProsciuttoCalories();
            displayCalories();
        }
    };

    private SeekBar.OnSeekBarChangeListener sauceListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            burger.setmSauceCalories(seekBar.getProgress());
            displayCalories();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private void displayCalories(){
        //Construct an output string and display in the textview
        String calorieText = "Calories: " + burger.getTotalCaolries();
        caloriesTV.setText(calorieText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //Inflate the menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        // Handle action bar item clicks here. the action bar will
        // automatically handle clicks on the home/up button, so long
        // as you specify a parent activity in AndroidManifest.xml
        int id = item.getItemId();
        if(id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
