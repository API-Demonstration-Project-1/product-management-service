/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.17).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.proarchs.product.api.autogenerated;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.proarchs.product.model.Error;
import com.proarchs.product.model.Product;
import com.proarchs.product.model.Productresponse1;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-02T06:47:09.808Z")

@Api(value = "${com.proarchs.product.api.name}", description = "the product API")
@RequestMapping(value = "${com.proarchs.product.api.basepath}")
public interface ProductApi {

	@ApiOperation(value = "ProductByProductId_DELETE", nickname = "productByProductIdDELETE", notes = "Delete a Product by productId", tags={ "product", })
	@ApiResponses(value = { 
			@ApiResponse(code = 204, message = ""),
			@ApiResponse(code = 404, message = "TODO: Add error message", response = Error.class) })
	@RequestMapping(value = "${com.proarchs.product.api.delete.path}",
	produces = { "application/json" }, 
	consumes = { "application/json" },
	method = RequestMethod.DELETE)
	ResponseEntity<String> productByProductIdDELETE(@ApiParam(value = "",required=true) @PathVariable("productId") Integer productId);


	@ApiOperation(value = "ProductByProductId_GET", nickname = "productByProductIdGET", notes = "Get a Product by productId", response = Product.class, tags={ "product", })
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "", response = Product.class),
			@ApiResponse(code = 404, message = "TODO: Add error message", response = Error.class) })
	@RequestMapping(value = "/product/{productId}",
	produces = { "application/json" }, 
	consumes = { "application/json" },
	method = RequestMethod.GET)
	ResponseEntity<String> productByProductIdGET(@ApiParam(value = "",required=true) @PathVariable("productId") Integer productId);


	@ApiOperation(value = "ProductByProductId_POST", nickname = "productByProductIdPOST", notes = "Product using Username & Password", response = Productresponse1.class, tags={ "product", })
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "", response = Productresponse1.class),
			@ApiResponse(code = 400, message = "TODO: Add error message", response = Error.class) })
	@RequestMapping(value = "/product/{productId}",
	produces = { "application/json" }, 
	consumes = { "application/json" },
	method = RequestMethod.POST)
	ResponseEntity<String> productByProductIdPOST(@ApiParam(value = "",required=true) @PathVariable("productId") Integer productId,@ApiParam(value = "" ,required=true )  @Valid @RequestBody Product body);


	@ApiOperation(value = "ProductByProductId_PUT", nickname = "productByProductIdPUT", notes = "Update a Product by productId", response = Product.class, tags={ "product", })
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "", response = Product.class),
			@ApiResponse(code = 404, message = "TODO: Add error message", response = Error.class) })
	@RequestMapping(value = "/product/{productId}",
	produces = { "application/json" }, 
	consumes = { "application/json" },
	method = RequestMethod.PUT)
	ResponseEntity<String> productByProductIdPUT(@ApiParam(value = "",required=true) @PathVariable("productId") Integer productId,
			@ApiParam(value = "" ,required=true ) @RequestBody Product body);
	//ResponseEntity<String> productByProductIdPUT(@ApiParam(value = "",required=true) @PathVariable("productId") Integer productId,
	//		@ApiParam(value = "" ,required=true )  @Valid @RequestBody Product body);

	@ApiOperation(value = "Product_GET", nickname = "productGET", notes = "Get a list of Product", response = Product.class, responseContainer = "List", tags={ "product", })
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "", response = Product.class, responseContainer = "List") })
	@RequestMapping(value = "/product",
	produces = { "application/json" }, 
	consumes = { "application/json" },
	method = RequestMethod.GET)
	ResponseEntity<String> productGET(@ApiParam(value = "Get List of Tenant Info based on a given Tenant Name") @Valid @RequestParam(value = "productName", required = false) String productName,@ApiParam(value = "Get List of Tenant Info based on a given Tenant Email") @Valid @RequestParam(value = "productCategory", required = false) String productCategory);


	@ApiOperation(value = "Product_POST", nickname = "productPOST", notes = "Add a new Product", response = Productresponse1.class, tags={ "product", })
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "", response = Productresponse1.class) })
	@RequestMapping(value = "/product",
	produces = { "application/json" }, 
	consumes = { "application/json" },
	method = RequestMethod.POST)
	ResponseEntity<String> productPOST(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Product body);

}
