package edu.zxy.apple.entity;

import java.lang.annotation.Retention;

import org.hibernate.annotations.ValueGenerationType;
import java.lang.annotation.RetentionPolicy;

@ValueGenerationType(generatedBy = FunctionCreationDatetimeGeneration.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface FunctionCreationDatetime {

}
