/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsoftviewer;

import java.io.File;
import java.util.List;
import java.util.stream.Stream;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.objects.NativeArray;
import jsoftviewer.models.Attribute;
import jsoftviewer.models.Layout;
import jsoftviewer.models.LayoutSet;

/**
 *
 * @author roger
 */
public class TableFiller {

    public static DefaultTableModel fill(List<String> values, String[] columNames) {
        DefaultTableModel model = new DefaultTableModel(columNames, 0);

        for (String s : values) {
            model.addRow(new Object[]{s});
        }

        return model;
    }

    public static DefaultTableModel fillWithModule(String lineValue, LayoutReader reader) {

        DefaultTableModel model = new DefaultTableModel(new Object[]{"Attribute Name", "Attribute Value"}, 0);
        String attributeValue = null;

        String moduleName = lineValue.substring(0, 10);
        System.out.println(moduleName);
        Layout foundLayout = reader.findLayout(moduleName);

        if (foundLayout != null) {
            for (Attribute a : foundLayout.getAttributes()) {
                //System.out.println(a.getBegin() + " " + a.getLength());
                attributeValue = lineValue.substring(a.getBegin() - 1, a.getEnd());

                model.addRow(new Object[]{a.getDescription(), attributeValue});
            }
                    return model;
        }

        return null;

        //pesquisar o nome do modulo no layoutset
        //iterar no layout
        //popular um dictionary com as substring da lineValue sobre cada item do layout
    }

}
