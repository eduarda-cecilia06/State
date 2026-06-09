@echo off
cd /d "%~dp0"
echo Compilando...
javac -d . src/main/Main.java src/state/*.java src/util/*.java
if %errorlevel% neq 0 (
    echo Erro na compilacao!
    pause
    exit /b %errorlevel%
)
echo.
echo Executando...
echo ==================================================
java main.Main
echo ==================================================
pause