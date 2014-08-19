package com.roy.springdatademo.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module.Feature;


public class HibernateAwareObjectMapper extends ObjectMapper {
	
	public HibernateAwareObjectMapper() {
		this.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        registerModule(new Hibernate4Module().configure(Feature.FORCE_LAZY_LOADING, true));
    }

}
