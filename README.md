# Advanced Java Practical (AJFP) Cheatsheet Solutions

Complete, production-tested implementations for all 17 Advanced Java Practical programs matching the **Advanced Java Practical Cheatsheet**.

---

## 💡 About `.class` Files & System Compatibility

> **"Will `.class` files work on every system, or will they be different?"**

* **Java bytecode is platform-independent:** A `.class` file or `.jar` compiled on Linux runs identically on Windows, macOS, and Linux without any changes.
* **The version compatibility factor:** The only risk across different machines (such as college lab PCs) is the Java version. If code is compiled with a newer Java runtime (e.g. Java 21 or 27), older lab PCs running Java 8 or 11 will throw `UnsupportedClassVersionError`.
* **Solution applied here:** All binaries and JARs in this repository were compiled targeting **Java 8 bytecode (`--release 8`)**. They will run out-of-the-box on Java 8, 11, 17, 21, and 27 on Windows, Linux, and macOS.
* **Included structure:**
  * Clean `.java` source code for all 17 practicals.
  * Executable `.jar` files in `jars/` for standalone programs.
  * Self-contained directories for Servlets & JSP (`tomcat/webapps/`), XML (`XmlDemo/`), Beans (`BeanDemo/`), and JDBC (`JdbcDemo/` with MySQL driver included).
  * Fast test runner scripts: `./test_all.sh` (Linux/macOS) and `test_all.bat` (Windows).

---

## 📂 Repository Directory Layout

```text
ajfp/
├── *.java                       # Direct standalone Java practicals (Collections, Sockets)
├── jars/                        # Pre-packaged executable JARs (Java 8 compatible)
├── BeanDemo/                    # Program 7: JavaBeans specification with manifest.mft & JAR
├── XmlDemo/                     # Programs 8 & 9: DOM XML parser & manipulator + student.xml
├── JdbcDemo/                    # Programs 14 & 15: JDBC CreateTable & InsertValues + MySQL driver
│   └── lib/
│       └── mysql-connector-j.jar
├── tomcat/                      # Programs 10, 11, 12, 13: Servlets & JSP webapps
│   ├── lib/
│   │   └── servlet-api.jar
│   └── webapps/
│       ├── ArithApp/            # Program 10: Arithmetic operations servlet
│       ├── LoginApp/            # Program 11: Student login servlet
│       └── JspApp/              # Programs 12 & 13: JSP scripts (hello.jsp, tags.jsp)
├── SocketDemo/                  # Socket programs categorized in TCP/ and UDP/
│   ├── TCP/                     # Program 16: Factorial calculation TCP client/server
│   └── UDP/                     # Program 17: Object serialization UDP sender/receiver
├── test_all.sh                  # One-command runner for Linux / macOS
└── test_all.bat                 # One-command runner for Windows
```

---

## 📋 Program Index & Execution Guide

### 1. Direct Programs (Collections)

| # | Program | Source File | Run Command | Expected Output |
|---|---|---|---|---|
| **1** | List interface | `ListDemo.java` | `java ListDemo` | `[Orange, Mango]`<br>`Mango true 2`<br>`Orange`<br>`Mango` |
| **2** | Set interface | `SetDemo.java` | `java SetDemo` | `2 true`<br>`[Python] [10, 30, 40]` |
| **3** | Queue interface | `QueueDemo.java` | `java QueueDemo` | `T1`<br>`T1`<br>`[T2, T3]` |
| **4** | Access elements | `AccessDemo.java` | `java AccessDemo` | `Red Green Blue`<br>`Blue Green Red`<br>`Red Green Blue` |
| **5** | Comparator | `ComparatorDemo.java` | `java ComparatorDemo` | `[Bob 92, Alice 85, Charlie 78]` |
| **6** | Collection algorithms | `AlgoDemo.java` | `java AlgoDemo` | `[10, 10, 20, 30, 40]`<br>`[40, 30, 20, 10, 10]`<br>`10 40`<br>`2`<br>`3` |

You can also run them using their standalone JARs:
```bash
java -jar jars/ListDemo.jar
java -jar jars/AlgoDemo.jar
```

---

### 2. JavaBeans (Program 7)

Location: `BeanDemo/`
* `SimpleBean.java`: Serializable bean class with private properties, no-arg constructor, getters, and setters.
* `manifest.mft`: Manifest file tagging `SimpleBean.class` as `Java-Bean: True`.
* `Demo.java`: Instantiates and tests the bean.

**Compile and package bean JAR:**
```bash
cd BeanDemo
javac *.java
jar cfm SimpleBean.jar manifest.mft SimpleBean.class
java Demo
# Output: 101 Loyola
```

---

### 3. XML Processing (Programs 8 & 9)

Location: `XmlDemo/`
* `student.xml`: XML dataset containing student nodes with `id`, `name`, and `grade`.
* `ParseDom.java`: Parses DOM tree using `DocumentBuilderFactory` and prints student details.
* `ManipulateDom.java`: Modifies existing node values, adds a `<dept>` element, and outputs modified XML using `Transformer`.

**Run:**
```bash
cd XmlDemo
java ParseDom
java ManipulateDom
```

---

### 4. Servlets & JSP (Programs 10, 11, 12, 13)

Location: `tomcat/webapps/`

#### Program 10: `ArithApp` (Arithmetic Servlet)
* Directory: `tomcat/webapps/ArithApp/`
* URL: `http://localhost:8080/ArithApp/index.html`
* Recompile if needed:
  ```bash
  javac -cp "../../lib/servlet-api.jar" -d WEB-INF/classes ArithServlet.java
  ```

#### Program 11: `LoginApp` (Student Login Servlet)
* Directory: `tomcat/webapps/LoginApp/`
* URL: `http://localhost:8080/LoginApp/login.html`
* Credentials: `student` / `123`
* Recompile if needed:
  ```bash
  javac -cp "../../lib/servlet-api.jar" -d WEB-INF/classes LoginServlet.java
  ```

#### Program 12 & 13: `JspApp` (JSP Pages)
* Directory: `tomcat/webapps/JspApp/`
* URLs:
  * `http://localhost:8080/JspApp/hello.jsp` (Accepts `?count=N`)
  * `http://localhost:8080/JspApp/tags.jsp` (Demonstrates directives, declarations, scriptlets, expressions, comments)

> **Deployment Note:** Drop the folders `ArithApp`, `LoginApp`, and `JspApp` straight into your Apache Tomcat `webapps/` directory and start Tomcat.

---

### 5. JDBC (Programs 14 & 15)

Location: `JdbcDemo/`
* `CreateTable.java`: Connects to MySQL (`jdbc:mysql://localhost:3306/college`) and executes `CREATE TABLE student(id INT PRIMARY KEY, name VARCHAR(50), marks DOUBLE)`.
* `InsertValues.java`: Uses `PreparedStatement` to insert student records.
* MySQL driver included in `JdbcDemo/lib/mysql-connector-j.jar`.

**Run on Linux / macOS:**
```bash
cd JdbcDemo
java -cp ".:lib/*" CreateTable
java -cp ".:lib/*" InsertValues
```

**Run on Windows:**
```cmd
cd JdbcDemo
java -cp ".;lib/*" CreateTable
java -cp ".;lib/*" InsertValues
```

---

### 6. Socket Programming (Programs 16 & 17)

#### Program 16: TCP Factorial (`FactServer.java` & `FactClient.java`)
* Terminal 1 (Start Server):
  ```bash
  java FactServer
  ```
* Terminal 2 (Run Client):
  ```bash
  java FactClient
  # Output: Factorial = 120
  ```

#### Program 17: UDP Object Transfer (`Student.java`, `UDPReceiver.java`, `UDPSender.java`)
* Terminal 1 (Start Receiver):
  ```bash
  java UDPReceiver
  ```
* Terminal 2 (Run Sender):
  ```bash
  java UDPSender
  # Output in Receiver: Received: 101 Rahul
  ```

---

## ⚡ Quick Test Script

Run the automated test runner to verify all programs at once:

**Linux / macOS:**
```bash
./test_all.sh
```

**Windows:**
```cmd
test_all.bat
```
