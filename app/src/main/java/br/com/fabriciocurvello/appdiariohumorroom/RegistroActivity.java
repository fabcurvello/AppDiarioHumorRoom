package br.com.fabriciocurvello.appdiariohumorroom;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import java.util.Date;
import java.util.concurrent.Executors;

public class RegistroActivity extends AppCompatActivity {

    private AppDatabase database;

    private RadioGroup rgHumor;
    private EditText etMotivo;
    private Button btSalvar;
    private TextView tvCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializa o banco de dados
        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "diario_humor_db").build();

        rgHumor = findViewById(R.id.registro_activity_rg_humor);
        etMotivo = findViewById(R.id.registro_activity_et_motivo);
        btSalvar = findViewById(R.id.registro_activity_bt_salvar);
        tvCancelar = findViewById(R.id.registro_activity_tv_cancelar);

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarRegistro();
            }
        });

        tvCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    } // fim do onCreate()

    private void salvarRegistro() {

        int humorSelecionado = obterHumorSelecionado();
        String motivo = etMotivo.getText().toString();

        // Cria um novo registro
        RegistroDeHumor registro = new RegistroDeHumor(new Date(), humorSelecionado, motivo);

        // Insere no banco de dados usando uma thread separada
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                database.registroDeHumorDao().inserirRegistro(registro);
                finish(); // fecha a tela após salvar
            }
        });
    }

    private int obterHumorSelecionado() {

        int idSelecionado = rgHumor.getCheckedRadioButtonId();

        if (idSelecionado == R.id.registro_activity_rb_muito_triste) {
            return 1;
        } else if (idSelecionado == R.id.registro_activity_rb_triste) {
            return 2;
        } else if (idSelecionado == R.id.registro_activity_rb_neutro) {
            return 3;
        } else if (idSelecionado == R.id.registro_activity_rb_feliz) {
            return 4;
        } else if (idSelecionado == R.id.registro_activity_rb_muito_feliz) {
            return 5;
        } else {
            return 3; // Valor padrão: neutro
        }
    }


}