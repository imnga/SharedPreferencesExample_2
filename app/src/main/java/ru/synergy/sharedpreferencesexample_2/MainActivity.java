package ru.synergy.sharedpreferencesexample_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et;
    Button btn_save, btn_load;
    SharedPreferences sharedPreferences;
    final String SAVED_TEXT = "saved text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.etText);
        btn_save = (Button) findViewById(R.id.btn_save);
        btn_load = (Button) findViewById(R.id.btn_load);

        btn_save.setOnClickListener(this);
        btn_load.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
     switch (v.getId()){
         case R.id.btn_save:
             saveText();
             break;
         case R.id.btn_load:
             loadText();
             break;
         default:
             break;

     }
    }

    private void saveText() {
        sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed  = sharedPreferences.edit();
        ed.putString(SAVED_TEXT,et.getText().toString());
        ed.commit();
        Toast.makeText(this, "Text saved ", Toast.LENGTH_LONG).show();
    }

    private void loadText() {
        sharedPreferences = getPreferences(MODE_PRIVATE);
        String savedText = sharedPreferences.getString(SAVED_TEXT, "nothing was saved in Shared Preferences");
        et.setText(savedText);
        Toast.makeText(this, "Text loaded", Toast.LENGTH_LONG).show();
    }
}