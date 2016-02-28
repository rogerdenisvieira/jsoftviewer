/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsoftviewer.models;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.List;

/**
 *
 * @author roger
 */
@XStreamAlias("layouts")
public class LayoutSet {
    
    @XStreamImplicit
    @XStreamAlias("layout")
    private List<Layout> layouts;

    /**
     * @return the layouts
     */
    public List<Layout> getLayouts() {
        return layouts;
    }

    /**
     * @param layouts the layouts to set
     */
    public void setLayouts(List<Layout> layouts) {
        this.layouts = layouts;
    }
}
