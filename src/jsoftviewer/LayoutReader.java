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
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jsoftviewer.models.Layout;

/**
 *
 * @author roger
 */
public class LayoutReader {

    private File layoutFile;
    public final String FILE_PATH = "/layout.xml";

    public LayoutReader() {
        //this.layoutFile = new File(FILE_PATH);

        try {
            layoutFile = new File(getClass().getResource("layout.xml").toURI());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "JSoftViewer", JOptionPane.INFORMATION_MESSAGE);
        }
    }

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
