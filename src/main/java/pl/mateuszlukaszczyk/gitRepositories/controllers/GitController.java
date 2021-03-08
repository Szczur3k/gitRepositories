package pl.mateuszlukaszczyk.gitRepositories.controllers;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mateuszlukaszczyk.gitRepositories.models.GitResponse;
import pl.mateuszlukaszczyk.gitRepositories.services.GitService;
import pl.mateuszlukaszczyk.gitRepositories.services.HttpClient;

@RestController
public class GitController {

    GitService gitService;

    public GitController(GitService gitService) {
        this.gitService = gitService;
    }

    @GetMapping("/")
    public String firstView() {
        return "Now I will start to writing an application";
    }

    @GetMapping("/api")
    public String getApiGit(HttpClient httpClient) {
        return gitService.getHttpClientResponse(httpClient);
    }

    @GetMapping("/api/1")
    public GitResponse getApiGitResponse() throws ParseException {
        return gitService.getGitResponse();

    }

}
