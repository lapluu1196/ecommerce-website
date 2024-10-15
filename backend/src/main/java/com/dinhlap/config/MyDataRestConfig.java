package com.dinhlap.config;

import com.dinhlap.entities.Product;
import com.dinhlap.entities.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        HttpMethod[] unSupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PATCH};

        // disable HTTP methods for Product: PUT, POST, DELETE, PATCH
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods
                        .disable(unSupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods
                        .disable(unSupportedActions));

        // disable HTTP methods for ProductCategory: PUT, POST, DELETE, PATCH
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods
                        .disable(unSupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods
                        .disable(unSupportedActions));
    }
}
