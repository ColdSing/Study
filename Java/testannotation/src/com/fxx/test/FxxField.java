package com.fxx.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = { ElementType.FIELD })
@Retention(value = RetentionPolicy.RUNTIME)
public @interface FxxField {
	String cloumName();
	String type();
	int length();
}
