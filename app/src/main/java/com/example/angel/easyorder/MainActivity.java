package com.example.angel.easyorder;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.example.angel.easyorder.Categoria.CategoriaActivity;
import com.example.angel.easyorder.Producto.ProductoActivity;
import com.example.angel.easyorder.shopping_cart.Shopping_Cart;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView myScanner;

    //hayrogay
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void btnEscanear(View v) {
        myScanner = new ZXingScannerView(this);
        setContentView(myScanner);
        myScanner.setResultHandler(this);
        myScanner.startCamera();

    }


    @Override
    public void handleResult(Result result) {
        /*Log.v("HandleResult",result.getText());
        AlertDialog.Builder builer=new AlertDialog.Builder(this);
        builer.setTitle("Resultado del scaner");
        builer.setMessage(result.getText());
        AlertDialog alerta=builer.create();
        alerta.show();
        myScanner.stopCamera();*/


        View v = new View(this);

        Bundle Pa = new Bundle();
        Pa.putString("vResultado", result.getText());

        Intent Wii = new Intent(v.getContext(), CategoriaActivity.class);
        Wii.putExtras(Pa);
        v.getContext().startActivity(Wii);


        //myScanner.resumeCameraPreview(this);


    }
}
