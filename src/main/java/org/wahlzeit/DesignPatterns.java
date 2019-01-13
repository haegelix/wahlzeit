package org.wahlzeit;

public @interface DesignPatterns {
	DesignPattern[] value();
	String name() default "";
	String[] participants() default "";
}
