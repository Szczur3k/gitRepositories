package pl.mateuszlukaszczyk.gitRepositories.services;

import org.springframework.web.client.RestTemplate;

public class HttpClient {

    RestTemplate restTemplate = new RestTemplate();
    String response = restTemplate.getForObject("https://api.github.com/users/defunkt", String.class);
}
