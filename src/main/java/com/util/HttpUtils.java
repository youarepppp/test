package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtils {
	
	private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);
	
	private static final int HTTP_STATUS_200 = 200;
	
	private static final int HTTP_STATUS_201 = 201;
	
	private static final int HTTP_STATUS_400 = 400;
	
	/**
	 * http POST 请求，非json方式
	 * 
	 * @param url
	 * @param paramsMap
	 * @return
	 */
	public static String httpPostRequest(String url,
			Map<String, String> paramsMap) {
		logger.info("http post url:" + url + "\nparamMap:" + paramsMap);
		
		String returnStr = "";
		/* 创建HttpClient实例 */
		HttpClient httpclient = HttpClientBuilder.create().build();

		/* 创建一个Post方法 */
		HttpPost httpPost = new HttpPost(url);

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		
		if (paramsMap != null) {
			for (Iterator<String> it = paramsMap.keySet().iterator(); it.hasNext();) {
				String key = it.next();
				String value = paramsMap.get(key);
	
				params.add(new BasicNameValuePair(key, value));
			}
		}

		/* 设置连接超时时间 */
		int reConnTimes = 1;
		int connTimeoutSecond = 10;
		int socketTimeoutSecond = 10;

		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout(socketTimeoutSecond * 1000)
				.setConnectTimeout(connTimeoutSecond * 1000).build();
		httpPost.setConfig(requestConfig);

		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		boolean success = false;
		for (int i = 0; i < reConnTimes; i++) {
			try {
				HttpResponse response = httpclient.execute(httpPost);
				success = response.getStatusLine().getStatusCode() == HTTP_STATUS_200 ||
						response.getStatusLine().getStatusCode() == HTTP_STATUS_201;
				logger.info("request to " + url + ",the status code is:"
						+ response.getStatusLine().getStatusCode());
				if (success) {
					HttpEntity entity = response.getEntity();
					if (entity != null) {
						InputStream instreams = entity.getContent();
						returnStr = convertStreamToString(instreams);
						logger.info("result from http:" + returnStr);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				httpPost.releaseConnection();
			}
			if (success) {
				break;
			}
		}
		return returnStr;
	}
	
	
	
	/**
	 * http GET 请求
	 * 
	 * @param url
	 * @param outputFileName
	 */
	public static String httpGetRequest(String url) {
		logger.info("http get url:" + url);
		
		/* 创建HttpClient实例 */
		HttpClient httpclient = HttpClientBuilder.create().build();

		/* 创建一个Get方法 */
		HttpGet httpGet = new HttpGet(url);

		/* 设置连接超时时间 */
		int connTimeoutSecond = 10;
		int socketTimeoutSecond = 10;

		String result = null;
		 
		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout(socketTimeoutSecond * 1000)
				.setConnectTimeout(connTimeoutSecond * 1000).build();
		httpGet.setConfig(requestConfig);

		try {
			HttpResponse response = httpclient.execute(httpGet);
			boolean success = response.getStatusLine().getStatusCode() == HTTP_STATUS_200 ||
					response.getStatusLine().getStatusCode() == HTTP_STATUS_201;

			
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					InputStream instreams = entity.getContent();
					result = convertStreamToString(instreams);
					if((result==null||result.equals(""))){						
						if(success)
							result="{\"error_code\":0,\"detail\":\"success\"}";
						else
							result="{\"error_code\":1,\"detail\":\"fail\"}";
					}
					logger.info("result from http:" + result);
				}
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpGet.releaseConnection();
		}
		return result;
	}
	
	/**
	 * http GET 请求
	 * 
	 * @param url
	 * @param outputFileName
	 */
	public static String httpGetRequest201(String url) {
		logger.info("http get url:" + url);
		
		/* 创建HttpClient实例 */
		HttpClient httpclient = HttpClientBuilder.create().build();

		/* 创建一个Get方法 */
		HttpGet httpGet = new HttpGet(url);

		/* 设置连接超时时间 */
		int connTimeoutSecond = 10;
		int socketTimeoutSecond = 10;

		String result = null;
		 
		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout(socketTimeoutSecond * 1000)
				.setConnectTimeout(connTimeoutSecond * 1000).build();
		httpGet.setConfig(requestConfig);

		try {
			HttpResponse response = httpclient.execute(httpGet);
			boolean success = response.getStatusLine().getStatusCode() == HTTP_STATUS_201 ||
					response.getStatusLine().getStatusCode() == HTTP_STATUS_201;

			
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					InputStream instreams = entity.getContent();
					result = convertStreamToString(instreams);
					if((result==null||result.equals(""))){
						
						if(success)
							result="{\"error_code\":0,\"detail\":\"success\"}";
						else
							result="{\"error_code\":1,\"detail\":\"fail\"}";
					}
					logger.info("result from http:" + result);
				}
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpGet.releaseConnection();
		}
		return result;
	}
	
	/**
	 * http GET 请求
	 * 
	 * @param url
	 * @param outputFileName
	 */
	public static String httpGetRequestWithHead(String url,Map<String, String> headMap) {
		logger.info("http get url:" + url);
		
		/* 创建HttpClient实例 */
		HttpClient httpclient = HttpClientBuilder.create().build();

		/* 创建一个Get方法 */
		HttpGet httpGet = new HttpGet(url);
		
		if (headMap != null) {
			for (Iterator<String> it = headMap.keySet().iterator(); it.hasNext();) {
				String key = it.next();
				String value = headMap.get(key);
	
				httpGet.addHeader(key, value);
			}
		}
		

		/* 设置连接超时时间 */
		int connTimeoutSecond = 10;
		int socketTimeoutSecond = 10;

		String result = null;
		 
		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout(socketTimeoutSecond * 1000)
				.setConnectTimeout(connTimeoutSecond * 1000).build();
		httpGet.setConfig(requestConfig);

		try {
			HttpResponse response = httpclient.execute(httpGet);
			boolean success = response.getStatusLine().getStatusCode() == HTTP_STATUS_200 ||
					response.getStatusLine().getStatusCode() == HTTP_STATUS_201;

			
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					InputStream instreams = entity.getContent();
					result = convertStreamToString(instreams);
					if((result==null||result.equals(""))){
						
						if(success)
							result="{\"error_code\":0,\"detail\":\"success\"}";
						else
							result="{\"error_code\":1,\"detail\":\"fail\"}";
					}
					logger.info("result from http:" + result);
				}
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpGet.releaseConnection();
		}
		return result;
	}
	
	/**
	 * http Delete 请求
	 * 
	 * @param url
	 * @param outputFileName
	 */
	public static String httpDeleteRequest(String url) {
		logger.info("http del url:" + url);
		
		/* 创建HttpClient实例 */
		HttpClient httpclient = HttpClientBuilder.create().build();

		/* 创建一个Get方法 */
		HttpDelete httpDelete = new HttpDelete(url);

		/* 设置连接超时时间 */
		int connTimeoutSecond = 10;
		int socketTimeoutSecond = 10;

		String result = null;
		 
		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout(socketTimeoutSecond * 1000)
				.setConnectTimeout(connTimeoutSecond * 1000).build();
		httpDelete.setConfig(requestConfig);

		try {
			HttpResponse response = httpclient.execute(httpDelete);
			boolean success = response.getStatusLine().getStatusCode() == HTTP_STATUS_200 ||
					response.getStatusLine().getStatusCode() == HTTP_STATUS_201;
			logger.info("request to " + url + ",the status code is:"
					+ response.getStatusLine().getStatusCode());
			
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					InputStream instreams = entity.getContent();
					result = convertStreamToString(instreams);
					if((result==null||result.equals(""))){
						
						if(success)
							result="{\"error_code\":0,\"detail\":\"success\"}";
						else
							result="{\"error_code\":1,\"detail\":\"fail\"}";
					}
					
					logger.info("result from http:" + result);
				}
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpDelete.releaseConnection();
		}
		return result;
	}
	
	/**
	 * http POST 请求，json方式
	 * 
	 * @param url
	 * @param json
	 * @throws Exception
	 */
	public static String httpPostWithJSON(String url, String json) throws Exception {
		logger.info("http post url:" + url + "\njsonReq:" + json);


        /* 创建HttpClient实例 */
		HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
        
        StringEntity se = new StringEntity(json,"UTF-8");
        httpPost.setEntity(se);
        
        String result = null;
        
        try {
			HttpResponse response = httpClient.execute(httpPost);
			boolean success = response.getStatusLine().getStatusCode() == HTTP_STATUS_200 ||
					response.getStatusLine().getStatusCode() == HTTP_STATUS_201;
			logger.info("request to " + url + ",the status code is:"
					+ response.getStatusLine().getStatusCode());
			
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					InputStream instreams = entity.getContent();
					result = convertStreamToString(instreams);
					
					if((result==null||result.equals(""))){
						
						if(success)
							result="{\"error_code\":0,\"detail\":\"success\"}";
						else
							result="{\"error_code\":1,\"detail\":\"fail\"}";
					}
					
					
					logger.info("result from http:" + result);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpPost.releaseConnection();
		}
        
        return result;
    }
	
	/**
	 * http POST 请求，json方式
	 * 
	 * @param url
	 * @param json
	 * @throws Exception
	 */
	public static String httpPostHeadWithJSON(String url, String json,Map<String, String> headMap) throws Exception {
		logger.info("http post url:" + url + "\njsonReq:" + json);


        /* 创建HttpClient实例 */
		HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
        
        StringEntity se = new StringEntity(json,"UTF-8");
        httpPost.setEntity(se);
        
        if (headMap != null) {
			for (Iterator<String> it = headMap.keySet().iterator(); it.hasNext();) {
				String key = it.next();
				String value = headMap.get(key);
	
				httpPost.addHeader(key, value);
			}
		}
        
        
        String result = null;
        
        try {
			HttpResponse response = httpClient.execute(httpPost);
			boolean success = response.getStatusLine().getStatusCode() == HTTP_STATUS_200 ||
					response.getStatusLine().getStatusCode() == HTTP_STATUS_201;
			logger.info("request to " + url + ",the status code is:"
					+ response.getStatusLine().getStatusCode());
			
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					InputStream instreams = entity.getContent();
					result = convertStreamToString(instreams);
					logger.info("result from http:" + result);
					if((result==null||result.equals(""))){		
						if(success)
							result="{\"error_code\":0,\"detail\":\"success\"}";
						else
							result="{\"error_code\":1,\"detail\":\"fail\"}";
					}
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpPost.releaseConnection();
		}
        
        return result;
    }
	
	
	
	/**
	 * http Put 请求，json方式
	 * 
	 * @param url
	 * @param json
	 * @throws Exception
	 */
	public static String httpPutWithJSON(String url, String json) throws Exception {
		logger.info("http post url:" + url + "\njsonReq:" + json);


        /* 创建HttpClient实例 */
		HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPut httpPut = new HttpPut(url);
        httpPut.addHeader(HTTP.CONTENT_TYPE, "application/json");
        
        StringEntity se = new StringEntity(json,"UTF-8");
        httpPut.setEntity(se);
        
        String result = null;
        
        try {
			HttpResponse response = httpClient.execute(httpPut);
			boolean success = response.getStatusLine().getStatusCode() == HTTP_STATUS_200 ||
					response.getStatusLine().getStatusCode() == HTTP_STATUS_201;
			logger.info("request to " + url + ",the status code is:"
					+ response.getStatusLine().getStatusCode());
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					InputStream instreams = entity.getContent();
					result = convertStreamToString(instreams);
					if((result==null||result.equals(""))){
						
						if(success)
							result="{\"error_code\":0,\"detail\":\"success\"}";
						else
							result="{\"error_code\":1,\"detail\":\"fail\"}";
					}
					logger.info("result from http:" + result);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpPut.releaseConnection();
		}
        
        return result;
    }
	
	/**
	 * https GET 请求
	 * 
	 * @param url
	 * @param outputFileName
	 */
	public static void httpsGetRequest(String url) throws Exception{
		logger.info("https get url:" + url);
		
		/* 创建HttpClient实例 */
		HttpClient httpclient = createSSLClientDefault();

		/* 创建一个Get方法 */
		HttpGet httpGet = new HttpGet(url);

		/* 设置连接超时时间 */
		int connTimeoutSecond = 10;
		int socketTimeoutSecond = 10;

		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout(socketTimeoutSecond * 1000)
				.setConnectTimeout(connTimeoutSecond * 1000).build();
		httpGet.setConfig(requestConfig);

		try {
			HttpResponse response = httpclient.execute(httpGet);
			boolean success = response.getStatusLine().getStatusCode() == HTTP_STATUS_200 ||
					response.getStatusLine().getStatusCode() == HTTP_STATUS_201;

			
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					InputStream instreams = entity.getContent();
					logger.info(convertStreamToString(instreams));
				}
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpGet.releaseConnection();
			((CloseableHttpClient)httpclient).close();
		}

	}
	
	/**
	 * https POST请求，json方式
	 * 
	 * @param url
	 * @param json
	 * @throws Exception
	 */
	public static void httpsPostWithJSON(String url, String json) throws Exception {
		logger.info("https post url:" + url + "\njsonReq:" + json);


        /* 创建HttpClient实例 */
		HttpClient httpClient = createSSLClientDefault();
		
        HttpPost httpPost = new HttpPost(url);
        //httpPost.addHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON);
        
        StringEntity se = new StringEntity(json,"UTF-8");
        httpPost.setEntity(se);
        
        try {
			HttpResponse response = httpClient.execute(httpPost);
			boolean success = response.getStatusLine().getStatusCode() == HTTP_STATUS_200 ||
					response.getStatusLine().getStatusCode() == HTTP_STATUS_201;
			logger.info("request to " + url + ",the status code is:"
					+ response.getStatusLine().getStatusCode());
			
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					InputStream instreams = entity.getContent();
					logger.info("result from https:" + convertStreamToString(instreams));
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpPost.releaseConnection();
			((CloseableHttpClient) httpClient).close();
		}
    }
	
	
	
	
	public static String convertStreamToString(InputStream is) {
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, "UTF-8"));
			while ((line = reader.readLine()) != null) {
				if (sb.length() == 0) {
					sb.append(line);
				} else {
					sb.append("\n" + line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	public static CloseableHttpClient createSSLClientDefault() {
		try {
			SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(
					null, new TrustStrategy() {
						// 信任所有
						public boolean isTrusted(X509Certificate[] chain,
						String authType) throws CertificateException {
							return true;
						}
					}).build();
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
					sslContext);
			return HttpClients.custom().setSSLSocketFactory(sslsf).build();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		}
		return HttpClients.createDefault();
	}
	
	public static void main(String[] args) throws Exception{
//		httpsGetRequest("https://api.weixin.qq.com/sns/oauth2/access_token?grant_type=authorization_code&appid=wxe709023c878d6943&secret=371b1342eab244be2c8c8ede638b3b8f");
		
//		httpGetRequest("https://api.weixin.qq.com/sns/oauth2/access_token?grant_type=authorization_code&appid=wxe709023c878d6943&secret=371b1342eab244be2c8c8ede638b3b8f");

		String json = "{\"grant_type\":\"authorization_code\",\"appid\":\"wxe709023c878d6943\",\"secret\":\"371b1342eab244be2c8c8ede638b3b8f\"}";
		httpsPostWithJSON("https://api.weixin.qq.com/sns/oauth2/access_token", json);
	}
}
