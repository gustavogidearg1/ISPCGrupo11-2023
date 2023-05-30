package com.planidear.appconvert;
//Fuentas login:
//https://youtu.be/HagZBlNevLQ
//https://www.youtube.com/watch?v=3dmszck6D6w
//https://es.stackoverflow.com/questions/355660/resultado-de-response-isempty-siempre-da-el-mismo-resultado
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText email;
    EditText password;
    Button loginButton;
    String url1 = "https://planidear.com.ar/ConexionAndroid/validar_usuario.php";

    String message;
    public static final String EXTRA_MESSAGE = "com.planidear.appconvert.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarUsuario(url1);
            }
        });

    }

    private void validarUsuario(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String> () {
            @Override
            public void onResponse(String response){
                if(response.equals("ingresaste")){
                    Toast.makeText(MainActivity.this, "ingresaste", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), PrincipalActivity.class);
                    startActivity(intent);
                    EditText editText = (EditText) findViewById(R.id.username);
                    String message = editText.getText().toString();
                    intent.putExtra(EXTRA_MESSAGE, message);
                    startActivity(intent);

                }else{
                    Toast.makeText(MainActivity.this, "Error al querer ingresar", Toast.LENGTH_LONG).show();
                   /* Intent intent = new Intent(getApplicationContext(), PrincipalActivity.class);
                    startActivity(intent);*/
                }

            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
            }

        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put( "email", email.getText().toString().trim());
                params.put( "password", password.getText().toString().trim());
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(stringRequest);
    }
}