package com.example.yogeshwaraass.myapplication;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.InputMismatchException;

/**
 * Created by Palaniappan on 7/7/2018.
 */

public class HTTPHandler {
    public String makeServiceCall(String requrl){
        String response=null;
        try{
            URL url=new URL(requrl);
            HttpURLConnection conn=(HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            //To read The Response
            InputStream in=new BufferedInputStream(conn.getInputStream());
            response=convertStringtoStream(in);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return response;
    }

    private String convertStringtoStream(InputStream in) {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb=new StringBuilder();
        String line;
        try{
            while((line=reader.readLine())!=null){
                sb.append(line).append("\n");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                in.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
    }
