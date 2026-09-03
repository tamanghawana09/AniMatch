package com.animatch.animatch.Service;

import com.animatch.animatch.DTO.AnimeDTO;
import com.animatch.animatch.DTO.AnimeListResponse;
import com.animatch.animatch.DTO.AnimeResponse;
import com.animatch.animatch.Interface.AnimeListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class AnimeListServiceImpl implements AnimeListService {

    @Autowired
    private RestTemplate restTemplate;


    private final String BASE_URL = "https://api.jikan.moe/v4";

    private static final int MAX_ATTEMPTS = 3;


    @Override
    public AnimeListResponse browse(int page) {

        String url = BASE_URL + "/anime";

        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {

            try {

                System.out.println(
                        "Calling Jikan: " + url +
                                " | attempt " + attempt
                );
                AnimeListResponse response =
                        restTemplate.getForObject(url, AnimeListResponse.class);

                System.out.println("Jikan response received");

                if (response != null) {
                    return response;
                }

            } catch (RestClientException e) {

                System.out.println(
                        "Jikan failed attempt " + attempt + "/" + MAX_ATTEMPTS
                );
                if (attempt == MAX_ATTEMPTS) {
                    e.printStackTrace();
                    break;
                }
                try {
                    Thread.sleep(1000L * attempt);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    break;
                }

            }
        }


        // fallback so your page does not crash
        AnimeListResponse empty = new AnimeListResponse();
        empty.setData(Collections.emptyList());

        AnimeListResponse.Pagination pagination =
                new AnimeListResponse.Pagination();

        pagination.setHasNextPage(false);

        empty.setPagination(pagination);

        return empty;
    }



    @Override
    public AnimeDTO fetchAnimeById(Long id){

        String url = BASE_URL + "/anime/" + id;


        try {

            AnimeResponse response =
                    restTemplate.getForObject(
                            url,
                            AnimeResponse.class
                    );

            return response != null
                    ? response.getData()
                    : null;


        } catch (RestClientException e){

            System.out.println(
                    "Failed fetching anime id: " + id
            );

            return null;
        }
    }
}