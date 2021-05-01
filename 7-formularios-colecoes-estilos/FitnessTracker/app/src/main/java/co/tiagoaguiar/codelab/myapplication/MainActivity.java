package co.tiagoaguiar.codelab.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
	private View btnImc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnImc = findViewById(R.id.btn_imc);

		// obj interno que será executado quando eu clicar no botão
		btnImc.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, ImcActivity.class);
				startActivity(intent);
			}
		});
	}
}