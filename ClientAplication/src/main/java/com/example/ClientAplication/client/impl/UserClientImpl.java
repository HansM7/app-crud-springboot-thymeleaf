package com.example.ClientAplication.client.impl;

import com.example.ClientAplication.DTO.ApiResponse;
import com.example.ClientAplication.DTO.EditDTO;
import com.example.ClientAplication.DTO.PostDTO;
import com.example.ClientAplication.DTO.UserDTO;
import com.example.ClientAplication.client.UserClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;

@Component
public class UserClientImpl implements UserClient {

    private RestTemplate restTemplate;


    @Override
    public List<UserDTO> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ApiResponse<List<UserDTO>>> responseEntity = restTemplate.exchange(
                "http://localhost:4000/api/users",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ApiResponse<List<UserDTO>>>() {}
        );

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            ApiResponse<List<UserDTO>> apiResponse = responseEntity.getBody();
            if (apiResponse != null && apiResponse.getData() != null) {
                return apiResponse.getData();
            } else {
                return Collections.emptyList();
            }
        } else {
            return Collections.emptyList();
        }

    }

    @Override
    public EditDTO findOne(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<ApiResponse<EditDTO>> responseEntity = restTemplate.exchange(
                    "http://localhost:4000/api/users/" + id,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<ApiResponse<EditDTO>>() {}
            );

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                ApiResponse<EditDTO> apiResponse = responseEntity.getBody();
                if (apiResponse != null && apiResponse.getOk() && apiResponse.getData() != null) {
                    return apiResponse.getData();
                }
            }
        } catch (HttpClientErrorException.NotFound ex) {
            return null;
        }
        return null;
    }

    @Override
    public ApiResponse<?> create(PostDTO postDTO) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<PostDTO> requestEntity = new HttpEntity<>(postDTO, headers);

        try {
            ResponseEntity<ApiResponse<?>> responseEntity = restTemplate.exchange(
                    "http://localhost:4000/api/users",
                    HttpMethod.POST,
                    requestEntity,
                    new ParameterizedTypeReference<ApiResponse<?>>() {}
            );

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                return responseEntity.getBody();
            } else {
                return null;
            }
        } catch (HttpClientErrorException.NotFound ex) {
            return null;
        }
    }

    @Override
    public ApiResponse<?> editOne(EditDTO editDTO) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<EditDTO> requestEntity = new HttpEntity<>(editDTO, headers);

        try {
            ResponseEntity<ApiResponse<?>> responseEntity = restTemplate.exchange(
                    "http://localhost:4000/api/users",
                    HttpMethod.PUT,
                    requestEntity,
                    new ParameterizedTypeReference<ApiResponse<?>>() {}
            );

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                return responseEntity.getBody();
            } else {
                return null;
            }
        } catch (HttpClientErrorException.NotFound ex) {
            return null;
        }
    }

    @Override
    public ApiResponse<?> deleteOne(Integer id) {
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<ApiResponse<?>> responseEntity = restTemplate.exchange(
                    "http://localhost:4000/api/users/"+id,
                    HttpMethod.DELETE,
                    null,
                    new ParameterizedTypeReference<ApiResponse<?>>() {}
            );

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                return responseEntity.getBody();
            } else {
                return null;
            }
        } catch (HttpClientErrorException.NotFound ex) {
            return null;
        }
    }


}
