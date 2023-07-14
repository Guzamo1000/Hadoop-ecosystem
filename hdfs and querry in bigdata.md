# APACHE HADOOP

- Introduction

- Config ([Install Hadoop on Ubuntu (learnubuntu.com)](https://learnubuntu.com/install-hadoop/#google_vignette))
  
  + install java (recomment java 8): 
  
  ```linux
  sudo apt install default-jdk default-jre -y
  ```
  
  ```linux
  sudo apt-get install openjdk-8-jdk
  ```
  
  + install ssh
    
        sudo apt install openssh-server openssh-client -y+
  - general ssh key
    
        ssh-keygen -t rsa
  
  - Add public key to authorized_keys
    
        cat ~/.ssh/id_rsa.pub >> ~/.ssh/authorized_keys
  
  - Use the chmod command to change the file permissions of `authorized_keys`:
    
        sudo chmod 640 ~/.ssh/authorized_keys
  
  - connect localhost
    
        ssh localhost
  
  - Download hadoop ([Apache Hadoop](https://hadoop.apache.org/releases.html))
  
  - Extract file tar
  
  - copy to root
    
        sudo mv package_hadoop /usr/local/hadoop
  
  - Create package log
    
        sudo mkdir /usr/local/hadoop/logs
  
  - Change the ownership of the `/usr/local/hadoop` to the user `hadoop`:
    
        sudo chown -R hadoop:hadoop /usr/local/hadoop
  
  - Config path in file bashrc
    
        sudo nano ~/.bashrc
        
        export HADOOP_HOME=/usr/local/hadoop
        
        export HADOOP_INSTALL=$HADOOP_HOME
        
        export HADOOP_MAPRED_HOME=$HADOOP_HOME
        
        export HADOOP_COMMON_HOME=$HADOOP_HOME
        
        export HADOOP_HDFS_HOME=$HADOOP_HOME
        
        export YARN_HOME=$HADOOP_HOME
        
        export HADOOP_COMMON_LIB_NATIVE_DIR=$HADOOP_HOME/lib/native
        
        export PATH=$PATH:$HADOOP_HOME/sbin:$HADOOP_HOME/bin
        
        export HADOOP_OPTS="-Djava.library.path=$HADOOP_HOME/lib/native"
    
    save
    
        source ~/.bashrc
  
  - Edit file hadoop-env.sh
    
        sudo nano $HADOOP_HOME/etc/hadoop/hadoop-env.sh
        
        export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
        
        export HADOOP_CLASSPATH+=" $HADOOP_HOME/lib/*.jar"
  
  - Add library  
    
        cd /usr/local/hadoop/lib
        
        sudo wget https://jcenter.bintray.com/javax/activation/javax.activation-api/1.2.0/javax.activation-api-1.2.0.jar
  
  - check hadoop
    
        hadoop version
  
  - Edit core-site.xml    
    
        sudo nano $HADOOP_HOME/etc/hadoop/core-site.xml
        
        <property>
        
              <name>fs.default.name</name>
        
              <value>hdfs://0.0.0.0:9000</value>
        
              <description>The default file system URI</description>
        
           </property>
  
  - Config location hdfs node
    
        sudo mkdir -p /home/hadoop/hdfs/{namenode,datanode}
        
        sudo chown -R hadoop:hadoop /home/hadoop/hdfs
  
  - Edit hdfs-site.xml
    
        sudo nano $HADOOP_HOME/etc/hadoop/hdfs-site.xml
        
        <property>
        
              <name>dfs.replication</name>
        
              <value>1</value>
        
           </property>
        
           <property>
        
              <name>dfs.name.dir</name>
        
              <value>file:///home/hadoop/hdfs/namenode</value>
        
           </property>
        
        <property>
        
              <name>dfs.data.dir</name>
        
              <value>file:///home/hadoop/hdfs/datanode</value>
        
           </property>
  
  - #### Edit the `mapred-site.xml`
    
        sudo nano $HADOOP_HOME/etc/hadoop/mapred-site.xml
        
        sudo nano $HADOOP_HOME/etc/hadoop/mapred-site.xml
  
  - Edit yarn-site.xml
    
        sudo nano $HADOOP_HOME/etc/hadoop/mapred-site.xml
        
        <property>
        
              <name>yarn.nodemanager.aux-services</name>
        
              <value>mapreduce_shuffle</value>
        
           </property>
  
  - Format node
    
        hdfs namenode -format
  
  - start: 
    
        start-all.sh
  
  - stop:
    
        stop-all.sh
  
  - check node:
    
        jps
  
  - User interface
    
        localhost:9870

- Architecture
  ![](https://phoenixnap.com/kb/wp-content/uploads/2021/04/hadoop-ecosystem-projects-architecture.png)
  
  - master-slave architecture
  
  - classes of hadoop:
    
    - HDFS: Hadoop Distributed File System. Google published its paper GFS and on the basis of that HDFS was developed. It states that the files will be broken into blocks and stored in nodes over the distributed architecture.
    
    - MapReduce: This is a framework which helps Java programs to do the parallel computation on data using key value pair. The Map task takes input data and converts it into a data set which can be computed in Key value pair. The output of Map task is consumed by reduce task and then the out of reducer gives the desired result.
    
    - YARN: Hadoop Distributed File System. Google published its paper GFS and on the basis of that HDFS was developed. It states that the files will be broken into blocks and stored in nodes over the distributed architecture.
    
    - Hadoop Common: These Java libraries are used to start Hadoop and are used by other Hadoop modules.
  
  - Components included:
    ![](https://www.interviewbit.com/blog/wp-content/uploads/2022/06/HDFS-Architecture-800x430.png)
    
    - Namenode
    - Datanode
    - Secondary Namenode
    - Checkpoint node
    - Backup node
    - Block
    - Rack

# APACHE HIVE

- Introduction

- Config

- Architecture

![](https://www.tutorialspoint.com/hive/images/hive_architecture.jpg)

| Unit Name             | Operation                                                                                                                                                                                                                                                |
| --------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| User Interface        | Hive is a data warehouse infrastructure software that can create interaction between user and HDFS. The user interfaces that Hive supports are Hive Web UI, Hive command line, and Hive HD Insight (In Windows server).                                  |
| Meta Store            | Hive chooses respective database servers to store the schema or Metadata of tables, databases, columns in a table, their data types, and HDFS mapping.                                                                                                   |
| HiveQL Process Engine | HiveQL is similar to SQL for querying on schema info on the Metastore. It is one of the replacements of traditional approach for MapReduce program. Instead of writing MapReduce program in Java, we can write a query for MapReduce job and process it. |
| Execution Engine      | The conjunction part of HiveQL process Engine and MapReduce is Hive Execution Engine. Execution engine processes the query and generates results as same as MapReduce results. It uses the flavor of MapReduce.                                          |
| HDFS or HBASE         | Hadoop distributed file system or HBASE are the data storage techniques to store data into file system.                                                                                                                                                  |

        + user interfaces

        + metastore

        + HQL process enginee

        + HDFS

- UDF

- Coding
