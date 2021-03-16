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
//        JSONObject jsonObjectResponseBody = jsonArrayResponseBody.getJSONObject(0);
//
//        List<GitRepository> gitRepositoryList = null;
//        Iterator<String> keys = jsonObjectResponseBody.keys();
//        while (keys.hasNext()) {
//            String key = keys.next();
//            JSONObject value = jsonObjectResponseBody.getJSONObject(key);
//
//            //Powinienes zapisac metodę w nowej klasie JSON ktora przelatuje po JSONObject i zapisuje je do klasy REPO
//            if (!value.equals(JSONObject.class)) {
//                gitRepositoryList.add(GitRepository.builder()
//                        .fullName(value.getString("full_name"))
//                        .description(value.getString("description"))
//                        .cloneUrl(value.getString("clone_url"))
//                        .createdAt(value.getString("created_at"))
//                        .build());
//            }
//        }

        return GitChangerJson.changerJSONArrayToGitRepositoryList(jsonArrayResponseBody);
    }
}
