package com.study.demo.restapi;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class RestAPI {

    @GetMapping("/GetkobisData")
    public String callAPI() throws JsonProcessingException {
 
        HashMap<String, Object> result = new HashMap<String, Object>();
 
        String jsonInString = "";
 
        try {
 
            HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
            factory.setConnectTimeout(5000); //타임아웃 설정 5초
            factory.setReadTimeout(5000);//타임아웃 설정 5초
            RestTemplate restTemplate = new RestTemplate(factory);
 
            HttpHeaders header = new HttpHeaders();
            HttpEntity<?> entity = new HttpEntity<>(header);
 
            String url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json";
 
            UriComponents uri = UriComponentsBuilder.fromHttpUrl(url+"?"+"key=f5eef3421c602c6cb7ea224104795888").build();
 
            //이 한줄의 코드로 API를 호출해 MAP타입으로 전달 받는다.
            ResponseEntity<Map> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Map.class);
            result.put("statusCode", resultMap.getStatusCodeValue()); //http status code를 확인
            result.put("header", resultMap.getHeaders()); //헤더 정보 확인
            result.put("body", resultMap.getBody()); //실제 데이터 정보 확인

            System.out.println("######### "+result);
 
            //데이터를 제대로 전달 받았는지 확인 string형태로 파싱해줌
            ObjectMapper mapper = new ObjectMapper();
            jsonInString = mapper.writeValueAsString(resultMap.getBody());
 
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            result.put("body"  , e.getStatusText());
            System.out.println("dfdfdfdf");
            System.out.println(e.toString());
 
        } catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body"  , "excpetion오류");
            System.out.println(e.toString());
        }
 
        return jsonInString;
 
    }

    // @GetMapping("/GetkobisData1")
    @RequestMapping(value = "/GetkobisData1", method=RequestMethod.GET)
    public Map<String,Object> useHttp(@RequestParam Map<String, String> paramapMap) throws MalformedURLException{
    // public void useHttp(@RequestParam Map<String, String> paramapMap) throws MalformedURLException{

        System.out.println("######################### " + paramapMap);

        Map<String, Object> result = new HashMap<>();
        
        try {
            // URL url = new URL("http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json");
            // HttpUrlConnection con = url.openConnection();
            URL url = new URL("http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
            // 서버에 연결되는 Timeout 시간 설정
            con.setConnectTimeout(5000);
            // InputStream 읽어 오는 Timeout 시간 설정
            con.setReadTimeout(5000);
            // key 값 설정
            // con.addRequestProperty("x-api-key", Res);

            con.setRequestMethod("POST");

            // json으로 message를 전달하고자 할 때
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoInput(true);
            con.setDoOutput(true); // POST 데이터를 OutputStream 으로 넘겨 주겠다는 설정
            con.setUseCaches(false);
            con.setDefaultUseCaches(false);

            OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
            wr.write(paramapMap.get("key").toString());
            wr.write(paramapMap.get("movieCd").toString());
            wr.flush();
            wr.close();

            System.out.println("##### result " + con.toString());

            // ObjectMapper objMapper = new ObjectMapper();
            // objMapper.writeValueAsString(con);

            result.put("result", con);

        } catch (Exception e) {
            log.error("### GetkobisData1 error ####", e.toString());
            e.printStackTrace();
        }



        return result;
    }
    
}
