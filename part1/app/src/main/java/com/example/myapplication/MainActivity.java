package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner colorSpinner;
    private EditText colorEditText;
    private TextView colorTextView1, colorTextView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorSpinner = findViewById(R.id.color_spinner);
        colorTextView1 = findViewById(R.id.colorTextView1);
        colorTextView2 = findViewById(R.id.colorTextView2);
        colorEditText = findViewById(R.id.color_editText);

    }
    public void onClick(View v){
        //call specific array from strings.xml
        String[] color = getResources().getStringArray(R.array.color_list);

        //get the position from array
        int colorId = colorSpinner.getSelectedItemPosition();

        //get edittext input
        String input =colorEditText.getText().toString();

        switch(colorId) {
            case 0:
                colorTextView1.setBackgroundColor(getResources().getColor(R.color.red));
                break;
            case 1:
                colorTextView1.setBackgroundColor(getResources().getColor(R.color.blue));
                break;
            case 2:
                colorTextView1.setBackgroundColor(getResources().getColor(R.color.green));
                break;
            default:
                break;
        }
        colorTextView1.setText(color[colorId]);
//For EditText
        if(input.equals("Red")){
            colorTextView2.setBackgroundResource(R.color.red);
            colorTextView2.setText(input);
        }else if(input.equals("Blue")){
            colorTextView2.setBackgroundColor(getResources().getColor(R.color.blue));
            colorTextView2.setText(input);
        }else if(input.equals("Green")){
            colorTextView2.setBackgroundColor(getResources().getColor(R.color.green));
            colorTextView2.setText(input);
        } else if(input.isEmpty()) {
            colorEditText.setError(getResources().getString(R.string.warning));
        }else {
            Toast.makeText(getApplicationContext(),getResources().getString(R.string.format),Toast.LENGTH_SHORT).show();
        }

    }

}
