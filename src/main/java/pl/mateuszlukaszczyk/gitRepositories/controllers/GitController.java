package pl.mateuszlukaszczyk.gitRepositories.controllers;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.mateuszlukaszczyk.gitRepositories.models.GitResponse;
import pl.mateuszlukaszczyk.gitRepositories.services.GitService;

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

    @GetMapping("/repositories/{owner}/{repository-name")
    public String getApiGit(@PathVariable(value = "owner") String owner,@PathVariable(value = "repository-name") String repositoryName) {
        return gitService.getHttpClientResponseFromOwnerRepository(owner, repositoryName);
    }

    @GetMapping("/repositories/{owner}/")
    public ResponseEntity<GitResponse> getApiGitResponse(@PathVariable(value = "owner") String owner) {
        return gitService.getGitResponseInEntity(owner);

    }

}

/* GET/repositories/{owner}/{repository-name}

{
    "fullName:"...",
    "description:"...",
    "cloneUrl:"...",
    "stars:0,
    "createdAt:"..."
}


 */