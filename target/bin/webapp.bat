@REM ----------------------------------------------------------------------------
@REM  Copyright 2001-2006 The Apache Software Foundation.
@REM
@REM  Licensed under the Apache License, Version 2.0 (the "License");
@REM  you may not use this file except in compliance with the License.
@REM  You may obtain a copy of the License at
@REM
@REM       http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM  Unless required by applicable law or agreed to in writing, software
@REM  distributed under the License is distributed on an "AS IS" BASIS,
@REM  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@REM  See the License for the specific language governing permissions and
@REM  limitations under the License.
@REM ----------------------------------------------------------------------------
@REM
@REM   Copyright (c) 2001-2006 The Apache Software Foundation.  All rights
@REM   reserved.

@echo off

set ERROR_CODE=0

:init
@REM Decide how to startup depending on the version of windows

@REM -- Win98ME
if NOT "%OS%"=="Windows_NT" goto Win9xArg

@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" @setlocal

@REM -- 4NT shell
if "%eval[2+2]" == "4" goto 4NTArgs

@REM -- Regular WinNT shell
set CMD_LINE_ARGS=%*
goto WinNTGetScriptDir

@REM The 4NT Shell from jp software
:4NTArgs
set CMD_LINE_ARGS=%$
goto WinNTGetScriptDir

:Win9xArg
@REM Slurp the command line arguments.  This loop allows for an unlimited number
@REM of arguments (up to the command line limit, anyway).
set CMD_LINE_ARGS=
:Win9xApp
if %1a==a goto Win9xGetScriptDir
set CMD_LINE_ARGS=%CMD_LINE_ARGS% %1
shift
goto Win9xApp

:Win9xGetScriptDir
set SAVEDIR=%CD%
%0\
cd %0\..\.. 
set BASEDIR=%CD%
cd %SAVEDIR%
set SAVE_DIR=
goto repoSetup

:WinNTGetScriptDir
set BASEDIR=%~dp0\..

:repoSetup
set REPO=


if "%JAVACMD%"=="" set JAVACMD=java

if "%REPO%"=="" set REPO=%BASEDIR%\repo

set CLASSPATH="%BASEDIR%"\etc;"%REPO%"\com\sun\faces\jsf-api\2.2.15\jsf-api-2.2.15.jar;"%REPO%"\com\sun\faces\jsf-impl\2.2.15\jsf-impl-2.2.15.jar;"%REPO%"\net\bootsfaces\bootsfaces\1.4.0\bootsfaces-1.4.0.jar;"%REPO%"\org\primefaces\primefaces\6.2\primefaces-6.2.jar;"%REPO%"\org\primefaces\extensions\primefaces-extensions\6.2.9\primefaces-extensions-6.2.9.jar;"%REPO%"\com\google\code\gson\gson\2.8.2\gson-2.8.2.jar;"%REPO%"\org\apache\commons\commons-lang3\3.5\commons-lang3-3.5.jar;"%REPO%"\org\primefaces\themes\bootstrap\1.0.10\bootstrap-1.0.10.jar;"%REPO%"\org\springframework\security\spring-security-config\5.0.5.RELEASE\spring-security-config-5.0.5.RELEASE.jar;"%REPO%"\org\springframework\spring-aop\5.0.6.RELEASE\spring-aop-5.0.6.RELEASE.jar;"%REPO%"\org\springframework\spring-beans\5.0.6.RELEASE\spring-beans-5.0.6.RELEASE.jar;"%REPO%"\org\springframework\spring-context\5.0.6.RELEASE\spring-context-5.0.6.RELEASE.jar;"%REPO%"\org\springframework\spring-core\5.0.6.RELEASE\spring-core-5.0.6.RELEASE.jar;"%REPO%"\org\springframework\spring-jcl\5.0.6.RELEASE\spring-jcl-5.0.6.RELEASE.jar;"%REPO%"\org\springframework\security\spring-security-web\5.0.5.RELEASE\spring-security-web-5.0.5.RELEASE.jar;"%REPO%"\org\springframework\spring-expression\5.0.6.RELEASE\spring-expression-5.0.6.RELEASE.jar;"%REPO%"\org\springframework\spring-web\5.0.6.RELEASE\spring-web-5.0.6.RELEASE.jar;"%REPO%"\org\springframework\security\spring-security-taglibs\5.0.7.RELEASE\spring-security-taglibs-5.0.7.RELEASE.jar;"%REPO%"\org\springframework\security\spring-security-acl\5.0.7.RELEASE\spring-security-acl-5.0.7.RELEASE.jar;"%REPO%"\org\springframework\spring-jdbc\5.0.8.RELEASE\spring-jdbc-5.0.8.RELEASE.jar;"%REPO%"\org\springframework\spring-tx\5.0.8.RELEASE\spring-tx-5.0.8.RELEASE.jar;"%REPO%"\org\springframework\security\spring-security-core\5.0.5.RELEASE\spring-security-core-5.0.5.RELEASE.jar;"%REPO%"\org\jboss\weld\servlet\weld-servlet\2.4.8.Final\weld-servlet-2.4.8.Final.jar;"%REPO%"\org\hibernate\hibernate-validator\5.2.4.Final\hibernate-validator-5.2.4.Final.jar;"%REPO%"\org\jboss\logging\jboss-logging\3.2.1.Final\jboss-logging-3.2.1.Final.jar;"%REPO%"\com\fasterxml\classmate\1.1.0\classmate-1.1.0.jar;"%REPO%"\javax\validation\validation-api\1.1.0.Final\validation-api-1.1.0.Final.jar;"%REPO%"\org\hibernate\hibernate-core\4.3.0.Final\hibernate-core-4.3.0.Final.jar;"%REPO%"\org\jboss\logging\jboss-logging-annotations\1.2.0.Beta1\jboss-logging-annotations-1.2.0.Beta1.jar;"%REPO%"\org\jboss\spec\javax\transaction\jboss-transaction-api_1.2_spec\1.0.0.Final\jboss-transaction-api_1.2_spec-1.0.0.Final.jar;"%REPO%"\dom4j\dom4j\1.6.1\dom4j-1.6.1.jar;"%REPO%"\xml-apis\xml-apis\1.0.b2\xml-apis-1.0.b2.jar;"%REPO%"\org\hibernate\common\hibernate-commons-annotations\4.0.4.Final\hibernate-commons-annotations-4.0.4.Final.jar;"%REPO%"\org\hibernate\javax\persistence\hibernate-jpa-2.1-api\1.0.0.Final\hibernate-jpa-2.1-api-1.0.0.Final.jar;"%REPO%"\org\javassist\javassist\3.18.1-GA\javassist-3.18.1-GA.jar;"%REPO%"\antlr\antlr\2.7.7\antlr-2.7.7.jar;"%REPO%"\org\jboss\jandex\1.1.0.Final\jandex-1.1.0.Final.jar;"%REPO%"\org\hibernate\hibernate-entitymanager\4.3.0.Final\hibernate-entitymanager-4.3.0.Final.jar;"%REPO%"\org\springframework\boot\spring-boot-starter-web\1.2.0.RELEASE\spring-boot-starter-web-1.2.0.RELEASE.jar;"%REPO%"\org\springframework\boot\spring-boot-starter\1.2.0.RELEASE\spring-boot-starter-1.2.0.RELEASE.jar;"%REPO%"\org\springframework\boot\spring-boot\1.2.0.RELEASE\spring-boot-1.2.0.RELEASE.jar;"%REPO%"\org\springframework\boot\spring-boot-autoconfigure\1.2.0.RELEASE\spring-boot-autoconfigure-1.2.0.RELEASE.jar;"%REPO%"\org\springframework\boot\spring-boot-starter-logging\1.2.0.RELEASE\spring-boot-starter-logging-1.2.0.RELEASE.jar;"%REPO%"\org\slf4j\jcl-over-slf4j\1.7.7\jcl-over-slf4j-1.7.7.jar;"%REPO%"\org\slf4j\slf4j-api\1.7.7\slf4j-api-1.7.7.jar;"%REPO%"\org\slf4j\jul-to-slf4j\1.7.7\jul-to-slf4j-1.7.7.jar;"%REPO%"\org\slf4j\log4j-over-slf4j\1.7.7\log4j-over-slf4j-1.7.7.jar;"%REPO%"\ch\qos\logback\logback-classic\1.1.2\logback-classic-1.1.2.jar;"%REPO%"\ch\qos\logback\logback-core\1.1.2\logback-core-1.1.2.jar;"%REPO%"\org\yaml\snakeyaml\1.14\snakeyaml-1.14.jar;"%REPO%"\com\fasterxml\jackson\core\jackson-databind\2.4.4\jackson-databind-2.4.4.jar;"%REPO%"\com\fasterxml\jackson\core\jackson-annotations\2.4.0\jackson-annotations-2.4.0.jar;"%REPO%"\com\fasterxml\jackson\core\jackson-core\2.4.4\jackson-core-2.4.4.jar;"%REPO%"\org\springframework\spring-webmvc\4.1.3.RELEASE\spring-webmvc-4.1.3.RELEASE.jar;"%REPO%"\org\springframework\boot\spring-boot-starter-tomcat\1.2.0.RELEASE\spring-boot-starter-tomcat-1.2.0.RELEASE.jar;"%REPO%"\org\apache\tomcat\embed\tomcat-embed-el\8.0.15\tomcat-embed-el-8.0.15.jar;"%REPO%"\org\apache\tomcat\embed\tomcat-embed-logging-juli\8.0.15\tomcat-embed-logging-juli-8.0.15.jar;"%REPO%"\org\apache\tomcat\embed\tomcat-embed-websocket\8.0.15\tomcat-embed-websocket-8.0.15.jar;"%REPO%"\org\apache\tomcat\embed\tomcat-embed-core\8.5.23\tomcat-embed-core-8.5.23.jar;"%REPO%"\org\apache\tomcat\tomcat-annotations-api\8.5.23\tomcat-annotations-api-8.5.23.jar;"%REPO%"\org\apache\tomcat\embed\tomcat-embed-jasper\8.5.23\tomcat-embed-jasper-8.5.23.jar;"%REPO%"\org\eclipse\jdt\ecj\3.12.3\ecj-3.12.3.jar;"%REPO%"\org\apache\tomcat\tomcat-jasper\8.5.23\tomcat-jasper-8.5.23.jar;"%REPO%"\org\apache\tomcat\tomcat-servlet-api\8.5.23\tomcat-servlet-api-8.5.23.jar;"%REPO%"\org\apache\tomcat\tomcat-juli\8.5.23\tomcat-juli-8.5.23.jar;"%REPO%"\org\apache\tomcat\tomcat-el-api\8.5.23\tomcat-el-api-8.5.23.jar;"%REPO%"\org\apache\tomcat\tomcat-api\8.5.23\tomcat-api-8.5.23.jar;"%REPO%"\org\apache\tomcat\tomcat-util-scan\8.5.23\tomcat-util-scan-8.5.23.jar;"%REPO%"\org\apache\tomcat\tomcat-util\8.5.23\tomcat-util-8.5.23.jar;"%REPO%"\org\apache\tomcat\tomcat-jasper-el\8.5.23\tomcat-jasper-el-8.5.23.jar;"%REPO%"\org\apache\tomcat\tomcat-jsp-api\8.5.23\tomcat-jsp-api-8.5.23.jar;"%REPO%"\br\com\javaee\pocjavaee\0.0.1-SNAPSHOT\pocjavaee-0.0.1-SNAPSHOT.war

set ENDORSED_DIR=
if NOT "%ENDORSED_DIR%" == "" set CLASSPATH="%BASEDIR%"\%ENDORSED_DIR%\*;%CLASSPATH%

if NOT "%CLASSPATH_PREFIX%" == "" set CLASSPATH=%CLASSPATH_PREFIX%;%CLASSPATH%

@REM Reaching here means variables are defined and arguments have been captured
:endInit

%JAVACMD% %JAVA_OPTS%  -classpath %CLASSPATH% -Dapp.name="webapp" -Dapp.repo="%REPO%" -Dapp.home="%BASEDIR%" -Dbasedir="%BASEDIR%" launch.Main %CMD_LINE_ARGS%
if %ERRORLEVEL% NEQ 0 goto error
goto end

:error
if "%OS%"=="Windows_NT" @endlocal
set ERROR_CODE=%ERRORLEVEL%

:end
@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" goto endNT

@REM For old DOS remove the set variables from ENV - we assume they were not set
@REM before we started - at least we don't leave any baggage around
set CMD_LINE_ARGS=
goto postExec

:endNT
@REM If error code is set to 1 then the endlocal was done already in :error.
if %ERROR_CODE% EQU 0 @endlocal


:postExec

if "%FORCE_EXIT_ON_ERROR%" == "on" (
  if %ERROR_CODE% NEQ 0 exit %ERROR_CODE%
)

exit /B %ERROR_CODE%
