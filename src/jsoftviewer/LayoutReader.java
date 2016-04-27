/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsoftviewer;

import jsoftviewer.models.LayoutSet;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import jsoftviewer.models.Attribute;
import jsoftviewer.models.Layout;

/**
 *
 * @author roger
 */
public class LayoutReader {

    private File layoutFile;
    public final String FILE_PATH = "layout.xml";

    public LayoutReader() {
        //this.layoutFile = new File(FILE_PATH);

        layoutFile = new File(FILE_PATH);
    }

    // carrega o arquivo completo de layout
    private LayoutSet loadConfig() {

        LayoutSet layouts = new LayoutSet();

        try {

            XStream stream = new XStream(new DomDriver());
            stream.processAnnotations(LayoutSet.class);

            layouts = (LayoutSet) stream.fromXML(layoutFile);
            
                        
            

        } catch (Exception e) {
            e.printStackTrace();
        }

        return layouts;
    }

    // busca o layout específico pelo nome do módulo
    public Layout findLayout(String moduleName) {
        Layout foundLayout = null;
        for (Layout l : loadConfig().getLayouts()) {
            if (l.getModule().equals(moduleName)) {
                foundLayout = l;
            }
        }
             
        return foundLayout;
    }

}
