#!/usr/bin/env bash
set -e

echo "=========================================="
echo "Running Advanced Java Programs"
echo "=========================================="

echo ""
echo "--- 1. List interface ---"
java -cp . ListDemo

echo ""
echo "--- 2. Set interface ---"
java -cp . SetDemo

echo ""
echo "--- 3. Queue interface ---"
java -cp . QueueDemo

echo ""
echo "--- 4. Access elements of Collections ---"
java -cp . AccessDemo
echo ""

echo ""
echo "--- 5. Comparator interface ---"
java -cp . ComparatorDemo

echo ""
echo "--- 6. Collection algorithms ---"
java -cp . AlgoDemo

echo ""
echo "--- 7. Simple Bean (BeanDemo) ---"
(cd BeanDemo && java Demo)

echo ""
echo "--- 8. XML DOM Parser (XmlDemo) ---"
(cd XmlDemo && java ParseDom)

echo ""
echo "--- 9. XML DOM Manipulator (XmlDemo) ---"
(cd XmlDemo && java ManipulateDom)
echo ""

echo ""
echo "--- 10 & 11. Servlets ---"
echo "Compiled classes present in tomcat/webapps/ArithApp/WEB-INF/classes/ and LoginApp/WEB-INF/classes/"

echo ""
echo "--- 12 & 13. JSP ---"
echo "JSP scripts present in tomcat/webapps/JspApp/"

echo ""
echo "--- 14 & 15. JDBC ---"
echo "Compiled classes in JdbcDemo/ (requires active MySQL 'college' DB)"

echo ""
echo "--- 16. TCP Sockets (Factorial) ---"
java FactServer &
TCP_PID=$!
sleep 0.4
java FactClient
wait $TCP_PID

echo ""
echo "--- 17. UDP Sockets (Object Transfer) ---"
java UDPReceiver &
UDP_PID=$!
sleep 0.4
java UDPSender
wait $UDP_PID

echo ""
echo "=========================================="
echo "All runnable programs completed successfully!"
echo "=========================================="
