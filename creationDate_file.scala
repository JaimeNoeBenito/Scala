// Databricks notebook source
import java.time.{Instant, ZoneId, ZonedDateTime} 

val timeInMillis = System.currentTimeMillis()
//timeInMillis: Long = 1486988060666

val instant = Instant.ofEpochMilli(timeInMillis)
// print(instant)

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

val conf = spark.sparkContext.hadoopConfiguration
val fs = FileSystem.get(conf)
val dirPath = new Path("yourPath")
val filestatus = fs.listStatus(dirPath )
// filestatus.foreach(f => println(f.getModificationTime))
// filestatus.foreach(f => println(f.getPath))
filestatus.foreach(f => {
                        println("file time creation...: " + Instant.ofEpochMilli(f.getModificationTime)) 
                        println("file path .... " + f.getPath)
                        })

// COMMAND ----------


