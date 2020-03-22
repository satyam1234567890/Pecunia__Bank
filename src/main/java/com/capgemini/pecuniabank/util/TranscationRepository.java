package com.capgemini.pecuniabank.util;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.pecuniabank.dto.Transcation;

public class TranscationRepository {
	static List <Transcation> transcationData=new ArrayList <Transcation>();
/*
	public ArrayList<Transcation> getChequedata() {
		return transcationData;
	}
*/
	public TranscationRepository(Transcation transcation) {
		transcationData.add(transcation);
		/*for(Transcation chq:transcationData)
		{
			System.out.println(chq);
		}*/
	}
}
