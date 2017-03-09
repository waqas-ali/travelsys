/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crossover.project.entities;

import java.io.Serializable;

/**
 *
 * @author waqas.ali2
 */
public class NavigationMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    private String pageName;
    private String pageURL;

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String value) {
        this.pageName = value;
    }

    public String getPageURL() {
        return pageURL;
    }

    public void setPageURL(String value) {
        this.pageURL = value;
    }

}
