package main.java.com.datamining.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import main.java.com.datamining.dto.AprioriDTO;
import main.java.com.datamining.service.AprioriStaticsticsservice;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class AprioridataController {

	@Autowired
	private AprioriStaticsticsservice aprioriStaticsticsservice;
	
	/* @auther
	 * this method is used to display the result of tan algorithm in a table
	 */
	@RequestMapping(value="/aprioriresult.html",method=RequestMethod.GET)
	public String displayAprioriResult()
	{
		return "aprioriresults";
	}
	
	
	@RequestMapping(value = "/aprioriresults", method = RequestMethod.GET)
	@ResponseBody
	public String aprioriresultset() {
		
		
		 String json = null;
		 List<AprioriDTO> list = aprioriStaticsticsservice.getAprioriSet();
		 ObjectMapper objectmapper = new ObjectMapper();
		 try {
		 json = objectmapper.writeValueAsString(list);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return json;
	}
}
