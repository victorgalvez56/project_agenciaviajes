package com.example.project_agenciaviajes.Menu;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.project_agenciaviajes.R;
import com.example.project_agenciaviajes.model.User;
import com.example.project_agenciaviajes.model.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PerfilFragment extends Fragment {
    JsonObjectRequest jsonObjectRequest;
    StringRequest stringRequest;//SE MODIFICA
    Bitmap bitmap;
    ImageView campoImagen;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_perfil, container, false);

        MostrarDatosUser();
        campoImagen = (ImageView) vista.findViewById(R.id.img_perfil);


        return vista;
    }

    private void MostrarDatosUser() {


        String url = "http://138.197.76.0//WebService/consultaimg.php?idUser=1";

        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                User miUsuario = new User();

                JSONArray json = response.optJSONArray("datos");
                JSONObject jsonObject = null;

                try {
                    jsonObject = json.getJSONObject(0);
                    miUsuario.setIdUser(jsonObject.optInt("idUser"));
                    miUsuario.setEmailUser(jsonObject.optString("emailUser"));
                    miUsuario.setPasswUser(jsonObject.optString("passwUser"));
                    miUsuario.setNameUser(jsonObject.optString("nameUser"));
                    miUsuario.setDniUser(jsonObject.optInt("dniUser"));
                    miUsuario.setTelefUser(jsonObject.optInt("telefUser"));
                    miUsuario.setUrl_imagen(jsonObject.optString("url_imagen"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                /*etiNombre.setText(miUsuario.getNombre());//SE MODIFICA
                etiProfesion.setText(miUsuario.getProfesion());//SE MODIFICA
                */

                String urlImagen = "http://138.197.76.0/WebService/" + miUsuario.getUrl_imagen();

                //Toast.makeText(getContext(), "url "+urlImagen, Toast.LENGTH_LONG).show();
                ConvertirImagen(urlImagen);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(getContext(), "No se puede conectar " + error.toString(), Toast.LENGTH_LONG).show();
                System.out.println();
                Log.d("ERROR: ", error.toString());
            }
        });

        // request.add(jsonObjectRequest);
        VolleySingleton.getIntanciaVolley(getContext()).addToRequestQueue(jsonObjectRequest);
    }

    private void ConvertirImagen(String urlImagen) {
        urlImagen = urlImagen.replace(" ", "%20");
        //Toast.makeText(getContext(), "URL " + urlImagen, Toast.LENGTH_LONG).show();

        ImageRequest imageRequest = new ImageRequest(urlImagen, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                bitmap = response;//SE MODIFICA
                campoImagen.setImageBitmap(response);
            }
        }, 0, 0, ImageView.ScaleType.CENTER, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("ERROR IMAGEN", "Response -> " + error);
            }
        });
        //  request.add(imageRequest);
        VolleySingleton.getIntanciaVolley(getContext()).addToRequestQueue(imageRequest);
    }
}
