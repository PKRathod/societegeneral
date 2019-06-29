package com.socity.general.util;

public class ValidateUtil {

	public static void notNull(Object obj) throws RestException{
		if(obj==null)
			throw new RestException("object not found");
	}
	
}
