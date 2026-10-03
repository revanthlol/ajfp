# Advanced Java Practical (AJFP) Cheatsheet Solutions

Complete, production-tested implementations for all 17 Advanced Java Practical programs matching the **Advanced Java Practical Cheatsheet**.

* **Live Web App / Cheatsheet (Vercel-ready):** Contains `index.html` at the repository root ready for 1-click Vercel deployment.
* **GitHub Repository:** [https://github.com/revanthlol/ajfp](https://github.com/revanthlol/ajfp)
* **Direct Source Zip Download:** [https://github.com/revanthlol/ajfp/archive/refs/heads/main.zip](https://github.com/revanthlol/ajfp/archive/refs/heads/main.zip)

---

## 1. Will `.class` Files Work on Every System, or Are They Different?

* **Java Bytecode is Platform-Independent:** Unlike C/C++ native binaries, Java `.class` files contain standard Java bytecode. A `.class` or `.jar` file compiled on Linux will run identically on Windows, macOS, and Linux without recompiling.
* **The Version Compatibility Factor:**
  * The only risk across different machines (such as college lab PCs) is the Java version. If code is compiled with a newer Java runtime (e.g., Java 21 or 27), older lab PCs running Java 8 or 11 will throw `UnsupportedClassVersionError`.
  * **Solution applied here:** All binaries and JARs in this repository were compiled targeting **Java 8 bytecode (`--release 8`)**. This guarantees they will run out-of-the-box on Java 8, 11, 17, 21, and 27 on any operating system!
* **Should you include `.class` files?**
  * In standard open-source projects, `.class` files are usually excluded in `.gitignore` because developers build from source with Maven or Gradle.
  * **However, for lab practicals / exam cheatsheets, keeping both is ideal**:
    1. Programs like **Program 7 (`SimpleBean`)** and **Servlets (`tomcat/webapps/.../WEB-INF/classes/`)** require `.class` files inside their directory trees.
    2. Lab PCs often have restrictive permissions or lack properly configured build tools. Having pre-compiled `.class` and `.jar` files ready means anyone can test and run them immediately with zero friction.

---

## 2. Deploying to Vercel

This repository includes `index.html` (the interactive cheatsheet viewer) directly at the root.

To deploy on Vercel:
1. Go to [Vercel](https://vercel.com/) and click **Add New Project**.
2. Import the `revanthlol/ajfp` repository from GitHub.
3. Keep default settings (Framework Preset: **Other**, Root Directory: `./`).
4. Click **Deploy**. Vercel will instantly host the cheatsheet web app.

---

## 3. Repository Directory Structure

Special programs (Servlets, JSP, XML, JavaBeans, and JDBC) are isolated into their dedicated directories matching the cheatsheet specification:

```text
ajfp/
├── index.html                   # Interactive cheatsheet web viewer (Vercel-ready)
├── *.java                       # Direct standalone Java practicals (Collections, Sockets)
├── jars/                        # Pre-packaged executable JARs (compiled with --release 8)
│   ├── ListDemo.jar
│   ├── SetDemo.jar
│   ├── QueueDemo.jar
│   ├── AccessDemo.jar
│   ├── ComparatorDemo.jar
│   ├── AlgoDemo.jar
│   ├── FactServer.jar / FactClient.jar
│   └── UDPReceiver.jar / UDPSender.jar
├── BeanDemo/                    # Program 7: SimpleBean.java, Demo.java, manifest.mft, SimpleBean.jar
├── XmlDemo/                     # Programs 8 & 9: ParseDom.java, ManipulateDom.java, student.xml
├── JdbcDemo/                    # Programs 14 & 15: CreateTable.java, InsertValues.java
│   └── lib/
│       └── mysql-connector-j.jar # MySQL JDBC driver (included)
├── tomcat/                      # Programs 10, 11, 12, 13: Servlets & JSP Webapps
│   ├── lib/
│   │   └── servlet-api.jar      # Standard Servlet API library (included)
│   └── webapps/
│       ├── ArithApp/            # Program 10: ArithServlet.java & WEB-INF/classes/ArithServlet.class
│       ├── LoginApp/            # Program 11: LoginServlet.java & WEB-INF/classes/LoginServlet.class
│       └── JspApp/              # Programs 12 & 13: hello.jsp, tags.jsp
├── SocketDemo/                  # Socket programs organized by protocol
│   ├── TCP/                     # Program 16: FactServer.java, FactClient.java
│   └── UDP/                     # Program 17: Student.java, UDPReceiver.java, UDPSender.java
├── test_all.sh                  # One-command runner & verifier for Linux / macOS
├── test_all.bat                 # One-command runner & verifier for Windows
├── README.md                    # Complete setup and execution documentation
└── Advanced Java Practical Cheatsheet.html # Original cheatsheet reference
```

---

## 4. Summary of All 17 Completed Programs

| # | Topic | File(s) / Directory | Run Command | Verified Output |
|---|---|---|---|---|
| **1** | List interface | `ListDemo.java` | `java ListDemo` | `[Orange, Mango]`<br>`Mango true 2`<br>`Orange`<br>`Mango` |
| **2** | Set interface | `SetDemo.java` | `java SetDemo` | `2 true`<br>`[Python] [10, 30, 40]` |
| **3** | Queue interface | `QueueDemo.java` | `java QueueDemo` | `T1`<br>`T1`<br>`[T2, T3]` |
| **4** | Access elements | `AccessDemo.java` | `java AccessDemo` | `Red Green Blue `<br>`Blue Green Red `<br>`Red Green Blue ` |
| **5** | Comparator | `ComparatorDemo.java` | `java ComparatorDemo` | `[Bob 92, Alice 85, Charlie 78]` |
| **6** | Collection algorithms | `AlgoDemo.java` | `java AlgoDemo` | `[10, 10, 20, 30, 40]`<br>`[40, 30, 20, 10, 10]`<br>`10 40`<br>`2`<br>`3` |
| **7** | Simple Bean | `BeanDemo` | `cd BeanDemo && java Demo` | `101 Loyola` |
| **8** | XML: parse DOM | `XmlDemo/ParseDom.java` | `cd XmlDemo && java ParseDom` | `students`<br>`101 Rahul`<br>`102 Anita` |
| **9** | XML: manipulate DOM | `XmlDemo/ManipulateDom.java` | `cd XmlDemo && java ManipulateDom` | `<students><student id="101"><name>Rahul</name><grade>A+</grade><dept>CS</dept></student>...` |
| **10** | Servlet: Arithmetic | `tomcat/webapps/ArithApp` | Tomcat URL: `/ArithApp/index.html` | `Add = 30.0`<br>`Sub = 10.0`<br>`Mul = 200.0`<br>`Div = 2.0`<br>`Mod = 0.0` |
| **11** | Servlet: Login | `tomcat/webapps/LoginApp` | Tomcat URL: `/LoginApp/login.html` | `Login Successful`<br>`Welcome, student` |
| **12** | JSP: Hello World N | `tomcat/webapps/JspApp/hello.jsp` | Tomcat URL: `/JspApp/hello.jsp?count=5` | `1. Hello World`<br>...<br>`5. Hello World` |
| **13** | JSP scripting elements | `tomcat/webapps/JspApp/tags.jsp` | Tomcat URL: `/JspApp/tags.jsp` | `Sum: 30`<br>`Square of 5: 25` |
| **14** | JDBC: Create table | `JdbcDemo/CreateTable.java` | `cd JdbcDemo && java -cp ".:lib/*" CreateTable` | `Table created` |
| **15** | JDBC: Insert values | `JdbcDemo/InsertValues.java` | `cd JdbcDemo && java -cp ".:lib/*" InsertValues` | `Record inserted` |
| **16** | TCP sockets | `FactServer.java` & `FactClient.java` | Server first, then Client | `Factorial = 120` |
| **17** | UDP sockets | `UDPReceiver.java` & `UDPSender.java` | Receiver first, then Sender | `Received: 101 Rahul` |

---

## 5. How to Test

### Automated Suite
You can run the full test suite at any time inside `ajfp`:

* **Linux / macOS:**
  ```bash
  cd ajfp
  ./test_all.sh
  ```

* **Windows:**
  ```cmd
  cd ajfp
  test_all.bat
  ```

* **Standalone Executable JARs:**
  ```bash
  java -jar jars/ListDemo.jar
  java -jar jars/AlgoDemo.jar
  java -jar jars/ComparatorDemo.jar
  java -jar jars/FactServer.jar &
  java -jar jars/FactClient.jar
  ```

---

### Manual Execution Guide

#### 1. JavaBeans (`BeanDemo/`)
```bash
cd BeanDemo
javac *.java
jar cfm SimpleBean.jar manifest.mft SimpleBean.class
java Demo
```

#### 2. XML DOM (`XmlDemo/`)
```bash
cd XmlDemo
java ParseDom
java ManipulateDom
```

#### 3. Servlets & JSP (`tomcat/`)
* Drop `ArithApp`, `LoginApp`, and `JspApp` from `tomcat/webapps/` directly into your Apache Tomcat `webapps/` folder.
* Start Tomcat and visit:
  * Arithmetic App: `http://localhost:8080/ArithApp/index.html`
  * Login App: `http://localhost:8080/LoginApp/login.html` (Credentials: `student` / `123`)
  * JSP Hello World: `http://localhost:8080/JspApp/hello.jsp`
  * JSP Tags: `http://localhost:8080/JspApp/tags.jsp`

#### 4. JDBC (`JdbcDemo/`)
Ensure MySQL server is running and a database named `college` exists:
```bash
# Linux / macOS
cd JdbcDemo
java -cp ".:lib/*" CreateTable
java -cp ".:lib/*" InsertValues

# Windows
cd JdbcDemo
java -cp ".;lib/*" CreateTable
java -cp ".;lib/*" InsertValues
```

#### 5. Sockets (TCP & UDP)
* **TCP Factorial:**
  ```bash
  # Terminal 1:
  java FactServer
  # Terminal 2:
  java FactClient
  ```
* **UDP Object Transfer:**
  ```bash
  # Terminal 1:
  java UDPReceiver
  # Terminal 2:
  java UDPSender
  ```
