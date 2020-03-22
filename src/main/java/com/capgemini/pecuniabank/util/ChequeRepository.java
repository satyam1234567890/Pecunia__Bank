package com.capgemini.pecuniabank.util;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.pecuniabank.dto.Cheque;

public class ChequeRepository {
	static List <Cheque> chequedata=new ArrayList <Cheque>();
/*
	public ArrayList<Cheque> getChequedata() {
		return chequedata;
	}
	*/

	public ChequeRepository(Cheque cheque) {
		chequedata.add(cheque);
		/*for(Cheque chq:chequedata)
		{
			System.out.println(chq);
		}*/
	}
	

}
