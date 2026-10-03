@echo off
echo ==========================================
echo Running Advanced Java Programs (Windows)
echo ==========================================

echo.
echo --- 1. List interface ---
java -cp . ListDemo

echo.
echo --- 2. Set interface ---
java -cp . SetDemo

echo.
echo --- 3. Queue interface ---
java -cp . QueueDemo

echo.
echo --- 4. Access elements of Collections ---
java -cp . AccessDemo
echo.

echo.
echo --- 5. Comparator interface ---
java -cp . ComparatorDemo

echo.
echo --- 6. Collection algorithms ---
java -cp . AlgoDemo

echo.
echo --- 7. Simple Bean (BeanDemo) ---
cd BeanDemo
java Demo
cd ..

echo.
echo --- 8. XML DOM Parser (XmlDemo) ---
cd XmlDemo
java ParseDom
cd ..

echo.
echo --- 9. XML DOM Manipulator (XmlDemo) ---
cd XmlDemo
java ManipulateDom
cd ..

echo.
echo --- 10 ^& 11. Servlets ---
echo Pre-compiled classes in tomcat/webapps/ArithApp/ and LoginApp/

echo.
echo --- 12 ^& 13. JSP ---
echo JSP files in tomcat/webapps/JspApp/

echo.
echo --- 14 ^& 15. JDBC ---
echo Pre-compiled in JdbcDemo/ (requires active MySQL 'college' database)

echo.
echo --- 16. TCP Sockets ---
start /b java FactServer
timeout /t 1 /nobreak >nul
java FactClient

echo.
echo --- 17. UDP Sockets ---
start /b java UDPReceiver
timeout /t 1 /nobreak >nul
java UDPSender

echo.
echo ==========================================
echo Done!
echo ==========================================
pause
