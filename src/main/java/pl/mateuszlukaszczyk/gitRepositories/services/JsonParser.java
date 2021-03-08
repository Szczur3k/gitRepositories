package pl.mateuszlukaszczyk.gitRepositories.services;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONObject;
import pl.mateuszlukaszczyk.gitRepositories.models.GitResponse;

import java.net.URL;
import java.time.LocalDate;
import java.util.UUID;

public class JsonParser {

    public static GitResponse parse(String responseBody) throws ParseException {
        JSONObject gitObject = new JSONObject(responseBody);
        return GitResponse.builder()
                .id((Integer) gitObject.get("id"))
                .login((String) gitObject.get("login"))
                .createdAt((String) gitObject.get("created_at"))
                .updatedAt((String) gitObject.get("updated_at"))
                .userURLGitHub((String) gitObject.get("html_url"))
                .userURLRepo((String) gitObject.get("repos_url"))
                .build();
    }
}

//{
//        "login": "defunkt",
//        "id": 2,
//        "node_id": "MDQ6VXNlcjI=",
//        "avatar_url": "https://avatars.githubusercontent.com/u/2?v=4",
//        "gravatar_id": "",
//        "url": "https://api.github.com/users/defunkt",
//        "html_url": "https://github.com/defunkt",
//        "followers_url": "https://api.github.com/users/defunkt/followers",
//        "following_url": "https://api.github.com/users/defunkt/following{/other_user}",
//        "gists_url": "https://api.github.com/users/defunkt/gists{/gist_id}",
//        "starred_url": "https://api.github.com/users/defunkt/starred{/owner}{/repo}",
//        "subscriptions_url": "https://api.github.com/users/defunkt/subscriptions",
//        "organizations_url": "https://api.github.com/users/defunkt/orgs",
//        "repos_url": "https://api.github.com/users/defunkt/repos",
//        "events_url": "https://api.github.com/users/defunkt/events{/privacy}",
//        "received_events_url": "https://api.github.com/users/defunkt/received_events",
//        "type": "User",
//        "site_admin": false,
//        "name": "Chris Wanstrath",
//        "company": null,
//        "blog": "http://chriswanstrath.com/",
//        "location": null,
//        "email": null,
//        "hireable": null,
//        "bio": "🍔",
//        "twitter_username": null,
//        "public_repos": 107,
//        "public_gists": 273,
//        "followers": 21150,
//        "following": 210,
//        "created_at": "2007-10-20T05:24:19Z",
//        "updated_at": "2019-11-01T21:56:00Z"
//        }