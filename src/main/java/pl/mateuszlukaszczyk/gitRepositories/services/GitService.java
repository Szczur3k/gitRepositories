package pl.mateuszlukaszczyk.gitRepositories.services;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.stereotype.Service;
import pl.mateuszlukaszczyk.gitRepositories.models.GitResponse;

@Service
public class GitService {

    GitResponse gitResponse = new GitResponse();
    HttpClient httpClient = new HttpClient();

    public String getHttpClientResponse(HttpClient httpClient){
        return httpClient.response;
    }

    public GitResponse getGitResponse() throws ParseException {
        return JsonParser.parse(httpClient.response);
    }
}
