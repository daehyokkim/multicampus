# 네이버 클로바 API활용

> 번역 해보기!!



1. controller

```java
	@RequestMapping(value="/nmt1" ,method = RequestMethod.GET)
	@ResponseBody
	public String removeMember(@RequestParam("words") String words, 
			           HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		 System.out.println(words);
		String result = null;
		result = service.papago(words);
		return result;
	}
```



2. service

```java
	@Override
	public String papago(String words) {
		 String clientId = "개인 ID";//애플리케이션 클라이언트 아이디값";
	     String clientSecret = "개인 시크릿 값";//애플리케이션 클라이언트 시크릿값";

		 String result = null;
		 StringBuffer res = null;
		 System.out.println("wellcom service");
	     try {
	         String text = URLEncoder.encode(words, "UTF-8");
	         String apiURL = "https://naveropenapi.apigw.ntruss.com/nmt/v1/translation";
	         URL url = new URL(apiURL);
	         HttpURLConnection con = (HttpURLConnection)url.openConnection();
	         con.setRequestMethod("POST");
	         con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
	         con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
	         // post request
	         String postParams = "source=ko&target=en&text=" + text;
	         con.setDoOutput(true);
	         DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	         wr.writeBytes(postParams);
	         wr.flush();
	         wr.close();
	         int responseCode = con.getResponseCode();
	         BufferedReader br;
	         if(responseCode==200) { // 정상 호출
	             br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	         } else {  // 오류 발생
	             br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	         }
	         String inputLine;
	         res = new StringBuffer();
	         while ((inputLine = br.readLine()) != null) {
	             res.append(inputLine);
	         }
	         br.close();
	         System.out.println(res.toString());
	         result = res.toString();
	     } catch (Exception e) {
	         System.out.println(e);
	     }
		return result;

	}
```

3. jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>번역페이지</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	function sendWords(){
		words = $('#words').val();
		alert(words);
		$.ajax({
	         type:"get",
	         url:"/spring-ai/nmt1",
	         contentType: "application/json",
	         data :{"words":$("#words").val()},
		     success:function (data,textStatus){
		    	  alert(data);
		    	  answer = JSON.parse(data);
		    	  text = answer.message.result.translatedText;
		    	  $("#message").text(text);
		     },
		     error:function(data,textStatus){
		        alert("에러가 발생했습니다.");
		     },
		     complete:function(data,textStatus){
		    	 
		     }
		  });
	}
</script>
</head>
<body>
	<form action="" method="get">
		번역할 문장 : <input type="text" name = "" id= "words">
		<input type="button" value ="확인"  onclick="sendWords()">
		
	</form>
	번역된 문장 : <span id = "message"></span>

</body>
</html>
```

