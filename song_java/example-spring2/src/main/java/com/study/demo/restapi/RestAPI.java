package com.study.demo.restapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
    public String useHttp(@RequestParam Map<String, String> paramapMap) throws MalformedURLException{
    // public Map<String,Object> useHttp(@RequestParam Map<String, String> paramapMap) throws MalformedURLException{
    // public void useHttp(@RequestParam Map<String, String> paramapMap) throws MalformedURLException{

        System.out.println("######################### " + paramapMap);

        Map<String, Object> result = new HashMap<>();
        String movieData = "";
        
        try {
            // URL url = new URL("http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json");
            // HttpUrlConnection con = url.openConnection();
            String APIURL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json"; 
            URL url = new URL(APIURL+"?key="+ paramapMap.get("key").toString() +"&movieCd=" + paramapMap.get("movieCd").toString());
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
            // 서버에 연결되는 Timeout 시간 설정
            con.setConnectTimeout(5000);
            // InputStream 읽어 오는 Timeout 시간 설정
            con.setReadTimeout(5000);
            // key 값 설정
            // con.addRequestProperty("x-api-key", Res);

            con.setRequestMethod("GET");

            // json으로 message를 전달하고자 할 때
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoInput(true);
            con.setDoOutput(true); // POST 데이터를 OutputStream 으로 넘겨 주겠다는 설정
            con.setUseCaches(false);
            con.setDefaultUseCaches(false);

            // OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
            // wr.write(paramapMap.get("key").toString());
            // wr.write(paramapMap.get("movieCd").toString());
            // wr.flush();
            // wr.close();

            // 응답(Response) 구조 작성
            // - Stream -> JSONObject
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String readline = null;
            StringBuffer response = new StringBuffer();
            while( (readline = br.readLine()) != null){
                response.append(readline);
            }


            System.out.println("##### result " + con.toString());
            System.out.println("###### CON 결과 :  " + con.getResponseCode());

            ObjectMapper objMapper = new ObjectMapper();
            movieData = objMapper.writeValueAsString(response);

            // result.put("result", response);

        } catch (Exception e) {
            log.error("### GetkobisData1 error ####", e.toString());
            e.printStackTrace();
        }



        // return result;
        return movieData;
    }
    
}
