package id.web.tugasakhir.puyuh_android;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    Button btnLaporan, btnPendapatan, btnData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //toLaporan
        btnLaporan = findViewById(R.id.btn_laporan);
        btnLaporan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toLaporan = new Intent(MenuActivity.this, LaporanActivity.class);
                startActivity(toLaporan);
            }
        });

        //toPendapatan
        btnPendapatan = findViewById(R.id.btn_pendapatan);
        btnPendapatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toPendapatan = new Intent(MenuActivity.this, PendapatanActivity.class);
                startActivity(toPendapatan);
            }
        });
//toData
        btnData = findViewById(R.id.btn_data);
        btnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toData = new Intent(MenuActivity.this, KandangActivity.class);
                startActivity(toData);
        }
        });
    }

}
