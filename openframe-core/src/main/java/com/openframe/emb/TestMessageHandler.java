package com.openframe.emb;

import com.zte.ums.uep.api.pfl.emb.EMBException;
import com.zte.ums.uep.api.pfl.emb.EMessage;
import com.zte.ums.uep.api.pfl.emb.EMessageHandler;
import com.zte.ums.uep.pfl.emb.service.InnerEMessage;

public class TestMessageHandler implements EMessageHandler {

	@Override
	public EMessage request(EMessage msg) throws EMBException {
		
		System.out.println("testMessageHandler..mml = "+msg.getMML());
		
//		System.out.println("收到消息");
//		dMsg.keyInfo("testMessageHandler..mml = " + requestMessage.getMML());
//		count ++;
//    	if (count == 5000){
//    		beginTime = System.currentTimeMillis();
//    	}
//    	if (count == 8000){
//    		endTime = System.currentTimeMillis() - beginTime;
//    		dMsg.keyInfo(((count-5000)*1000/endTime + "条/s"));
//    	}
    	/*List list = requestMessage.getAllMessageObject();
    	
    	for (int i=0; list!=null && list.size()>0&&i<list.size(); i++)
    	{
    		((EMessageObject)list.get(i)).toString();
    	}*/
		return new InnerEMessage(20000000);
	}


}
