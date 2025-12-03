package com.example.elo32;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    EditText InpName = findViewById(R.id.Name);
    EditText InpSurname = findViewById(R.id.Surname);
    EditText InpCount = findViewById(R.id.Count);
    CheckBox checkHeight = findViewById(R.id.Height);
    CheckBox checkNumbers = findViewById(R.id.Numbers);
    CheckBox checkSpecial = findViewById(R.id.Special);
    Button btnGenerator = findViewById(R.id.Generator);
    Button btnAccept = findViewById(R.id.Accept);
    public String  generate(int charNumber){
        String password = "";
        String low = "qwertyuiopasdfghjklzxcvbnm";
        String high = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String number = "1234567890";
        String special = "!@#$%^&*()_+-=";
        return password;
    };

}