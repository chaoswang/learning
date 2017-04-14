package com.github.chaoswang.learning.java.guava;

import org.junit.Test;

import com.google.common.base.Optional;

public class OptionalTest {

	@Test
	public void testOptional(){
		Optional<Integer> possible=Optional.of(6);
        if(possible.isPresent()){
            System.out.println("possible isPresent:"+possible.isPresent());
            System.out.println("possible value:"+possible.get());
        }
	}
}
