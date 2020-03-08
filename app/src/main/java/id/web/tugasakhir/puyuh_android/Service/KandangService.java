package id.web.tugasakhir.puyuh_android.Service;
import java.util.List;

import id.web.tugasakhir.puyuh_android.model.KandangData;
import retrofit2.Call;
import retrofit2.http.GET;

public interface KandangService {
    @GET("kandang")
    Call<List<KandangData>> getAllKandang();
}
