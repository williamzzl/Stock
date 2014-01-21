package com.william.service;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class StockListHandler {
	private final static String source = "http://bbs.10jqka.com.cn/codelist.html";
	
	private final static String regSelecter = "a[href~=.*(sh|sz),.*]";
	
	public static final ArrayList<String> getStockList() {
		ArrayList<String> list = new ArrayList<String>();
		try {
			Document doc = Jsoup.connect(source).get();
			 Elements stockElements = doc.select(regSelecter);
			 for (Element element : stockElements) {
				 String[] stock = element.text().split(" ");
				 if (stock.length == 2) {
					 list.add(stock[1]);	 
				 }
			 }
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}
