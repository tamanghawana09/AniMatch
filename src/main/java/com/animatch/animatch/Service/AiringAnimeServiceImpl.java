package com.animatch.animatch.Service;

import com.animatch.animatch.Configuration.WebClientConfig;
import com.animatch.animatch.DTO.AiringAnimeDTO;
import com.animatch.animatch.DTO.AiringAnimeResponse;
import com.animatch.animatch.Interface.AiringAnimeService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class AiringAnimeServiceImpl implements AiringAnimeService {

    private final RestTemplate restTemplate;

    private final WebClient webClient;

    public AiringAnimeServiceImpl(RestTemplate restTemplate, WebClient webClient){
        this.restTemplate = restTemplate;
        this.webClient = webClient;
    }


    @Override
    public List<AiringAnimeDTO> showAiringAnime() {

        String url =
                "https://api.tenrai.org/v1/top/anime";

        for (int attempt = 1; attempt <= 3; attempt++) {

            try {

                System.out.println(
                        "Calling Tenrai: "
                                + url
                                + " | attempt "
                                + attempt
                );

                AiringAnimeResponse response =
                        restTemplate.getForObject(
                                url,
                                AiringAnimeResponse.class
                        );

                if (response == null) {
                    System.err.println(
                            "Tenrai returned null response"
                    );
                    continue;
                }

                if (response.getData() == null) {
                    System.err.println(
                            "Tenrai response.data is null"
                    );
                    continue;
                }

                System.out.println(
                        "Airing anime received: "
                                + response.getData().size()
                );

                return response.getData();

            } catch (HttpStatusCodeException e) {

                System.err.println(
                        "Tenrai HTTP error: "
                                + e.getStatusCode()
                );

                System.err.println(
                        "Response body: "
                                + e.getResponseBodyAsString()
                );

            } catch (RestClientException e) {

                System.err.println(
                        "Tenrai request/deserialization error:"
                );

                e.printStackTrace();
            }

            if (attempt < 3) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }

        System.err.println(
                "Tenria airing failed after 3 attempts"
        );

        return List.of();
    }
}