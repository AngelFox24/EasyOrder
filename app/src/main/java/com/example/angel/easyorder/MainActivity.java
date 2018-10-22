package com.example.angel.easyorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.barcode.Barcode;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler{
    Button btnEscanear;
    TextView lblTextoEscaneado;
    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnEscanear=findViewById(R.id.btnEscanear);
        lblTextoEscaneado =findViewById(R.id.lblTextoEscaneado);
    }
    public void Escanear(View v){
        mScannerView=new ZXingScannerView(this);
        setContentView(mScannerView);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
        //gola
    }

    @Override
    public void handleResult(Result result) {
        lblTextoEscaneado.setText(result.getText());
        Toast toast = Toast.makeText(getApplicationContext(), result.getText(), Toast.LENGTH_LONG);
        toast.show();
        mScannerView.resumeCameraPreview(this);

    }
}
