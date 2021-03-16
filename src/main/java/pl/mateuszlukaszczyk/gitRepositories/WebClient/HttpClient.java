package pl.mateuszlukaszczyk.gitRepositories.WebClient;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;

@Component
public class HttpClient {
    public static final String HTTPS_API_GITHUB_COM_USERS = "https://api.github.com/users/";
    public static final String HTTPS_API_GITHUB_COM_REPOS = "https://api.github.com/repos/";
    RestTemplate restTemplate = new RestTemplate();
    URL url = null;

    public String getResponseFromOwnerAllRepositories(String owner) {
        return callGetMethod(HTTPS_API_GITHUB_COM_USERS, "{owner}/repos", owner);
    }

    public String getResponseFromOwner(String owner) {
        return callGetMethod(HTTPS_API_GITHUB_COM_USERS, "{owner}", owner);
    }

    public String getResponseFromOwnerChoosenRepo(String owner, String repositoryName) {
        return callGetMethod(HTTPS_API_GITHUB_COM_REPOS, "{owner}/{repositoryName}", owner, repositoryName);
    }


    private String callGetMethod(String finalURL, String urlParam, Object... parameters) {
        return restTemplate.getForObject(finalURL + urlParam,
                String.class,
                parameters);
    }
}