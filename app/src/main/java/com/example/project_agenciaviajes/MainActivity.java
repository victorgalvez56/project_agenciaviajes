package com.example.project_agenciaviajes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.project_agenciaviajes.model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private EditText emailUser;
    private EditText passwUser;
    private Button accedUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailUser = (EditText) findViewById(R.id.editTextEmail);
        passwUser = (EditText) findViewById(R.id.editTextPassword);
        accedUser = (Button) findViewById(R.id.buttonLogin);

        accedUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarSesion("http://138.197.76.0//WebService/login.php?emailUser=" + emailUser.getText().toString() + "&passwUser=" + passwUser.getText().toString());
            }
        });
    }

    private void iniciarSesion(String url) {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        User usuario = new User();
                        JSONArray jsonArray = response.optJSONArray("datos");
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = jsonArray.getJSONObject(0);
                            usuario.setIdUser(jsonObject.optInt("idUser"));
                            usuario.setNameUser(jsonObject.optString("nameUser"));
                            usuario.setEmailUser(jsonObject.optString("emailUser"));
                            usuario.setPasswUser(jsonObject.optString("passwUser"));
                            usuario.setDniUser(jsonObject.optInt("dniUser"));
                            usuario.setTelefUser(jsonObject.optInt("telefUser"));
                            usuario.setUrl_imagen(jsonObject.optString("url_imagen"));

                            if (usuario.getEmailUser().equals(jsonObject.optString("emailUser")) && usuario.getPasswUser().equals(jsonObject.optString("passwUser"))) {
                                Toast.makeText(MainActivity.this, "Acceso Concedido", Toast.LENGTH_SHORT).show();
                                Intent intencion = new Intent(MainActivity.this, PreviousActivity.class);
                                startActivity(intencion);
                            } else {
                                Toast.makeText(MainActivity.this, "Acceso Denegado", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Log.d("Response", response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Error de Servidor", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        queue.add(getRequest);
    }
}
