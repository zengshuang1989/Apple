package edu.zxy.apple.entity;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.hibernate.annotations.ValueGenerationType;

@ValueGenerationType(generatedBy = FunctionLastUpdatedDatetimeGeneration.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface FunctionLastUpdatedDatetime {

}
