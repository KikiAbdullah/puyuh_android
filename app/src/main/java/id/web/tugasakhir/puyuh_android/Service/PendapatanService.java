package id.web.tugasakhir.puyuh_android.Service;

import id.web.tugasakhir.puyuh_android.model.PendapatanData;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PendapatanService {
    @FormUrlEncoded
    @POST("pendapatanHarian")
    Call<PendapatanData> addPendapatan(
//            @Field("id_user") String idUser,
            @Field("tanggal") String tanggal,
            @Field("harga") String harga,
            @Field("jumlah") String jumlah,
            @Field("total") String total
//            @Field("created_at") String createdAt,
//            @Field("updated_at") String updatedAt
    );

}
