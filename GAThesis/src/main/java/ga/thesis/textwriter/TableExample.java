package ga.thesis.textwriter;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.FontSelector;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TableExample {

    public static File fontFile = new File("fonts/arialuni.ttf");

    public static HashMap<Integer, ArrayList<Integer>> representPeriods() {
        HashMap<Integer, ArrayList<Integer>> map;
        map = new HashMap<Integer, ArrayList<Integer>>();
        int i = 10;
        for (int j = 1; j < 6; j++) {
            for (int k = 0; k < 6; k++) {
                ArrayList<Integer> columnRow = new ArrayList<Integer>();

                columnRow.add(j);
                columnRow.add(k);
                map.put(i, columnRow);
                i++;

            }
        }
        return map;
    }

    public static void main(String[] args) {
        Document document = new Document();

        try {
            BaseFont unicode = BaseFont.createFont(fontFile.getAbsolutePath(), "cp1251", BaseFont.EMBEDDED);

            FontSelector fs = new FontSelector();
            fs.addFont(new Font(unicode));
            PdfWriter.getInstance(document,
                    new FileOutputStream("Timetable.pdf"));

            document.open();
            Font f = new Font(unicode, 14);

            PdfPTable table = new PdfPTable(6); // 3 column

            initPdf(null, null);

//            PdfPCell cell1 = new PdfPCell(new Paragraph("", f));
//            Phrase phrase = fs.process("Понеділок");
//            PdfPCell cell2 = new PdfPCell(new Paragraph(phrase));
//            PdfPCell cell3 = new PdfPCell(new Paragraph("Вівторок", f));
//            PdfPCell cell4 = new PdfPCell(new Paragraph("Середа", f));
//            PdfPCell cell5 = new PdfPCell(new Paragraph("Четвер", f));
//            PdfPCell cell6 = new PdfPCell(new Paragraph("П'ятниця", f));
//
//            table.addCell(cell1);
//            table.addCell(cell2);
//            table.addCell(cell3);
//            table.addCell(cell4);
//            table.addCell(cell5);
//            table.addCell(cell6);
            //  table.addCell(cell3);
            // table.addCell(cell3);
            // table.addCell(cell4);
            document.add(table);

            document.close();
        } catch (Exception e) {

        }
    }

    public static void initPdf(ArrayList<String> list, HashMap<String, HashMap<Integer, ArrayList<String>>> map) {
        Document document = new Document();

        try {
            BaseFont unicode = BaseFont.createFont(fontFile.getAbsolutePath(), "cp1251", BaseFont.EMBEDDED);

            FontSelector fs = new FontSelector();
            fs.addFont(new Font(unicode));
            PdfWriter.getInstance(document,
                    new FileOutputStream("Timetable.pdf"));

            document.open();
            Font f = new Font(unicode, 14);

            PdfPTable table = new PdfPTable(6);

            for (int m = 0; m < list.size(); m++) {
                HashMap<Integer, ArrayList<String>> kursMap = map.get(m);

                for (int i = 10; i < representPeriods().size() + 10; i++) {
                    if (kursMap.containsKey(i)) {
                        ArrayList<String> pairs = kursMap.get(i);
                      //  ArrayList<Integer> period = representPeriods().get(i);
                        PdfPCell cell6 = new PdfPCell(new Paragraph(concatString(pairs)));
                        table.addCell(cell6);
                        //  model.setValueAt(new SimpleString1(concatString(pairs)), period.get(1), period.get(0));
                    }
                }
                document.add(table);

                document.close();
            }
        } catch (Exception e) {
        }
    }

    public static String concatString(ArrayList<String> list) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i)).append(" ");
        }
        return builder.toString();
    }
}
