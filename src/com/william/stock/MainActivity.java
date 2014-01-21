package com.william.stock;

import java.util.ArrayList;

import com.william.service.StockListHandler;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Thread getDataThread = new Thread(new GetDataThread());
		getDataThread.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public class GetDataThread implements Runnable {

		@Override
		public void run() {
			ArrayList<String> list = StockListHandler.getStockList();
			if (list.isEmpty()) 
				System.out.println("empty list");
			for (String name : list) {
				System.out.println(name);
			}
		}
	}

}
