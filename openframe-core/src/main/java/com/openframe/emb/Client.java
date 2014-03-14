package com.openframe.emb;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.zte.ums.api.FrameServiceAccess;
import com.zte.ums.emb.uep.impl.EMBLibInit;
import com.zte.ums.uep.api.pfl.emb.EInteger;
import com.zte.ums.uep.api.pfl.emb.EMBService;
import com.zte.ums.uep.api.pfl.emb.EMBUrl;
import com.zte.ums.uep.api.pfl.emb.EMessage;
import com.zte.ums.uep.api.pfl.emb.EString;

public class Client {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		

		boolean clientMode = true;
		if (args != null && args.length > 0){
			if ("wait".equals(args[0]) || "true".equals(args[0])){
				clientMode = false;
			}
		}
		
		EMBLibInit.setFileFolds(new String[]{"conf/test-config"});
		EMBLibInit.setClientMode(clientMode);
		
		int listenerPort = 30007;
		if (!clientMode){
			listenerPort = 30008;
			if (args.length > 1){
				listenerPort = Integer.parseInt(args[1]);
			}
		}
		
		EMBLibInit.setListenerPort(listenerPort);
		EMBLibInit.start();
		
		
		
//		Path destPath = Path.getInstanceByString("EMS/main/cn/cn-test/emf");
		EMBService embService = FrameServiceAccess.getEMBService();
		
		EMBUrl emburl = new EMBUrl("localhost", 30008);
//		embService.registerNotification("TESTLV_MAILBOX", new MmlNotifyListener(), destPath);
		
		if (clientMode){
			Random random = new Random();
			EMessage emessage = embService.new3XEMessage(20001406, emburl);
//    		EMessage emessage = embService.newEMessage(20001406,destPath,destPath);
        	emessage.addMessageObject(new EString("HELLO ALONE"));
        	emessage.addMessageObject(new EInteger(123));
        	
        	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");//设置日期格式
        	String start = df.format(new Date());
    		
    		
    		for (int i = 0; i < 10000; i++) {
    			embService.syncRequest(emessage);
			}
    		
    		System.out.println("start time:"+start);
    		System.out.println("end time:"+df.format(new Date()));
//	    	while(true){
//	    		EMessage emessage = embService.new3XEMessage(20001406, emburl);
//	    		EMessage emessage = embService.newEMessage(20001406,destPath,destPath);
//	        	emessage.addMessageObject(new EString("HELLO ALONE"));
//	        	emessage.addMessageObject(new EInteger(123));
//	        	
//	    		int i = random.nextInt()%4;
//	    		i=0;
//	    		i = Math.abs(i);
//				if (i ==0){
//					embService.syncRequest(emessage);
//				}
//				else if(i == 1){
////					embService.asyncRequest(emessage, new MmlAsyncListener());
//				}
//				else if(i == 2){
//					embService.asyncRequest(emessage);
//				}
//				else{
////					embService.sendNotification("TESTLV_MAILBOX", emessage);
//				}
//				
//			   Thread.sleep(1000);
//	    	}
		}

		
		
	
		
//		EMBService embService = FrameServiceAccess.getEMBService();
//		EMBUrl emburl = new EMBUrl("localhost", 30008);
//		EMessage eMessage = embService.new3XEMessage(20001406, emburl);
//		eMessage.addMessageObject(new EString("hello world"));
//		eMessage.addMessageObject(new EInteger(123));
//		embService.syncRequest(eMessage);
	}

}
