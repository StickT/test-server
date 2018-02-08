package com.benlai.test.common.components;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by yaoyimin on 2018/2/2
 */
@Component
public class HttpCommonClient {

	private static Logger logger = LoggerFactory.getLogger(HttpCommonClient.class);

	public String doGet(String url) {

		String result = "";

		CloseableHttpResponse response = null;

		try {
			CloseableHttpClient client = HttpClientBuilder.create().build();
			HttpGet httpGet = new HttpGet(url);
			response = client.execute(httpGet);
		} catch (Exception e) {
			logger.error("发送Http请求失败,堆栈信息: {} , 错误信息为: {}" , ExceptionUtils.getStackTrace(e) , e.getMessage());

			return "";
		}

		return extractJsonFromResponse(response);
	}

	public String doPost(String url , HttpEntity body) {

		CloseableHttpResponse response = null;

		try {
			CloseableHttpClient client = HttpClientBuilder.create().build();
			HttpPost httpPost = new HttpPost(url);
			httpPost.setEntity(body);
			response = client.execute(httpPost);
		} catch (Exception e) {
			logger.error("发送Http请求失败,堆栈信息: {} , 错误信息为: {}" , ExceptionUtils.getStackTrace(e) , e.getMessage());

			return "";
		}

		return extractJsonFromResponse(response);
	}

	private String extractJsonFromResponse(HttpResponse response){
		HttpEntity entity = response.getEntity();

		if (response.getStatusLine().getStatusCode() != 200){
			logger.warn("调用接口时发生了未知的错误,http返回状态码为: {} " , response.getStatusLine().getStatusCode());
		}

		return extractJsonFromHttpEntity(entity);
	}

	private String extractJsonFromHttpEntity(HttpEntity entity) {
		String result = "";

		try {
			result = EntityUtils.toString(entity);
		} catch (IOException e) {

			logger.error("读取Http请求返回的数据失败,堆栈信息为: {} , 错误信息为: {}" , ExceptionUtils.getStackTrace(e) , e.getMessage());

		} catch (ParseException e) {

			logger.error("转换返回数据为字符串时失败,堆栈信息为: {} , 错误信息为: {}" , ExceptionUtils.getStackTrace(e) , e.getMessage());

		}

		return result;
	}
}
