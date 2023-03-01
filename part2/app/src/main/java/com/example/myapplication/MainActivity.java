package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageButton button;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        ratingBar =findViewById(R.id.ratingBar);

        button.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View v) { // Perform action on clicks
            Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show(); }
        });
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean
                    fromUser) {
                Toast.makeText(MainActivity.this, "New Rating: " + rating,
                        Toast.LENGTH_SHORT).show();
            } });

    }
    public void onCheckboxClicked(View view) {
        // Is the button now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.cb_mobile:
                if (checked)
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.select) + " " + getResources().getString(R.string.cb_mobile), Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.cb_mobile) + " " + getResources().getString(R.string.unselected),
                            Toast.LENGTH_SHORT).show();
                break;
            case R.id.cb_web:
                if (checked)
                    Toast.makeText(MainActivity.this, "You selected Web",
                            Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Web Unselected", Toast.LENGTH_SHORT).show();
                break;
        }

    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_fun:
                if (checked)
                    Toast.makeText(MainActivity.this, "Fun",
                            Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_boring:
                if (checked)
                    Toast.makeText(MainActivity.this, "Boring",Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
