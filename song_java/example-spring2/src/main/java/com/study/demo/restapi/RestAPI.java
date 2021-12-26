package com.study.demo.restapi;

import java.io.BufferedReader;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.ws.transport.http.HttpUrlConnection;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/api")
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
            System.out.println("####### "+ resultMap.getBody());
 
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
    // public JsonObject useHttp(@RequestParam Map<String, String> paramapMap) throws MalformedURLException{
    // public String useHttp(@RequestParam Map<String, String> paramapMap) throws MalformedURLException{
    public Map<String,Object> useHttp(@RequestParam Map<String, String> paramapMap) throws MalformedURLException{
    // public void useHttp(@RequestParam Map<String, String> paramapMap) throws MalformedURLException{

        System.out.println("######################### " + paramapMap);

        Map<String, Object> result = new HashMap<>();
        // String movieData = "";
        
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

            // 응답(Response) 구조 작성
            // - Stream -> JSONObject
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String readline = null;
            StringBuffer response = new StringBuffer();
            while( (readline = br.readLine()) != null){
                response.append(readline).append("/n");
            }

            System.out.println("##### result " + con.toString());
            System.out.println("###### CON 결과 :  " + con.getResponseCode());

            ObjectMapper objMapper = new ObjectMapper();
            // movieData = objMapper.writeValueAsString(response);

            System.out.println("###########  " + response);

            result.put("result", response);

        } catch (Exception e) {
            log.error("### GetkobisData1 error ####", e.toString());
            e.printStackTrace();
        }



        return result;
        // return movieData;
    }

    // https://jsonplaceholder.typicode.com/guide/ -> post 테스트
    @PostMapping("/getJson")
    public Map getJson(@RequestParam Map<String,Object> paramapMap) throws Exception{
    // public Map getJson(@RequestBody Sample sample) throws Exception{
        System.out.println("###### GETJSON #####");
        Map<String, Object> map = new HashMap<>();
        // JsonObject resultJson = new JsonObject();

        System.out.println("##### paramapMap ##### : " + paramapMap);

        try {
            
            String jsonURL= "https://jsonplaceholder.typicode.com/posts";
            URL url = new URL(jsonURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            con.setDoInput(true);
            con.setDoOutput(true); // POST 데이터를 OutputStream 으로 넘겨 주겠다는 설정
            con.setUseCaches(false);
            con.setDefaultUseCaches(false);
    
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-type", "application/json;");

            System.out.println("##############2 22222222222222222222");

            OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
                wr.write(paramapMap.get("body").toString());
                wr.write(paramapMap.get("title").toString());
                wr.write(String.valueOf(paramapMap.get("userid")));
                // wr.write(sample.getBody().toString());
                // wr.write(sample.getTitle().toString());
                // wr.write(String.valueOf(sample.getUserid()));
                wr.flush();
                wr.close();
            

            System.out.println("################## 3333" + con.getInputStream().toString());
            // 결과 담기
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));


            // 결과 담을 StringBuilder
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            System.out.println("#### BR #### " + br.toString());
            br.close();

            ObjectMapper mapper = new ObjectMapper();

            System.out.println("#### sb ###" + sb.toString());

            map = mapper.readValue(sb.toString(), Map.class);

            // String result = br.readLine();
            // resultJson = JSONParse
            
            // map.put("result", objout);
            
            System.out.println("### RESULT #### " + mapper.readValue(sb.toString(), Map.class));

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }



        // return new JsonObject();
        return map;
    }

    // 공통코드 조회
    @RequestMapping("/code")
    public Map<String, Object> commonCode(@RequestParam Map<String,Object> paramMap){
    // public Map<String, Object> commonCode(@RequestParam Map<String,Object> paramMap){
        Map<String, Object> result = new HashMap<>();

        try {
            String codeUrl = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/code/searchCodeList.json";
            URL url = new URL(codeUrl + "?key=" + paramMap.get("key").toString() + "&comCode=" + paramMap.get("comCode").toString());
            HttpURLConnection con = (HttpURLConnection)url.openConnection();

            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);

            con.setRequestMethod("GET");

            // json으로 message를 전달하고자 할 때
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoInput(true);
            con.setDoOutput(true); // POST 데이터를 OutputStream 으로 넘겨 주겠다는 설정
            con.setUseCaches(false);
            con.setDefaultUseCaches(false);

            // System.out.println("#### con input ##### :   " + con.getInputStream());
            // System.out.println("#### con output ##### :   " + con.getOutputStream());

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String readline = null;
            StringBuffer response = new StringBuffer();
            while( (readline = br.readLine()) != null){
                response.append(readline).append("\n");
            }

            System.out.println("#### response #### " + response);

            result.put("result", response);

            ObjectMapper obj = new ObjectMapper();
    
            String test = obj.writeValueAsString(response);

            System.out.println(" ### TEST ### " + test);
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }


        System.out.println("##### map ##### " + result);


        return result;
    }
    
    // 영화인목록 조회
    @RequestMapping("/people")
    public String getPeopleList(@RequestParam String key) throws Exception{

        System.out.println("### PEOPLE API");

        System.out.println("### key : " + key);

        String pepleURL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/people/searchPeopleList.json";
        URL url = new URL(pepleURL + "?key=" + key);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        StringBuilder sb = new StringBuilder();
        try {

            // header 설정
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);

            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setRequestProperty("Content-Type", "application/json");

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String readline = null;

            while( (readline = br.readLine()) != null){
                sb.append(readline).append("\n");
            }

            
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("#### 영화인 목록 ### " + sb.toString());


        return sb.toString();
    }
    
    @RequestMapping("/people2")
    // public String getPeopleList2(@RequestParam String key) throws Exception{
    public Map<String, String> getPeopleList2(@RequestParam String key) throws Exception{

        System.out.println("### PEOPLE API");

        System.out.println("### key : " + key);

        String pepleURL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/people/searchPeopleList.json";
        URL url = new URL(pepleURL + "?key=" + key);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        StringBuilder sb = new StringBuilder();
        Map<String, String> result = new HashMap<>();
        try {

            // header 설정
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);

            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setRequestProperty("Content-Type", "application/json");

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String readline = null;

            while( (readline = br.readLine()) != null){
                sb.append(readline).append("\n");
            }

            result.put("result", sb.toString());

            
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("#### 영화인 목록 ### " + sb.toString());


        return result;
    }
}
