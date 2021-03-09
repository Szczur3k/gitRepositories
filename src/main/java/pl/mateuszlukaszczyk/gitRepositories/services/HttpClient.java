package pl.mateuszlukaszczyk.gitRepositories.services;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;

@Component
public class HttpClient {

    public String getResponseFromOwnerRepository(String owner, String repositoryName) {
        RestTemplate restTemplate = new RestTemplate();
        URL url = null;
        try {
            url = new URL("https://api.github.com/" + getOwnerName(owner) + "/" + getRepositoryName(repositoryName));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return restTemplate.getForObject(String.valueOf(url), String.class);
    }

    public String getResponseFromOwner(String owner) {
        RestTemplate restTemplate = new RestTemplate();
        URL url = null;
        try {
            url = new URL("https://api.github.com/" + getOwnerName(owner));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return restTemplate.getForObject(String.valueOf(url), String.class);
    }

    private Object getRepositoryName(String repositoryName) {
        return repositoryName;
    }

    private Object getOwnerName(String owner) {
        return owner;
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