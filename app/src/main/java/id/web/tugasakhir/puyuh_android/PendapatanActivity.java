package id.web.tugasakhir.puyuh_android;

import androidx.appcompat.app.AppCompatActivity;
import id.web.tugasakhir.puyuh_android.RestAPI.ApiClient;
import id.web.tugasakhir.puyuh_android.Service.PendapatanService;
import id.web.tugasakhir.puyuh_android.model.PendapatanData;
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

public class PendapatanActivity extends AppCompatActivity {
    private String tanggal;
    private EditText editTelur, editHarga;
    private TextView textTotal, textDate;
    private Button btnSubmitPendapatan;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendapatan);
        Date today = new Date();
        editTelur = findViewById(R.id.edit_telur);
        editHarga = findViewById(R.id.edit_harga);
        textDate = findViewById(R.id.textDate);
        textTotal = findViewById(R.id.textTotal);
        textDate.setText(today+ "");
        btnSubmitPendapatan = findViewById(R.id.btn_submitPendapatan);

        btnSubmitPendapatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });
    }

    private void sendData() {
        String tanggal = dateFormat.format(date);
        String jmlTelur = editTelur.getText().toString().trim();
        String jmlHarga = editHarga.getText().toString().trim();
        String totalHarga = Integer.parseInt(jmlTelur) * Integer.parseInt(jmlHarga) + "";
        textTotal.setText(totalHarga);

        String idUser = 1 + "";

        PendapatanService pendapatanService = ApiClient.getRetrofitInstance().create(PendapatanService.class);
        Call<PendapatanData> call = pendapatanService.addPendapatan(
                idUser,
                tanggal,
                jmlTelur,
                jmlHarga,
                totalHarga
        );
        call.enqueue(new Callback<PendapatanData>() {
            @Override
            public void onResponse(Call<PendapatanData> call, Response<PendapatanData> response) {
                if (response.isSuccessful()){
                    Toast.makeText(PendapatanActivity.this, "berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PendapatanData> call, Throwable t) {
                Toast.makeText(PendapatanActivity.this, "Gagal ditambahkan", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
