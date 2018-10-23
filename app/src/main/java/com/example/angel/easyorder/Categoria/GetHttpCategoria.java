package com.example.angel.easyorder.Categoria;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.List;

public class GetHttpCategoria extends AsyncTask<Void, Void, String> {
    private List<Categoria> httpList;
    private RecyclerView httpRecycler;
    private RecyclerView.Adapter httpAdapter;
    private Context httpContext;
    ProgressDialog progressDialog;

    public GetHttpCategoria(List<Categoria> httpList, RecyclerView httpRecycler,
                            RecyclerView.Adapter httpAdapter, Context httpContext) {
        this.httpList = httpList;
        this.httpRecycler = httpRecycler;
        this.httpAdapter = httpAdapter;
        this.httpContext = httpContext;
    }



    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(httpContext, "Descargando", "por favor espere...");
    }

    @Override
    protected String doInBackground(Void... params) {
        String result = null;
        try {
            String wsURL = "http://demos.hypersystemperu.com/php/wsLibro.php?num=5&format=json";
            URL url = new URL(wsURL);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            result = inputStreamToString(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private String inputStreamToString(InputStream in) {
        String rLine = "";
        StringBuilder answer = new StringBuilder();
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader rd = new BufferedReader(isr);
        try {
            while ((rLine = rd.readLine()) != null) {
                answer.append(rLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        progressDialog.dismiss();
        try {
            JSONObject jsonObject = new JSONObject(URLDecoder.decode(s, "UTF-8" ));
            JSONArray jsonArray = jsonObject.getJSONArray("libros");
            for (int i = 0; i < jsonArray.length(); i++) {
                String Titulo = jsonArray.getJSONObject(i).getString("cTitulo");
                String fotourl = jsonArray.getJSONObject(i).getString("cFotoUrl");
                this.httpList.add(new Categoria(Titulo, fotourl));
            }
            // Crear un nuevo adaptador
            httpAdapter = new CategoriaAdapter(this.httpList);
            httpRecycler.setAdapter(this.httpAdapter);

            String msg = String.valueOf(this.httpList.size()) + " registros";
            Toast.makeText(httpContext, msg, Toast.LENGTH_SHORT).show();
        } catch (JSONException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
