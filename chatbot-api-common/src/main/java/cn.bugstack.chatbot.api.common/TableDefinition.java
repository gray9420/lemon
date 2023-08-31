package cn.bugstack.chatbot.api.common;

import lombok.Data;

@Data
public class TableDefinition {

    private String fieldName;
    private String type;
    private String comment;

}
