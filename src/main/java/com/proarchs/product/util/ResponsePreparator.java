package com.proarchs.product.util;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.proarchs.product.model.Data1;
import com.proarchs.product.model.Product;
import com.proarchs.product.model.ProductResponse;
import com.proarchs.product.model.Productresponse1;


@Component
public class ResponsePreparator {
	
	static {
		mapper = new ObjectMapper();
	}
	
	private static ObjectMapper mapper;
	
	private static boolean toExcludeNull;
	
	@Value("${config.response.format.exclude.null}")
	public void setToExcludeNull(boolean value) {
		toExcludeNull = value;
	}

	
	public static <E>  String serializeResponse(E element) {
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
        
        if (toExcludeNull)
        	mapper.setSerializationInclusion(Include.NON_NULL);
        else
        	mapper.setSerializationInclusion(Include.ALWAYS);
        
        String responseString = null;
        try {
        	
        	responseString = mapper.writeValueAsString(element);
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }
		return responseString;
	}
}
