package com.bcoelho.netflixremake;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bcoelho.netflixremake.model.Category;
import com.bcoelho.netflixremake.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private MainAdapter mainAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    RecyclerView recyclerView = findViewById(R.id.recycler_view_main);

    List<Category> categories = new ArrayList<>();

    for (int j = 0; j < 10; j++) {
      Category category = new Category();
      category.setName("cat " + j);

      List<Movie> movies = new ArrayList<>();

      for (int i = 0; i < 30; i++) {
        Movie movie = new Movie();
        movie.setCoverUrl(R.drawable.movie);
        movies.add(movie);
      }

      category.setMovies(movies);
      categories.add(category);
    }

    mainAdapter = new MainAdapter(categories);
    recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    recyclerView.setAdapter(mainAdapter);
  }

  private static class MovieHolder extends RecyclerView.ViewHolder {

    private final ImageView imageViewCover;

    public MovieHolder(@NonNull View itemView) {
      super(itemView);
      imageViewCover = itemView.findViewById(R.id.image_view_cover);
    }
  }

  private  static class CategoryHolder extends RecyclerView.ViewHolder {
    TextView textViewTitle;
    RecyclerView recyclerViewMovie;

    public CategoryHolder(@NonNull View itemView) {
      super(itemView);
      textViewTitle = itemView.findViewById(R.id.text_view_title);
      recyclerViewMovie = itemView.findViewById(R.id.recycler_view_movie);
    }
  }

  private class MainAdapter extends RecyclerView.Adapter<CategoryHolder> {
    private final List<Category> categories;

    public MainAdapter(List<Category> categories) {
      this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      return new CategoryHolder(getLayoutInflater().inflate(R.layout.category_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
      Category category = categories.get(position);
      holder.textViewTitle.setText(category.getName());
      holder.recyclerViewMovie.setAdapter(new MovieAdapter(category.getMovies()));
      holder.recyclerViewMovie.setLayoutManager(new LinearLayoutManager(getBaseContext(), RecyclerView.HORIZONTAL, false));
    }

    @Override
    public int getItemCount() {
      return categories.size();
    }
  }

  private class MovieAdapter extends RecyclerView.Adapter<MovieHolder> {

    private final List<Movie> movies;

    public MovieAdapter(List<Movie> movies) {
      this.movies = movies;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      return new MovieHolder(getLayoutInflater().inflate(R.layout.movie_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
      Movie movie = movies.get(position);
      holder.imageViewCover.setImageResource(movie.getCoverUrl());
    }

    @Override
    public int getItemCount() {
      return movies.size();
    }
  }

}