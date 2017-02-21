package com.test;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.libraries.BaseLib;

public class JsonFileCreation {

	@Test
	public void jsonWrite()
	{
	
    JSONObject obj = new JSONObject();
    	obj.put("name", "xyz");
    	obj.put("age", new Integer(100));	
    	
    JSONArray list = new JSONArray();
    	list.add("msg 1");
    	list.add("msg 2");
    	list.add("msg 3");

    obj.put("messages", list);

    try (FileWriter file = new FileWriter(BaseLib.sDirPath+"\\json\\test.json")) 
    {

        file.write(obj.toJSONString());
        file.flush();

    } catch (IOException e) {
        e.printStackTrace();
    }

    System.out.print(obj);

}

	
	
	
}
