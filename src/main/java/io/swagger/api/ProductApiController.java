package io.swagger.api;

import io.swagger.model.Error;
import io.swagger.model.Product;
import io.swagger.model.Productresponse;

import com.ecomm.toystore.product.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-01T17:51:33.126Z")

@Controller
public class ProductApiController implements ProductApi {

    private static final Logger log = LoggerFactory.getLogger(ProductApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private ProductService prodsrv;

    @org.springframework.beans.factory.annotation.Autowired
    public ProductApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Product> getProductGET(@ApiParam(value = "",required=true) @PathVariable("productId") Integer productId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Product>(objectMapper.readValue("{  \"productLongName\" : \"productLongName\",  \"productAvailable\" : \"productAvailable\",  \"productImagesId\" : \"productImagesId\",  \"productSku\" : \"productSku\",  \"productCategoryId\" : 1,  \"productId\" : 0,  \"productUnitPrice\" : 5.962133916683182377482808078639209270477294921875,  \"productShortName\" : \"productShortName\",  \"productDescription\" : 6.02745618307040320615897144307382404804229736328125,  \"productTypeId\" : 5}", Product.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Product>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> productDELETE(@ApiParam(value = "",required=true) @PathVariable("productId") String productId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Product>> productGET(@ApiParam(value = "returns products based on product short name") @Valid @RequestParam(value = "productShortName", required = false) String productShortName,@ApiParam(value = "returns products based on category") @Valid @RequestParam(value = "productCategoryName", required = false) String productCategoryName) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	
                return new ResponseEntity<List<Product>>(objectMapper.readValue("[ {  \"productLongName\" : \"productLongName\",  \"productAvailable\" : \"productAvailable\",  \"productImagesId\" : \"productImagesId\",  \"productSku\" : \"productSku\",  \"productCategoryId\" : 1,  \"productId\" : 0,  \"productUnitPrice\" : 5.962133916683182377482808078639209270477294921875,  \"productShortName\" : \"productShortName\",  \"productDescription\" : 6.02745618307040320615897144307382404804229736328125,  \"productTypeId\" : 5}, {  \"productLongName\" : \"productLongName\",  \"productAvailable\" : \"productAvailable\",  \"productImagesId\" : \"productImagesId\",  \"productSku\" : \"productSku\",  \"productCategoryId\" : 1,  \"productId\" : 0,  \"productUnitPrice\" : 5.962133916683182377482808078639209270477294921875,  \"productShortName\" : \"productShortName\",  \"productDescription\" : 6.02745618307040320615897144307382404804229736328125,  \"productTypeId\" : 5} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Product>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Productresponse> productPOST(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Product body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	prodsrv.saveProduct(body);
                return new ResponseEntity<Productresponse>(objectMapper.readValue("{  \"success\" : true,  \"message\" : \"The Product has been created successfully\",  \"data\" : {    \"id\" : 123  }}", Productresponse.class), HttpStatus.CREATED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Productresponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Productresponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Productresponse> productPUT(@ApiParam(value = "",required=true) @PathVariable("productId") String productId,@ApiParam(value = "" ,required=true )  @Valid @RequestBody Product body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Productresponse>(objectMapper.readValue("{  \"success\" : true,  \"message\" : \"The Product has been updated successfully\",  \"data\" : {    \"id\" : 123  }}", Productresponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Productresponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Productresponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
