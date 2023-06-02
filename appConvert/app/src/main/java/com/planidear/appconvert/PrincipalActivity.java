package com.planidear.appconvert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Obtenga el intent que inició esta actividad y extraiga la cadena
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        // Capture el TextView y establezca la cadena como su texto
        TextView textView = findViewById(R.id.idTxtNombre);
        textView.setText(message);


    }
  public void abrirLongitud(View view){
    Intent intent = new Intent(getApplicationContext(), LongitudActivity.class);
    startActivity(intent);

  }


}