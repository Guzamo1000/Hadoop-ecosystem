APACHE SPARK 

* Introduction

  ![](https://d1jnx9ba8s6j9r.cloudfront.net/blog/wp-content/uploads/2018/09/001-768x583.png)
  
- Spark core

- Spark Streaming

- Spark SQL

- GraphX

- MLlib

- SparkR
* Install ([How to Install Apache Spark on Ubuntu 20.04 (Step by Step) (cloudinfrastructureservices.co.uk)](https://cloudinfrastructureservices.co.uk/how-to-install-apache-spark-on-ubuntu-20-04/))

* Architecture apache spark core ()
  
  1. Two Main Abstractions of Apache Spark
  * RDDs (Resilient Distributed Dataset): 

    ![](https://d1jnx9ba8s6j9r.cloudfront.net/blog/wp-content/uploads/2018/07/Partitions.png)
    
    - RDDs are the building blocks of any Spark application. RDDs Stands for:
      
      * **_Resilient:_** Fault tolerant and is capable of rebuilding data on failure
      * **_Distributed_**:  Distributed data among the multiple nodes in a cluster
      * **_Dataset:_** Collection of partitioned data with values
    * It is a layer of abstracted data over the distributed collection. It is immutable in nature and follows [lazy transformations](https://www.edureka.co/blog/spark-tutorial/#Spark_Features).
      
      ![](https://d1jnx9ba8s6j9r.cloudfront.net/blog/wp-content/uploads/2018/09/Picture1-5-768x266.png "Workflow of RDD")
    
    * With RDDs, you can perform two types of operations:
      
      1. **Transformations:** They are the operations that are applied to create a new RDD.
      2. **Actions:** They are applied on an RDD to instruct Apache Spark to apply computation and pass the result back to the driver.

* DAG (Directed Acyclic Graph): The driver converts the program into a DAG for each job. The Apache Spark Eco-system includes various components such as the API core, Spark SQL, Streaming and real-time processing, MLIB, and Graph X. A sequence of connection between nodes is referred to as a driver. As a result, you can read volumes of data using the Spark shell. You can also use the Spark context -cancel, run a job, task (work), and job (computation) to stop a job.
2. Architecture

   ![](https://www.interviewbit.com/blog/wp-content/uploads/2022/06/Spark-Architecture-800x430.png)

+ Spark Driver: The Spark Driver resembles the cockpit of a Spark application. It performs the role of the Spark application’s execution controller. The Spark driver keeps track of all the application states for the Spark cluster. The cluster manager must be interfaced with the Spark driver in order to obtain physical resources and start executors.

+ Spark Context: Spark Context acts as a bridge between the application code and the Spark execution environment. It provides a programming interface to create and manipulate resilient distributed datasets (RDDs), which are the primary data abstraction in Spark. RDDs allow developers to perform distributed data processing operations like transformations and actions in a fault-tolerant manner.

+ Cluster manager: 

+ Worker node: The slave nodes whose job is to basically execute the tasks. These tasks are then executed on the partitioned RDDs in the worker node and hence returns back the result to the Spark Context.

+ Executor: The Spark Driver resembles the cockpit of a Spark application. It performs the role of the Spark application’s execution controller. The Spark driver keeps track of all the application states for the Spark cluster. The cluster manager must be interfaced with the Spark driver in order to obtain physical resources and start executors.

+ Task
  
3. workflow
  
  ![](https://d1jnx9ba8s6j9r.cloudfront.net/blog/wp-content/uploads/2018/09/Picture9-1-768x430.png)
  
  - **STEP 1:** The client submits spark user application code. When an application code is submitted, the driver implicitly converts user code that contains transformations and actions into a logically _directed acyclic graph_ called _**DAG.**_ At this stage, it also performs optimizations such as pipelining transformations.

  - **STEP 2:** After that, it converts the logical graph called DAG into physical execution plan with many stages. After converting into a physical execution plan, it creates physical execution units called tasks under each stage. Then the tasks are bundled and sent to the cluster.

  - **STEP 3:** Now the driver talks to the cluster manager and negotiates the resources. Cluster manager launches executors in worker nodes on behalf of the driver. At this point, the driver will send the tasks to the executors based on data placement. When executors start, they register themselves with drivers. So, the driver will have a complete view of executors that are executing the task.

  ![](https://d1jnx9ba8s6j9r.cloudfront.net/blog/wp-content/uploads/2018/09/Picture8-2.png)

  - **STEP 4:** During the course of execution of tasks, driver program will monitor the set of executors that runs. Driver node also schedules future tasks based on data placement.
  
* Architecture apache spark streaming ([Spark Streaming: Đi sâu vào Mô hình Kiến trúc và Thực thi (databricks.com)](https://www.databricks.com/blog/2015/07/30/diving-into-apache-spark-streamings-execution-model.html))
  
  - Stream Processing Architectures - The Old and the New
  
  - At a high level, modern distributed stream processing pipelines execute as follows:
    
    1. **Receive** streaming data from data sources (e.g. live logs, system telemetry data, IoT device data, etc.) into some data ingestion system like Apache Kafka, Amazon Kinesis, etc.
    2. **Process** the data in parallel on a cluster. This is what stream processing engines are designed to do, as we will discuss in detail next.
    3. **Output** the results out to downstream systems like HBase, Cassandra, Kafka, etc.
  
  - To process the data, most traditional stream processing systems are designed with a _continuous operator model_, which works as follows:
  * There is a set of worker nodes, each of which run one or more **continuous operators**.
  
  * Each continuous operator processes the streaming data one record at a time and forwards the records to other operators in the pipeline.
  
  * There are “source” operators for receiving data from ingestion systems, and “sink” operators that output to downstream systems.

    ![](https://www.databricks.com/wp-content/uploads/2015/07/image11.png)
  - Architecture of Spark Streaming: Discretized Streams
  
  - Instead of processing the streaming data one record at a time, Spark Streaming discretizes the streaming data into tiny, sub-second micro-batches. In other words, Spark Streaming’s Receivers accept data in parallel and buffer it in the memory of Spark’s workers nodes. Then the latency-optimized Spark engine runs short tasks (tens of milliseconds) to process the batches and output the results to other systems. Note that unlike the traditional continuous operator model, where the computation is statically allocated to a node, Spark tasks are assigned dynamically to the workers based on the locality of the data and available resources. This enables both better load balancing and faster fault recovery, as we will illustrate next.
  
  - In addition, each batch of data is a [Resilient Distributed Dataset (RDD)](https://www.databricks.com/glossary/what-is-rdd), which is the basic abstraction of a fault-tolerant dataset in Spark. This allows the streaming data to be processed using any Spark code or library.

    ![](https://www.databricks.com/wp-content/uploads/2015/07/image21.png)
  
  - 
