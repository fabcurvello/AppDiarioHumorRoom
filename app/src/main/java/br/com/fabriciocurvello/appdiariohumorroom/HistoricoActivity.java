package br.com.fabriciocurvello.appdiariohumorroom;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;


import java.util.List;
import java.util.concurrent.Executors;

public class HistoricoActivity extends AppCompatActivity  {

    private AppDatabase database;
    private RegistroAdapter adapter;

    private RecyclerView rvHistorico;
    private Button btVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_historico);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "diario_humor_db").build();
        adapter = new RegistroAdapter();

        btVoltar = findViewById(R.id.historico_activity_bt_voltar);

        rvHistorico = findViewById(R.id.historico_activity_rv_historico);
        rvHistorico.setLayoutManager(new LinearLayoutManager(this));
        rvHistorico.setAdapter(adapter);

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // Encerra a Activity
            }
        });

        carregarHistorico();

    } // fim do onCreate()

    private void carregarHistorico() {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                List<RegistroDeHumor> registros = database.registroDeHumorDao().listaRegistros();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.submitList(registros);
                    }
                });
            }
        });
    }
}