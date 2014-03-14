rem set opt=-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=8790,server=y,suspend=n
java -Djava.ext.dirs=%~dp0% com.zte.ums.emb.uep.impl.EMBLibInit true
pause