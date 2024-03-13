@echo off
cd "apache-tomcat\bin"
call startup.bat
start http://localhost:8080/dbProject/
