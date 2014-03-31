package com.example.speedlatency;

import android.os.Bundle;
import android.support.v4.app.Fragment;
//import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.ByteArrayBuffer;
import android.util.Log;
import android.net.TrafficStats;

public class MainActivity{
 
        private static final String YOUR_HOST = null;
		private final String PATH = "/data/data/com.helloandroid.imagedownloader/";  //put the downloaded file here
       
        
        public void DownloadFromUrl(String imageURL, String fileName) {  //this is the downloader method
        	long BeforeTime = System.currentTimeMillis();
        	long TotalRxBeforeTest = TrafficStats.getTotalTxBytes();
        	long TotalTxBeforeTest = TrafficStats.getTotalRxBytes();
        	String testing[] = null; 
        		try {
                        URL url = new URL("http://web.mit.edu/21w.789/www/papers/griswold2004.pdf"); //you can write here any link
                        File file = new File(fileName);
 
                        long startTime = System.currentTimeMillis();
                        Log.d("ImageManager", "download begining");
                        Log.d("ImageManager", "download url:" + url);
                        Log.d("ImageManager", "downloaded file name:" + fileName);
                        /* Open a connection to that URL. */
                        URLConnection ucon = url.openConnection();
 
                        /*
                         * Define InputStreams to read from the URLConnection.
                         */
                        InputStream is = ucon.getInputStream();
                        BufferedInputStream bis = new BufferedInputStream(is);
 
                        /*
                         * Read bytes to the Buffer until there is nothing more to read(-1).
                         */
                        ByteArrayBuffer baf = new ByteArrayBuffer(50);
                        int current = 0;
                        while ((current = bis.read()) != -1) {
                                baf.append((byte) current);
                        }
 
                        /* Convert the Bytes read to a String. */
                        FileOutputStream fos = new FileOutputStream(file);
                        fos.write(baf.toByteArray());
                        fos.close();
                        Log.d("ImageManager", "download ready in"
                                        + ((System.currentTimeMillis() - startTime) / 1000)
                                        + " sec");
 
                } catch (IOException e) {
                        Log.d("ImageManager", "Error: " + e);
                }
 
        		long TotalRxAfterTest = TrafficStats.getTotalTxBytes();
        	    long TotalTxAfterTest = TrafficStats.getTotalRxBytes();
        	    long AfterTime = System.currentTimeMillis();

        	    double TimeDifference = AfterTime - BeforeTime;

        	    double rxDiff = TotalRxAfterTest - TotalRxBeforeTest;
        	    double txDiff = TotalTxAfterTest - TotalTxBeforeTest;

        	    if((rxDiff != 0) && (txDiff != 0))
        	    {
        	    double rxBPS = (rxDiff / (TimeDifference/1000)); // total rx bytes per second.
        	    double txBPS = (txDiff / (TimeDifference/1000)); // total tx bytes per second.
        	    testing[0] = String.valueOf(rxBPS) + "bps. Total rx = " + rxDiff;
        	    testing[1] = String.valueOf(txBPS) + "bps. Total tx = " + txDiff;
        	    }
        	    else
        	    {
        	    testing[0] = "No uploaded or downloaded bytes.";
        	    }
        	    
        	    
        	    ///// Latency test
        	    long time[] = null; // ?? 
        	    String host = YOUR_HOST;
        	    HttpGet request = new HttpGet(host);
        	    HttpParams httpParameters = new BasicHttpParams();
        	    HttpConnectionParams.setConnectionTimeout(httpParameters, 3000);
        	    HttpClient httpClient = new DefaultHttpClient(httpParameters);
        	    	    for(int i=0; i<5; i++)
        	    	    {
        	    	    long BeforeTime2 = System.currentTimeMillis();
        	    	    try {
							HttpResponse response = httpClient.execute(request);
						} catch (ClientProtocolException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
        	    	    long AfterTime2 = System.currentTimeMillis();
        	    	    Long TimeDifference2 = AfterTime2 - BeforeTime2;
        	    	    time[i] = TimeDifference2; 
        	    	     }
        }
}
