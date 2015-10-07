package com.pineone.icbms.so.context.controller;

import com.pineone.icbms.so.context.model.ContextModel;
import com.pineone.icbms.so.context.model.Occurrence;
import com.pineone.icbms.so.context.service.OccurService;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Melvin on 15. 10. 1..
 */

@Controller
public class ContextProviderController {


    @Autowired
    OccurService occurService;

    @RequestMapping(value = "/resource/getocc", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public HttpResponse getOccByContext(@RequestBody ContextModel contextModel){
        HttpResponse response = occurService.requestPostData(OccurService.SIDEVICECONTROL, contextModel);

        return response;
    }


//    @RequestMapping(value = "/resource/occ", method = RequestMethod.POST)
//    @ResponseBody
//    public Occurrence getOccbyContext(@RequestBody Occurrence occurrence)
//    {
//
//
//        return occurrence;
//
//    }

    @RequestMapping(value = "/resource/occ", method = RequestMethod.POST)
    @ResponseBody
    public Occurrence getEmergencyContext(@RequestBody Occurrence occurrence)
    {
        System.out.println("Request data message");
        //System.out.println(occurrence.toString());

//        JSONObject object = new JSONObject();
//        object.put("code","200");
//        object.put("message","Success");
//        object.put("content", jsonObject);


        return occurrence;

    }

//    @RequestMapping(value = "/resource/occ", method = RequestMethod.POST)
//    @ResponseBody
//    public JSONObject getEmergencyContext(@RequestBody JSONObject jsonObject)
//    {
//        System.out.println("Request Json data message");
//        System.out.println(jsonObject.toJSONString());
//
////        JSONObject object = new JSONObject();
////        object.put("code","200");
////        object.put("message","Success");
////        object.put("content", jsonObject);
//
//
//        return jsonObject;

    }





