package co.tiagoaguiar.codelab.myapplication;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
	private RecyclerView rvMain;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		rvMain = findViewById(R.id.main_rv);

		// Primeiro: definir o comportamento de exibicao do layout da recyclerView
			// ela pode ser do tipo: mosaic, grid ou linear (horizontal ou vertical)
		rvMain.setLayoutManager(new LinearLayoutManager(this));

		MainAdapter adapter = new MainAdapter();
		rvMain.setAdapter(adapter);

	}

	private class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

		@NonNull
		@Override
		public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
			return new MainViewHolder(getLayoutInflater().inflate(R.layout.main_item, parent, false));
		}

		@Override
		public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
			holder.bind(position);
		}

		@Override
		public int getItemCount() {
			return 15;
		}
	}

	// eh a view do item que aparece no recyclerView
	private class MainViewHolder extends RecyclerView.ViewHolder {

		public MainViewHolder(@NonNull View itemView) {
			super(itemView);
		}

		public void bind(int position) {
			TextView textTest = itemView.findViewById(R.id.textView_test);
			textTest.setText("Teste de rolagem " + position);
		}
	}
}