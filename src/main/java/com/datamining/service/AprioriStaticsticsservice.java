package main.java.com.datamining.service;

import java.util.ArrayList;
import java.util.List;

import main.java.com.datamining.dao.CommonDAO;
import main.java.com.datamining.dto.AprioriDTO;
import main.java.com.datamining.model.AprioriRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AprioriStaticsticsservice {

	@Autowired
	private CommonDAO commonDAO;
	@SuppressWarnings("unchecked")
	public List<AprioriDTO> getAprioriSet()
	{
		List<AprioriRecord> recordset = new ArrayList<AprioriRecord>();
		
		recordset = commonDAO.getObjectList(new AprioriRecord());
		
		//remove following hardcoding
		/*AprioriRecord a = new AprioriRecord();
		a.setAR_id(1);
		a.setMinSupport(2);
		a.setSet_id(1);
		a.setProduct_id(1);
		
		AprioriRecord a1 = new AprioriRecord();
		a1.setAR_id(2);
		a1.setMinSupport(2);
		a1.setSet_id(1);
		a1.setProduct_id(2);
		
		AprioriRecord a2 = new AprioriRecord();
		a2.setAR_id(3);
		a2.setMinSupport(2);
		a2.setSet_id(2);
		a2.setProduct_id(2);
		
		AprioriRecord a3 = new AprioriRecord();
		a3.setAR_id(4);
		a3.setMinSupport(2);
		a3.setSet_id(2);
		a3.setProduct_id(3);
		
		AprioriRecord a4 = new AprioriRecord();
		a4.setAR_id(5);
		a4.setMinSupport(3);
		a4.setSet_id(3);
		a4.setProduct_id(1);
		
		AprioriRecord a5 = new AprioriRecord();
		a5.setAR_id(6);
		a5.setMinSupport(3);
		a5.setSet_id(3);
		a5.setProduct_id(2);
		
		AprioriRecord a6 = new AprioriRecord();
		a6.setAR_id(7);
		a6.setMinSupport(3);
		a6.setSet_id(3);
		a6.setProduct_id(3);
		
		recordset.add(a);
		recordset.add(a1);
		recordset.add(a2);
		recordset.add(a3);
		recordset.add(a4);
		recordset.add(a5);
		recordset.add(a6);
		*/
		List<AprioriDTO> listdto = convertAprioriDto(recordset);
		return listdto;
		
	}
	
	
	public List<AprioriDTO> convertAprioriDto(List<AprioriRecord> recordset) {
		// TODO Auto-generated method stub
		List<Integer> ids = new ArrayList<Integer>();
		List<AprioriDTO> dtolist = new ArrayList<AprioriDTO>();
		for(AprioriRecord ar : recordset)
		{
			if(!ids.contains(ar.getSet_id()))
			{
				String set ="{ ";
				ids.add(ar.getSet_id());
				for(AprioriRecord inr : recordset)
				{
					if(ar.getSet_id().equals(inr.getSet_id()))
					{
						set = set+inr.getProduct_id()+", ";
					}
				}
				set=set+"}";
				AprioriDTO adt = new AprioriDTO();
				adt.setMinsupport(ar.getMinSupport());
				adt.setProductIds(set);
				adt.setSetno(ar.getSet_id());
				dtolist.add(adt);
			}
		}
		return dtolist;
	}
}
