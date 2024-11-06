package br.com.fabriciocurvello.appdiariohumorroom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class RegistroAdapter extends ListAdapter<RegistroDeHumor, RegistroAdapter.RegistroViewHolder> {

    protected RegistroAdapter(){
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public RegistroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_registro, parent, false);
        return new RegistroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RegistroViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    class RegistroViewHolder extends RecyclerView.ViewHolder {
        private ImageView imvSmile;
        private TextView tvData;
        private TextView tvMotivo;

        public RegistroViewHolder(@NonNull View itemView) {
            super(itemView);
            imvSmile = itemView.findViewById(R.id.adapter_registro_imv_smile);
            tvData = itemView.findViewById(R.id.adapter_registro_tv_data);
            tvMotivo = itemView.findViewById(R.id.adapter_registro_tv_motivo);
        }

        public void bind(RegistroDeHumor registro) {
            imvSmile.setImageResource(obterImagemSmile(registro.getHumor()));
            tvData.setText(registro.getData().toString());
            tvMotivo.setText(registro.getMotivo() != null ? registro.getMotivo() : "Sem motivo");
        }

        private int obterImagemSmile(int humor) {
            switch (humor) {
                case 1: return R.drawable.smile01;
                case 2: return R.drawable.smile02;
                case 3: return R.drawable.smile03;
                case 4: return R.drawable.smile04;
                case 5: return R.drawable.smile05;
                default: return R.drawable.smile03; // neutro
            }
        }
    } // fim da classe RegistroViewholder

    private static final DiffUtil.ItemCallback<RegistroDeHumor> DIFF_CALLBACK = new DiffUtil.ItemCallback<RegistroDeHumor>() {
        @Override
        public boolean areItemsTheSame(@NonNull RegistroDeHumor oldItem, @NonNull RegistroDeHumor newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull RegistroDeHumor oldItem, @NonNull RegistroDeHumor newItem) {
            return oldItem.equals(newItem);
        }
    };

} // fim da classe RegistroAdapter


