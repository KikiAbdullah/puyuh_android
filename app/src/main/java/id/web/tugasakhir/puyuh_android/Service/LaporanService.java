package id.web.tugasakhir.puyuh_android.Service;

import id.web.tugasakhir.puyuh_android.model.LaporanData;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LaporanService {
    @FormUrlEncoded
    @POST("laporanHarian")
    Call<LaporanData> addLaporan(
            @Field("id_user") String idUser,
            @Field("id_kandang") String noKandang,
            @Field("tanggal") String tanggal,
            @Field("jumlah_telur") String jmlTelur,
            @Field("jumlah_kematian") String jmlKematian
    );
}
