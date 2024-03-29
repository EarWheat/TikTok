package com.bjtv.tiktok.Client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.SocketTimeoutException;
import java.util.Map;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/7/18 上午11:42
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@Slf4j
@Component
public class HttpClient {
    
    public static String doGetHttp(String restUrl, Integer connectTimeout, Integer readTimeout) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String errMsg = null;
        try {
            HttpEntity requestEntity = null;
            if (connectTimeout != null && readTimeout != null) {
                HttpHeaders headers = new HttpHeaders();
                headers.add("connectTimeout", String.valueOf(connectTimeout));
                headers.add("readTimeout", String.valueOf(readTimeout));
                requestEntity = new HttpEntity(headers);
            }
            ResponseEntity<String> responseEntity = restTemplate.exchange(restUrl, HttpMethod.GET,
                    requestEntity, String.class);
            if (responseEntity.getStatusCodeValue() != HttpStatus.OK.value()) {
                errMsg = responseEntity.getBody();
                log.error("HttpResponse error:{}", errMsg);
            }
            return responseEntity.getBody();
        } catch (HttpStatusCodeException e) {
            String errorpayload = e.getResponseBodyAsString();
            log.error("HttpStatusCodeException errorpayload:{} restUrl:{}", errorpayload, restUrl);
        } catch (RestClientException e) {
            if (e.getCause() instanceof SocketTimeoutException) {
                log.error("connection timed out restUrl:{}", restUrl);
            } else {
                throw new Exception(e.getMessage(), e);
            }
        }
        throw new SocketTimeoutException(errMsg);
    }

    public static String doPostJsonHttp(String restUrl, JSONObject paramJson, HttpHeaders httpHeaders, Integer connectTimeout, Integer readTimeout) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        if (httpHeaders == null) {
            httpHeaders = new HttpHeaders();
        }
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        if (connectTimeout != null && readTimeout != null) {
            httpHeaders.add("connectTimeout", String.valueOf(connectTimeout));
            httpHeaders.add("readTimeout", String.valueOf(readTimeout));
        }
        HttpEntity<JSONObject> requestEntity = new HttpEntity<JSONObject>(paramJson, httpHeaders);
        String errMsg = null;
        try {
            ResponseEntity<String> responseEntity = restTemplate.exchange(restUrl, HttpMethod.POST,
                    requestEntity, String.class);
            if (responseEntity.getStatusCodeValue() != HttpStatus.OK.value()) {
                errMsg = responseEntity.getBody();
                log.error("HttpResponse error:{}", errMsg);
            }
            return responseEntity.getBody();
        } catch (HttpStatusCodeException e) {
            String errorpayload = e.getResponseBodyAsString();
            log.error("HttpStatusCodeException errorpayload:{} try again restUrl:{},requestEntity:{}",
                    errorpayload, restUrl, JSON.toJSONString(requestEntity));
        } catch (RestClientException e) {
            if (e.getCause() instanceof SocketTimeoutException) {
                log.error("connection timed out restUrl:{},requestEntity:{}", restUrl,
                        JSON.toJSONString(requestEntity));
            } else {
                throw new Exception(e.getMessage(), e);
            }
        }
        throw new SocketTimeoutException(errMsg);
    }

    public static String doPostFromOkHttp(String restUrl, MultiValueMap<String, Object> paramMap, HttpHeaders httpHeaders, Integer connectTimeout, Integer readTimeout, Map<String, String> urlVariables, Integer retryTimes) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        if (httpHeaders == null) {
            httpHeaders = new HttpHeaders();
        }
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        if (connectTimeout != null && readTimeout != null) {
            httpHeaders.add("connectTimeout", String.valueOf(connectTimeout));
            httpHeaders.add("readTimeout", String.valueOf(readTimeout));
        }
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(paramMap, httpHeaders);
        String errMsg = null;
        try {
            ResponseEntity<String> responseEntity = restTemplate.exchange(restUrl, HttpMethod.POST,
                    requestEntity, String.class);
            if (responseEntity.getStatusCodeValue() != HttpStatus.OK.value()) {
                errMsg = responseEntity.getBody();
                log.error("HttpResponse error:{}", errMsg);
            }
            return responseEntity.getBody();
        } catch (HttpStatusCodeException e) {
            String errorpayload = e.getResponseBodyAsString();
            log.error("[okhttp]HttpStatusCodeException errorpayload:{} try again restUrl:{},requestEntity:{}",
                    errorpayload, restUrl, JSON.toJSONString(requestEntity));
        } catch (RestClientException e) {
            if (e.getCause() instanceof SocketTimeoutException) {
                log.error("[okhttp]connection timed out restUrl:{},requestEntity:{}", restUrl,
                        JSON.toJSONString(requestEntity));
            } else {
                throw new Exception(e.getMessage(), e);
            }
        }
        throw new SocketTimeoutException(errMsg);
    }

}
