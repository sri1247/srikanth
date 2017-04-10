package Utility;

import org.apache.poi.hssf.usermodel.*;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class WriteExcel {
    private static HSSFWorkbook excelWorkbook;
    private static HSSFSheet excelSheet;
    private static HSSFCell cell;
    private static HSSFRow row;


    public  void writeDataToExcel(ArrayList result  ) throws Exception {

        excelWorkbook = new HSSFWorkbook();
        excelSheet = excelWorkbook.createSheet();
        //row = excelSheet.getRow(1);
         int  rownum = 0;
        row = excelSheet.createRow(rownum++);
        writeHeader(row);

            for (int i = 0; i < result.size(); i++) {

                    row = excelSheet.createRow(rownum++);

                String s = (String) result.get(i);
                int colnum =0;
                         row.setHeightInPoints(200);

                    cell = row.createCell((short) colnum);
                    //row.setHeight((short) 10);
                    cell.setCellValue(i+1);

                    cell=row.createCell((short) (colnum+1));
                    excelSheet.setColumnWidth((short)(colnum+1), (short)750000);
                HSSFCellStyle cellStyle = excelWorkbook.createCellStyle();
                cell.setCellStyle(cellStyle );
                cellStyle.setWrapText(true);
                    //row.setHeight((short)10);
                    cell.setCellValue(s);

                }




            FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Srikanth\\Desktop\\WriteExcel.xls");

            excelWorkbook.write(fileOut);

            fileOut.flush();

            fileOut.close();
        }
public  void writeHeader(HSSFRow row){
        cell=row.createCell((short) 0);
    String profileNo ="profileNo";
    cell.setCellValue(profileNo);
    cell=row.createCell((short) 1);
    String profileInformation ="profileInformation";
    cell.setCellValue(profileInformation);
}
}

