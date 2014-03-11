package com.openframe.ejb;

import org.springframework.stereotype.Service;

@Service("myComponent")
public class MyComponentImpl implements MyComponent {

	@Override
	public void myMethod() {
		System.out.println("this is var ejb invoke");
	}


}
