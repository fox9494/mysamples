package com.soarsky.octopus.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

/**
 * http请求工具
 * @author chenll
 *
 */
public class HttpUtil {
	
	
	
	/**
	 * get 请求
	 * @param url  请求url
	 * @param params 请求参数
	 * @param charset  编码字符集 "utf-8"
	 * @return
	 */
	public static String doGet(String url,Map<String,String> params,String charset){
		HttpClient httpclient = new DefaultHttpClient();
		List<NameValuePair> relParams = new ArrayList<NameValuePair>();
		Set<Entry<String, String>> set = params.entrySet();
		for (Entry<String, String> entry : set) {
			relParams.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
		}
		
		String body="";
		try{
			HttpGet httpget = new HttpGet(url);
			String str = EntityUtils.toString(new UrlEncodedFormEntity(relParams,charset));
			httpget.setURI(new URI(httpget.getURI().toString()+"?"+str));
            HttpContext context = new BasicHttpContext();
			HttpResponse respond = httpclient.execute(httpget,context);
			HttpEntity entity = respond.getEntity();
			if (entity!=null){
				body = EntityUtils.toString(entity, charset);
				
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}finally{
			httpclient.getConnectionManager().shutdown();
		}
		
		return body;
	}
	
	
	/**
	 * 简单post提交
	 * @param url
	 * @param params
	 * @param charset
	 * @return
	 */
	public static String doPost(String url,Map<String,String> params,String charset){
		DefaultHttpClient httpclient = new DefaultHttpClient();
		
		
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();
		Set<Entry<String, String>> set = params.entrySet();
		for (Entry<String, String> entry : set) {
			nvps.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
		}
		HttpPost httpPost = new HttpPost(url);
		
		String body="";
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nvps));
			HttpResponse response = httpclient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			if (entity!=null){
				body = EntityUtils.toString(entity, charset);
				
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			httpclient.getConnectionManager().shutdown();
		}
		return body;
		
	}

}
