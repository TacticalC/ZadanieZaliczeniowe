package com.example.elo32;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button btnGenerator = findViewById(R.id.Generator);
        EditText InpCount = findViewById(R.id.Count);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnGenerator.setOnClickListener(v->{
            int lenght = Integer.parseInt(InpCount.getText().toString());
            InpCount.setText(generate(lenght));

        });
        EditText InpName = findViewById(R.id.Name);
        EditText InpSurname = findViewById(R.id.Surname);
        Button btnAccept = findViewById(R.id.Accept);
        btnAccept.setOnClickListener(v->{
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Dane Pracownika");
        builder.setMessage("Imie: "+InpName.getText() +"\n"+
                "Nazwisko: "+ InpSurname.getText()+"\n"+
                "haslo: "+ InpCount.getText());
            builder.setNegativeButton("oki",(DialogInterface.OnClickListener)(dialog, which)->{
                dialog.cancel();
            });
            builder.show();
        });







    }



    public String  generate(int charNumber){


        CheckBox checkHeight = findViewById(R.id.Height);
        CheckBox checkNumbers = findViewById(R.id.Numbers);
        CheckBox checkSpecial = findViewById(R.id.Special);


        String password = "";
        String low = "qwertyuiopasdfghjklzxcvbnm";
        String high = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String number = "1234567890";
        String special = "!@#$%^&*()_+-=";
        Random random = new Random();
        int charNumberFinal = charNumber;
        StringBuilder sb = new StringBuilder();

        if(checkNumbers.isChecked()){
            charNumberFinal--;
        }
        if(checkHeight.isChecked()){
            charNumberFinal--;
        }
        if(checkSpecial.isChecked()){
            charNumberFinal--;
        }
        for(int i = 0; i<charNumberFinal;i++){
            sb.append(low.charAt(random.nextInt(low.length())));

        }
        if(checkNumbers.isChecked()){
            sb.append(number.charAt(random.nextInt(number.length())));

        }
        if(checkHeight.isChecked()){
            sb.append(high.charAt(random.nextInt(high.length())));

        }
        if(checkSpecial.isChecked()){
            sb.append(special.charAt(random.nextInt(special.length())));

        }


        password = sb.toString();
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("wygenerowane hasło");
        builder.setMessage(password);
        builder.setNegativeButton("ok",(DialogInterface.OnClickListener)(dialog, which)->{
            dialog.cancel();
        });
        builder.show();
        return password;
    };


}

