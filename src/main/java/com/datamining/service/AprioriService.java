package main.java.com.datamining.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import main.java.com.datamining.dao.CommonDAO;
import main.java.com.datamining.model.AprioriRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AprioriService {

	private static int count=0;
	
	@Autowired
	private CommonDAO commoDao;
	public void generateItemSet(String[] s, int maxcount) {
		commoDao.removeAprioriRecords();
		count=1;
		int n,min;
		int max=0;
		int maxLen=0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String trans[]=s;
		n=trans.length;
		
		for(int i=0;i<n;i++)
		{
			
			for(int j=0;j<trans[i].length();j++)
			{
				if(Integer.parseInt(""+trans[i].charAt(j))>max)
					max=Integer.parseInt(""+trans[i].charAt(j));
			}
		}
		
		min=maxcount;
		String str="";
		for(int i=1;i<=max;i++)
			str+=""+i;
		ArrayList al;
		max=0;
		ArrayList<String> allItems=new ArrayList<String>();
		for(int i=1;i<=str.length();i++)
		{
			al=permutationsOf(str.substring(0,i));
			for(int j=0;j<al.size();j++)
			{
				allItems.add(""+al.get(j));
				if(new String(""+al.get(j)).length()>max)
					max=new String(""+al.get(j)).length();
			}
		}
		ArrayList<String> arr[]=new ArrayList[max];
		for(int i=0;i<max;i++)
			arr[i]=new ArrayList<String>();
		for(int j=0;j<allItems.size();j++)
			arr[( allItems.get(j).length())-1].add(allItems.get(j));
		int count[]=new int[allItems.size()],l=0;
		int flag=0;
		for(int i=0;i<max;i++)
		{
			for(int j=0;j<arr[i].size();j++)
			{
				for(int k=0;k<n;k++)
				{
					for(int m=0;m<(arr[i].get(j).length());m++)
					{
						if(trans[k].indexOf(arr[i].get(j).charAt(m))==-1)
							flag=1;
					}
					if(flag==0)
						count[l]+=1;
					flag=0;
				}
				l++;
			}
		}
		int k=0;
		for(int i=0;i<max;i++)
		{
			for(int j=0;j<arr[i].size();j++)
			{
				if(count[k]>=min)
				{
					if(maxLen<arr[i].get(j).length())
						maxLen=arr[i].get(j).length();
				}
				k++;
			}
		}
		k=0;
		System.out.println("Frequent Itemsets are ");
		for(int i=0;i<max;i++)
		{
			for(int j=0;j<arr[i].size();j++)
			{
				if(count[k]>=min)
				{
						System.out.println(arr[i].get(j)+" "+count[k]);
						insertFrequentlyGeneratedset(arr[i].get(j),count[k]);
				}
				k++;
			}
		}
		
	}

	private void insertFrequentlyGeneratedset(String string, int i) {
		
		int number = Integer.parseInt(string);
		for(;(number%10)>0;)
		{
			int temp = number%10;
			AprioriRecord a = new AprioriRecord();
			a.setSet_id(count);
			a.setMinSupport(i);
			a.setProduct_id(temp);
			try {
				commoDao.create(a);
				System.out.println("Product ID"+temp);
				System.out.println("Product count"+count);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
			number=number/10;
			
		}
		count++;
	}

	@SuppressWarnings("unchecked")
	private ArrayList permutationsOf(String str) {

		String temp="",match="";
		int flag=0;
		ArrayList<String> result=new ArrayList<String>();
		if(str.length()==1)
		{
			result.add(str);
			return result;
		}
		else
		{
			char ch=str.charAt(0);
			String rem=str.substring(1);
			ArrayList<String> a=permutationsOf(rem);
			for(String p:a)
			{
				result.add(p);
				ArrayList addn=insertItems(ch,p);
				for(int i=0;i<addn.size();i++)
				{
					match=(String)addn.get(i);
					flag=0;
					for(int j=i+1;j<addn.size();j++)
					{
						temp=(String)addn.get(j);
						for(int k=0;k<temp.length();k++)
						{
							for(int l=0;l<match.length();l++)
							{
								if(temp.charAt(k)==match.charAt(l))
									flag++;
							}
						}
						if(flag>=match.length())
							addn.remove(j);
					}
				}
				result.addAll(addn);
			}
			return(result);
		}
	
	}

	private ArrayList insertItems(char c, String str) {

		String temp="",match="";
		int flag=0;
		ArrayList<String> res=new ArrayList<String>();
		for(int i=0;i<=str.length();i++)
		{
			res.add(str.substring(0,i)+c+str.substring(i));
		}
		for(int i=0;i<res.size();i++)
		{
			match=(String)res.get(i);
			flag=0;
			for(int j=i+1;j<res.size();j++)
			{
				temp=(String)res.get(j);
				for(int k=0;k<temp.length();k++)
				{
					for(int l=0;l<match.length();l++)
					{
						if(temp.charAt(k)==match.charAt(l))
							flag++;
					}
				}
				if(flag>=match.length())
					res.remove(j);
			}
		}
		return(res);
	
	}

	
}
