package id.web.tugasakhir.puyuh_android.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class KandangData {
    @SerializedName("id")
    @Expose
    private Integer idKandang;
    @SerializedName("jumlah_ternak")
    @Expose
    private Integer jumlahTernak;

    public KandangData() {
    }

    public KandangData(Integer idKandang, Integer jumlahTernak) {
        this.idKandang = idKandang;
        this.jumlahTernak = jumlahTernak;
    }

    public Integer getIdKandang() {
        return idKandang;
    }

    public void setIdKandang(Integer idKandang) {
        this.idKandang = idKandang;
    }

    public Integer getJumlahTernak() {
        return jumlahTernak;
    }

    public void setJumlahTernak(Integer jumlahTernak) {
        this.jumlahTernak = jumlahTernak;
    }
}
