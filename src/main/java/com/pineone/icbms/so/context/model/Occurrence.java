package com.pineone.icbms.so.context.model;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Melvin on 15. 10. 1..
 */

public class Occurrence {

    @Autowired
    String occrrenceID;



    String contextModelID;
    String description;
    String command;

    public String getOccrrenceID() {
        return occrrenceID;
    }

    public void setOccrrenceID(String occrrenceID) {
        this.occrrenceID = occrrenceID;
    }

    public String getContextModelID() {
        return contextModelID;
    }

    public void setContextModelID(String contextModelID) {
        this.contextModelID = contextModelID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
