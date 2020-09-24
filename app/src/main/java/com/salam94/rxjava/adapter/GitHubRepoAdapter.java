package com.salam94.rxjava.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.salam94.rxjava.R;
import com.salam94.rxjava.model.GitHubRepo;

import java.util.ArrayList;
import java.util.List;

import static com.salam94.rxjava.adapter.GitHubRepoAdapter.*;

public class GitHubRepoAdapter extends RecyclerView.Adapter<GitHubRepoViewHolder>{

    private ArrayList<GitHubRepo> gitHubRepos = new ArrayList<>();

    @NonNull
    @Override
    public GitHubRepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_github_repo, parent, false);

        return new GitHubRepoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GitHubRepoViewHolder holder, int position) {

        holder.setGitHubRepo(gitHubRepos.get(position));

    }

    @Override public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return gitHubRepos.size();
    }

    public void setGitHubRepos(@Nullable List<GitHubRepo> repos) {
        if (repos == null) {
            return;
        }
        gitHubRepos.addAll(repos);
        notifyDataSetChanged();
    }

    public static class GitHubRepoViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textRepoName;
        public TextView textRepoDescription;
        public TextView textLanguage;
        public TextView textStars;

        public GitHubRepoViewHolder(@NonNull View view) {
            super(view);

            textRepoName = (TextView) view.findViewById(R.id.text_repo_name);
            textRepoDescription = (TextView) view.findViewById(R.id.text_repo_description);
            textLanguage = (TextView) view.findViewById(R.id.text_language);
            textStars = (TextView) view.findViewById(R.id.text_stars);
        }

        public void setGitHubRepo(GitHubRepo gitHubRepo) {
            textRepoName.setText(gitHubRepo.name);
            textRepoDescription.setText(gitHubRepo.description);
            textLanguage.setText("Language: " + gitHubRepo.language);
            textStars.setText("Stars: " + gitHubRepo.stargazersCount);
        }
    }
}
