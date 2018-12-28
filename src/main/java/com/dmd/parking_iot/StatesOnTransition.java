package com.dmd.parking_iot;

import org.springframework.statemachine.annotation.OnTransition;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation used to make Spring Statemachine annotation @OnTransition type safe.
 * Otherwise, @OnTransition would be String based, rather than tied to valid enum values.
 * @see <a href="https://docs.spring.io/autorepo/docs/spring-statemachine/1.0.0.M3/reference/html/sm-context.html">Spring Statemachine Context Integration</a>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@OnTransition
@interface StatesOnTransition {

    ParkingSpaceStates[] source() default {};
    ParkingSpaceStates[] target() default {};
}
