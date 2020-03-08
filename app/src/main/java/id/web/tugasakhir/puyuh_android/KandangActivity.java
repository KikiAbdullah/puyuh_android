package id.web.tugasakhir.puyuh_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.web.tugasakhir.puyuh_android.Adapter.KandangAdapter;
import id.web.tugasakhir.puyuh_android.RestAPI.ApiClient;
import id.web.tugasakhir.puyuh_android.Service.KandangService;
import id.web.tugasakhir.puyuh_android.model.KandangData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;


public class KandangActivity extends AppCompatActivity {
    private KandangAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kandang);

        progressDoalog = new ProgressDialog(KandangActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        /*Create handle for the RetrofitInstance interface*/
        KandangService kandangService = ApiClient.getRetrofitInstance().create(KandangService.class);
        Call<List<KandangData>> call = kandangService.getAllKandang();
        call.enqueue(new Callback<List<KandangData>>() {
            @Override
            public void onResponse(Call<List<KandangData>> call, Response<List<KandangData>> response) {
                progressDoalog.dismiss();
                generateDataList(response.body());

            }

            @Override
            public void onFailure(Call<List<KandangData>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(KandangActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<KandangData> kandangDataList){
        recyclerView = findViewById(R.id.kandangRecyclerView);
        adapter = new KandangAdapter(kandangDataList,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
