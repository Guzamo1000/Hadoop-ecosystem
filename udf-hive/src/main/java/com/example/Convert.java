package com.example;
import org.apache.hadoop.hive.ql.exec.UDF;

import org.apache.hadoop.io.Text;
public class Convert extends UDF {
    public Text evaluate(Text input) {
        if (input == null) return null;

        String ip = input.toString();
        String formattedIP = ip.replace(".", "-");

        return new Text(formattedIP);
    }
}
