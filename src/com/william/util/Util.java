package com.william.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class Util {
	/**
	 * 
	 * @param url E.g. http://hq.sinajs.cn/m=1318986628214&list=sh601006
	 * @return
	 */
	public static final String getStockData(String url) {
		HttpClient client = new DefaultHttpClient();
		HttpGet getUrl = new HttpGet(url);
		try {
			HttpResponse res = client.execute(getUrl);
			HttpEntity entity = res.getEntity();
			return EntityUtils.toString(entity);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "";
	}
}
