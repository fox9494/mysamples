package com.openframe.emb;

import com.zte.ums.emb.uep.impl.EMBLibInit;

public class EMBInit {
	
	
	public void init() throws Exception{
		EMBLibInit.setFileFolds(new String[]{"conf/emb-along-config.xml","conf/test-config"});
		EMBLibInit.start();
	}

	

}
