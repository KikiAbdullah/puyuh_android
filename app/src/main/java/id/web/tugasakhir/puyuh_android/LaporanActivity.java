package id.web.tugasakhir.puyuh_android;

import androidx.appcompat.app.AppCompatActivity;
import id.web.tugasakhir.puyuh_android.RestAPI.ApiClient;
import id.web.tugasakhir.puyuh_android.Service.LaporanService;
import id.web.tugasakhir.puyuh_android.model.LaporanData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LaporanActivity extends AppCompatActivity {
    private EditText editKandang, editTelur, editKematian;
    private TextView textDate;
    private Button btnSubmitLaporan;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan);
        Date today = new Date();
        editKandang = findViewById(R.id.edit_kandang);
        editTelur = findViewById(R.id.edit_laporanTelur);
        editKematian = findViewById(R.id.edit_laporanKematian);
        textDate = findViewById(R.id.textTanggalLaporan);
        textDate.setText(today+"");
        btnSubmitLaporan = findViewById(R.id.btn_submitLaporan);

        btnSubmitLaporan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });
    }

    private void sendData(){
        String tanggal = dateFormat.format(date);
        String noKandang = editKandang.getText().toString().trim();
        String jmlTelur = editTelur.getText().toString().trim();
        String jmlKematian = editKematian.getText().toString().trim();
        String idUser = 1+"";

        System.out.println(tanggal);
        System.out.println(noKandang);
        System.out.println(jmlTelur);
        System.out.println(jmlKematian);
        System.out.println(idUser);

        LaporanService laporanService = ApiClient.getRetrofitInstance().create(LaporanService.class);
        Call<LaporanData> callLaporan = laporanService.addLaporan(
                idUser,
                noKandang,
                tanggal,
                jmlTelur,
                jmlKematian
        );
        callLaporan.enqueue(new Callback<LaporanData>() {
            @Override
            public void onResponse(Call<LaporanData> call, Response<LaporanData> response) {
                if (response.isSuccessful()){
                    Toast.makeText(LaporanActivity.this, "berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LaporanData> call, Throwable t) {
                Toast.makeText(LaporanActivity.this, "Gagal ditambahkan", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
