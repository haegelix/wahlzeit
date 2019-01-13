package org.wahlzeit;

import java.lang.annotation.Repeatable;

@Repeatable(value = DesignPatterns.class)
public @interface DesignPattern {
	String name() default "";
	String[] participants() default "";
}
