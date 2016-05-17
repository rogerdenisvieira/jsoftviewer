/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsoftviewer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import jsoftviewer.models.Attribute;
import jsoftviewer.models.Layout;

/**
 *
 * @author roger
 */
public class TableFiller {

    public static DefaultTableModel fill(List<String> values, String[] columNames) {
        DefaultTableModel model = new DefaultTableModel(columNames, 0);
        int l = 0;
        for (String s : values) {
            l++;
            model.addRow(new Object[]{l,s});
        }

        return model;
    }

    public static DefaultTableModel fillWithModule(String lineValue, LayoutReader reader, int beginModName, int endModName) throws ParseException {

        DefaultTableModel model = new DefaultTableModel(new Object[]{"Attribute Name", "Attribute Value"}, 0);
        String attributeValue = null;

        String moduleName = lineValue.substring(beginModName, endModName);
        System.out.println(moduleName);
        Layout foundLayout = reader.findLayout(moduleName);

        if (foundLayout != null) {
            for (Attribute a : foundLayout.getAttributes()) {
                attributeValue = lineValue.substring(a.getBegin() - 1, a.getEnd());

                if (a.getDescription().contains("Data")) {
                    SimpleDateFormat dateForm = new SimpleDateFormat("yyyyMMdd");
                    Date date = dateForm.parse(attributeValue);
                    dateForm.applyPattern("dd/MM/yyyy");
                    attributeValue = dateForm.format(date);
                }

                System.out.println("Atributo: " + a.getDescription());

                model.addRow(new Object[]{a.getDescription(), attributeValue});
            }
            return model;
        }

        return null;
    }

}
