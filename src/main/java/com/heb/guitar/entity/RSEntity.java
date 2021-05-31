package com.heb.guitar.entity;

import lombok.Data;
import java.io.Serializable;

@Data
public class RSEntity <T> implements Serializable {

    private String viewId;

    private T params;

}
