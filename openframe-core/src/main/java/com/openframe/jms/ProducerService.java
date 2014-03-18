package com.openframe.jms;

import javax.jms.Destination;

import com.openframe.webservice.TestEntity;

public interface ProducerService {
	
	
	/*public void sendMessage(Destination destination, final String message);*/
	
	
	public void sendMessage(Destination destination, final TestEntity message);

}
