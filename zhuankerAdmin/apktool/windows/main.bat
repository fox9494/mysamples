set /a StartS=%time:~6,2%
set /a StartM=%time:~3,2%
@set BASE_PATH=D:\apktool
call apktool d Octopus.apk source
CD %BASE_PATH%
call apktool b %BASE_PATH%\source %BASE_PATH%\Octopus2.apk
CD %BASE_PATH%
call jarsigner -verbose -keystore Octopus.keystore -storepass Octopus -keypass Octopus -signedjar Octopus2_sign.apk Octopus2.apk Octopus.keystore
@echo ok
set /a EndS=%time:~6,2%
set /a EndM=%time:~3,2%
set /a diffS_=%EndS%-%StartS%
set /a diffM_=%EndM%-%StartM%
echo 程序运行时间： %diffM_%分钟%diffS_%秒
pause

