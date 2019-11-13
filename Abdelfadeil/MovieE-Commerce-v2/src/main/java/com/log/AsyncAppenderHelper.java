package com.log;

import org.apache.log4j.Appender;
import org.apache.log4j.AsyncAppender;
import org.apache.log4j.Logger;

import java.util.Enumeration;

public class AsyncAppenderHelper  extends AsyncAppender {


    public AsyncAppenderHelper(){
        super();
    }

    public void setAppenderFromLogger(String name){
        Logger logger = Logger.getLogger(name);

        Enumeration<Appender> e = logger.getAllAppenders();

        while(e.hasMoreElements()){
            Appender a = e.nextElement();
            this.addAppender(a);
            System.out.println("The newAppender "+a.getName() +" attach status "+this.isAttached(a));
        }

    }

}
