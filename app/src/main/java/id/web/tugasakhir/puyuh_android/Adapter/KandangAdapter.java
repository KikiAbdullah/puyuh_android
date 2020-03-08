package id.web.tugasakhir.puyuh_android.Adapter;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import java.util.List;

        import androidx.recyclerview.widget.RecyclerView;
        import id.web.tugasakhir.puyuh_android.R;
        import id.web.tugasakhir.puyuh_android.model.KandangData;

public class KandangAdapter extends RecyclerView.Adapter<KandangAdapter.KandangViewHolder> {
    private List<KandangData> dataList;
    private Context context;

    public KandangAdapter(List<KandangData> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    class KandangViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextId, mTextJumlah;

        KandangViewHolder(View itemView) {
            super(itemView);
            mTextId = itemView.findViewById(R.id.textId);
            mTextJumlah = itemView.findViewById(R.id.textKandang);

        }
    }

    @Override
    public KandangViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        return new KandangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(KandangViewHolder holder, int position) {
        holder.mTextId.setText("No. Kandang = "+ dataList.get(position).getIdKandang() );
        holder.mTextJumlah.setText("Jumlah Ternak= "+ dataList.get(position).getJumlahTernak());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

