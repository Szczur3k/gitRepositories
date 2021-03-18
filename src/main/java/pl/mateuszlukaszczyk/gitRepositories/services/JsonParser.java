package pl.mateuszlukaszczyk.gitRepositories.services;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.json.JSONArray;
import org.json.JSONObject;
import pl.mateuszlukaszczyk.gitRepositories.models.GitRepository;
import pl.mateuszlukaszczyk.gitRepositories.models.GitResponse;
import pl.mateuszlukaszczyk.gitRepositories.services.dto.GitChangerJson;

import java.util.Iterator;
import java.util.List;

public class JsonParser {

    public static GitResponse parseResponseToGitResponse(String responseBody) {
        JSONObject jsonObject = new JSONObject(responseBody);
        return GitChangerJson.changeJSONObjectToGitResponse(jsonObject);
    }

    public static GitRepository parseResponseToGitRepoitory(String responseBody) {
        JSONObject jsonResponseBody = new JSONObject(responseBody);
        return GitChangerJson.changeJSONObjectToGitRepo(jsonResponseBody);
    }

    public static List<GitRepository> parseResponseToGitRepositoryFromArray(String responseBody) {
        JSONArray jsonArrayResponseBody = new JSONArray(responseBody);
        return GitChangerJson.changerJSONArrayToGitRepositoryList(jsonArrayResponseBody);
    }
}
