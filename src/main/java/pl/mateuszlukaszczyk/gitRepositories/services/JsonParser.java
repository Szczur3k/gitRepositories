package pl.mateuszlukaszczyk.gitRepositories.services;

import org.json.JSONArray;
import org.json.JSONObject;
import pl.mateuszlukaszczyk.gitRepositories.models.GitRepository;
import pl.mateuszlukaszczyk.gitRepositories.models.GitResponse;

public class JsonParser {

    public static GitResponse parseResponseToGitResponse(String responseBody) {
        JSONObject gitObject = new JSONObject(responseBody);
        return GitResponse.builder()
                .id(gitObject.getInt("id"))
                .login(gitObject.getString("login"))
                .createdAt(gitObject.getString("created_at"))
                .updatedAt(gitObject.getString("updated_at"))
                .userURLGitHub(gitObject.getString("html_url"))
                .userURLRepo(gitObject.getString("repos_url"))
                .build();
    }

    public static GitRepository parseResponseToGitRepoitory(String responseBody) {
        JSONObject jsonResponseBody = new JSONObject(responseBody);
        return GitRepository.builder()
                .fullName(jsonResponseBody.getString("full_name"))
                .description(jsonResponseBody.getString("description"))
                .cloneUrl(jsonResponseBody.getString("clone_url"))
                .createdAt(jsonResponseBody.getString("created_at"))
                .build();
    }

    public static GitRepository parseResponseToGitRepositoryFromArray(String responseBody) {
        JSONArray jsonArrayResponseBody = new JSONArray(responseBody);
        JSONObject jsonObjectResponseBody = jsonArrayResponseBody.getJSONObject(0);
        return GitRepository.builder()
                .fullName(jsonObjectResponseBody.getString("full_name"))
                .description(jsonObjectResponseBody.getString("description"))
                .cloneUrl(jsonObjectResponseBody.getString("clone_url"))
                .createdAt(jsonObjectResponseBody.getString("created_at"))
                .build();
    }
}
