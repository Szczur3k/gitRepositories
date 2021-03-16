package pl.mateuszlukaszczyk.gitRepositories.services.dto;

import org.json.JSONArray;
import org.json.JSONObject;
import pl.mateuszlukaszczyk.gitRepositories.models.GitRepository;
import pl.mateuszlukaszczyk.gitRepositories.models.GitResponse;

import java.util.List;

public class GitChangerJson {

    public static GitRepository changeJSONObjectToGitRepo(JSONObject jsonObject) {
        return GitRepository.builder()
                .fullName(jsonObject.getString("full_name"))
                .description(jsonObject.getString("description"))
                .cloneUrl(jsonObject.getString("clone_url"))
                .createdAt(jsonObject.getString("created_at"))
                .build();
    }


    public static GitResponse changeJSONObjectToGitResponse(JSONObject jsonObject) {
        return GitResponse.builder()
                .id(jsonObject.getInt("id"))
                .login(jsonObject.getString("login"))
                .createdAt(jsonObject.getString("created_at"))
                .updatedAt(jsonObject.getString("updated_at"))
                .userURLGitHub(jsonObject.getString("html_url"))
                .userURLRepo(jsonObject.getString("repos_url"))
                .build();
    }


    public static List<GitRepository> changerJSONArrayToGitRepositoryList(JSONArray jsonArray) {
        List<GitRepository> gitRepositoryList = null;
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonobject = jsonArray.getJSONObject(i);
            String fullName = jsonobject.getString("full_name");
            String description = jsonobject.getString("description");
            String cloneUrl = jsonobject.getString("clone_url");
            String createdAt = jsonobject.getString("created_at");
            GitRepository gitRepository = GitRepository.builder()
                    .fullName(fullName)
                    .description(description)
                    .cloneUrl(cloneUrl)
                    .createdAt(createdAt)
                    .build();
            if (gitRepositoryList != null) {
                gitRepositoryList.add(gitRepository);
            }
        }
        return gitRepositoryList;
    }

}
