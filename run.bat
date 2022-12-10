@echo off
cls
call rmdir /s /q reports
call mvn clean install
echo Press anything to exit :D
Pause>Nul
