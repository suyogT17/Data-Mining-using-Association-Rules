package main.java.com.datamining.controller;

import org.springframework.beans.factory.annotation.Autowired;

import main.java.com.datamining.service.AprioriScheduler;

public class Suyog {

	/**
	 * @param args
	 */
	@Autowired
	private static AprioriScheduler apriorischeduler;
	public static void main(String arg[]) {
		
		// TODO Auto-generated method stub
		apriorischeduler.runAprioriAlgorihtem();
	}

}
