package com.dans.job.adapter.out.external;

import com.dans.job.application.domain.model.Position;
import com.dans.job.application.port.out.LoadPositionPort;
import com.dans.job.application.port.out.LoadAllPositionsPort;
import com.dans.job.exception.ExternalSystemException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PositionExternalAdapter implements LoadAllPositionsPort, LoadPositionPort {

    private final PositionExternalResponseMapper positionExternalResponseMapper;
    @Value("${app.dans.base-url-api}")
    private final String dansBaseUrlApi;
    private final RestTemplate restTemplate;

    @Override
    public Position loadPositionById(String id) {
        URI uri = UriComponentsBuilder.fromUri(URI.create(String.format("%s/%s/%s/%s", dansBaseUrlApi, "recruitment", "positions", id))).build().toUri();
        HttpHeaders headers = getHttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<PositionExternalResponse> response = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, PositionExternalResponse.class);
        checkError(response, uri);
        return positionExternalResponseMapper.mapPositionExternalResponseToPosition(response.getBody());
    }

    @Override
    public List<Position> loadAllPositions() {
        URI uri = UriComponentsBuilder.fromUri(URI.create(String.format("%s/%s/%s", dansBaseUrlApi, "recruitment", "positions.json"))).build().toUri();
        HttpHeaders headers = getHttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<List<PositionExternalResponse>> response = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<PositionExternalResponse>>() {});
        checkError(response, uri);
        return Optional.ofNullable(response.getBody())
                .map(positionExternalResponses ->
                    positionExternalResponses
                        .stream()
                        .map(positionExternalResponseMapper::mapPositionExternalResponseToPosition)
                        .toList()
                )
                .orElse(new ArrayList<>());
    }

    private void checkError(ResponseEntity<?> response, URI uri) {
        if(response.getStatusCode().isError()) {
            throw new ExternalSystemException(response.getStatusCode().value(), String.format("Error while hit external system, url: %s, status code: %d", uri.getPath(), response.getStatusCode().value()));
        }
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        return headers;
    }

}
