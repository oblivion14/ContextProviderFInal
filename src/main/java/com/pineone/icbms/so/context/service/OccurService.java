package com.pineone.icbms.so.context.service;

import com.pineone.icbms.so.context.model.ContextModel;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;


/**
 * Created by Melvin on 15. 10. 1..
 */

@Service
public class OccurService {

    public static final String SIDEVICECONTROL = "http://localhost:8090/sda/occ";

//    public Occurrence getOccurence(ContextModel contextModel){
//        Occurrence occurrence = new Occurrence();

    public HttpResponse requestPostData(String uri, ContextModel contextModel){
        HttpResponse response = null;

        try {
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(uri);
            post.setHeader("Accept-Encoding", "identity");
            post.setHeader("Content-Type", "application/json");

            HttpEntity entity = new ByteArrayEntity(contextModel.toString().getBytes("UTF-8"));
            post.setEntity(entity);
            response = client.execute(post);

            String result = EntityUtils.toString(response.getEntity());
            System.out.println("Output from Server result data .... \n");
            System.out.println(result);

        } catch (ClientProtocolException e){
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }
}






//
//        return occurrence;
//    }


