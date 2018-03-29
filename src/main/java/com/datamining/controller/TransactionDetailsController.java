package main.java.com.datamining.controller;

import java.io.IOException;
import java.util.List;


import main.java.com.datamining.dto.TransactionDTO;
import main.java.com.datamining.service.TransactionService;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TransactionDetailsController {
	
	@Autowired
	private TransactionService transactionservice;
	
	/*
	 * this shows all transaction to the admin
	 */
	@RequestMapping(value = "/viewalltransactions.html", method = RequestMethod.GET)
	public ModelAndView showTenantapprovalView() {

		//dofollowing();
		final ModelAndView view = new ModelAndView("viewalltransactions");
				return view;
	}
	

	@RequestMapping(value = "/viewalltransaction.html", method = RequestMethod.GET)
	@ResponseBody
	public String performSearchUser() {

		
		//List<User> users= customerService.findUsersByRoleId(new Integer(1));
		List<TransactionDTO> transactiondtolist= transactionservice.getTransactionList();
		
		
	
		String json = getJsonString(transactiondtolist);
		
		
	return json;
			
	}

	private String getJsonString(Object object) {
		// TODO Auto-generated method stub
		String json = null;
        ObjectMapper objectmapper = new ObjectMapper();
        try {
        json = objectmapper.writeValueAsString(object);
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
