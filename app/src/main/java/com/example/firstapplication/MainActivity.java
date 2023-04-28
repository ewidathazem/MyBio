package com.example.firstapplication;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView bio;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bio = findViewById(R.id.viewBio);
        TextView hobbies = findViewById(R.id.myHobbiesText);
        bio.setMovementMethod(new ScrollingMovementMethod());
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setColor(Color.WHITE);
        shape.setStroke(2, Color.BLACK);
        shape.setCornerRadius(10);
        bio.setBackground(shape);
        hobbies.setBackground(shape);
        add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
// Set the background drawable to a box shape

                TextView hobbies;
                hobbies = findViewById(R.id.myHobbiesText);
                hobbies.setVisibility(View.VISIBLE);
                EditText myHobbies;
                myHobbies = findViewById(R.id.myHobbeis);
                hobbies.setText(myHobbies.getText());
                myHobbies.setText("");

                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

                // Get a reference to the currently focused input field
                View focusedView = getCurrentFocus();

                // Hide the keyboard
                if (focusedView != null) {
                    inputMethodManager.hideSoftInputFromWindow(focusedView.getWindowToken(), 0);
                }

            }
        });

    }
}