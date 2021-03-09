package pl.mateuszlukaszczyk.gitRepositories.services;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;

@Component
public class HttpClient {

    public String getResponseFromOwnerRepository(String owner) {
        RestTemplate restTemplate = new RestTemplate();
        URL url = null;
        try {
            url = new URL("https://api.github.com/users/" + owner + "/" + "repos");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return restTemplate.getForObject(String.valueOf(url), String.class);
    }

    public String getResponseFromOwner(String owner) {
        RestTemplate restTemplate = new RestTemplate();
        URL url = null;
        try {
            url = new URL("https://api.github.com/users/" + owner);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return restTemplate.getForObject(String.valueOf(url), String.class);
    }

    public String getDefunkt() {
        RestTemplate restTemplate = new RestTemplate();
        URL url = null;
        try {
            url = new URL("https://api.github.com/users/defunkt");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return restTemplate.getForObject(String.valueOf(url), String.class);
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