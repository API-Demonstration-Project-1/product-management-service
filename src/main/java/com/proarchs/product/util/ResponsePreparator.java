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
	
	public static String prepareProductPOSTResponse(Object dataInfo, String msg, boolean isSuccess, Integer errorCode) throws IllegalAccessException, InstantiationException {
		Data1 data = null;
		
		if (dataInfo != null) {
			data = new Data1();
			data.setId(new Integer(dataInfo.toString()));
		}

		Productresponse1 productResponse1 = new Productresponse1();
		productResponse1.data(data)
						.errorCode(errorCode)
						.message(msg)
						.success(isSuccess);
        return serializeResponse(productResponse1);
	}
	


	public static String prepareProductGETResponse(Object dataInfo, String msg, boolean isSuccess, Integer errorCode) throws IllegalAccessException, InstantiationException {
		ProductResponse productresponse = null;
		if (dataInfo != null) {
			productresponse = new ProductResponse()
						   			.data((Product)dataInfo)
						   			.errorCode(errorCode)
						   			.message(msg)
						   			.success(isSuccess);
		}
		return serializeResponse(productresponse);
	}


	
	public static String prepareProductDeleteResponse(Object dataInfo, String msg, boolean isSuccess, Integer errorCode) {
		ProductResponse productResponse = null;
		if(dataInfo!=null) {
			productResponse = new ProductResponse();
			productResponse.setData((Product) dataInfo);
			productResponse.setMessage(msg);
			productResponse.setErrorCode(errorCode);
			productResponse.setSuccess(isSuccess);
		}
		return serializeResponse(productResponse);
	}

	
	// NOT USED
	/*
	 * public static List<Registration>
	 * prepareGETRegistrationResponse(List<TenantInfo> tenantInfoList) {
	 * ListIterator<TenantInfo> tenantInfoListIter = tenantInfoList.listIterator();
	 * List<Registration> regList = new ArrayList<Registration>();
	 * 
	 * while(tenantInfoListIter.hasNext()) { TenantInfo currentItem =
	 * tenantInfoListIter.next();
	 * 
	 * Registration regObj = new Registration();
	 * regObj.setTenantId(currentItem.getTenantId().toString());
	 * regObj.setTenantName(currentItem.getTenantName());
	 * regObj.setTenantUsername(currentItem.getTenantUsername());
	 * regObj.setTenantPassword(PTMSConstants.PASSWORD_FIELD_VALUE);
	 * regObj.setTenantEmail(currentItem.getTenantEmail());
	 * regObj.setTenantVerified(currentItem.getTenantVerified());
	 * 
	 * regList.add(regObj); }
	 * 
	 * return regList; }
	 */
	
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
