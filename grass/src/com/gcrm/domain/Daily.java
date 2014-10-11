package com.gcrm.domain;

import java.io.Serializable;

public class Daily implements Serializable {

    private static final long serialVersionUID = 2250950813769457555L;

    private Integer id;
    private String title;
    private String content;
    private String instructions;
    private Integer instructions_are;
    private String createtime;
    private String edittime;
    private String instructionstime;
    private String ifinstructions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Integer getInstructions_are() {
        return instructions_are;
    }

    public void setInstructions_are(Integer instructions_are) {
        this.instructions_are = instructions_are;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getEdittime() {
        return edittime;
    }

    public void setEdittime(String edittime) {
        this.edittime = edittime;
    }

    public String getInstructionstime() {
        return instructionstime;
    }

    public void setInstructionstime(String instructionstime) {
        this.instructionstime = instructionstime;
    }

    public String getIfinstructions() {
        return ifinstructions;
    }

    public void setIfinstructions(String ifinstructions) {
        this.ifinstructions = ifinstructions;
    }

}
