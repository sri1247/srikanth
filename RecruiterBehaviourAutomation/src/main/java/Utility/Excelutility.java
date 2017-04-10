package Utility;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;

public class Excelutility {

    private static HSSFSheet excelWSheet;
    private static HSSFWorkbook excelWbook;
    private static HSSFCell cell;
    private static HSSFRow row;
    private static int intCell;
    public  static String[][] inputData;
    public Excelutility() throws Exception {

    }
//String path=Constant.Path_TestData+Constant.readFile_TestData;
    public  void setExcelFile(String path,String SheetName) throws Exception {

        try {
            FileInputStream excelFile = new FileInputStream(path);
            excelWbook = new HSSFWorkbook(excelFile);
            excelWSheet = excelWbook.getSheet(SheetName);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public  String getCellData(int RowNum, int colNum) throws Exception {
        try {
           // excelWSheet = excelWbook.getSheet(SheetName);
            cell = excelWSheet.getRow(RowNum).getCell(colNum);
            String cellData = cellToString(cell);
            return cellData;
        } catch (Exception e) {
            return "";
        }
    }
    public static String readDataFromExcel(String path) throws Exception {
        try {
            FileInputStream excelFile = new FileInputStream(path);
            excelWbook = new HSSFWorkbook(excelFile);
            excelWSheet = excelWbook.getSheetAt(0);
            int rowSize = excelWSheet.getLastRowNum();
           // cell = row.getCell(colNum);
            int cellsize = row.getLastCellNum();
             inputData=new String[rowSize][cellsize];
            for(int i=0;i>=rowSize; i++){
                row =excelWSheet.getRow(i);
                for (int j=0;j>=cellsize;j++){
                   cell=row.getCell(j);
                     String value=cellToString(cell);
                      inputData[i][j]=value;


                       return value;

                }
            }

        } catch (Exception e) {
          return  "";
        }
        return null;
    }
    public static   String cellToString( HSSFCell cell){

        int type = cell.getCellType();
        Object result;
        switch (type) {
            case HSSFCell.CELL_TYPE_NUMERIC: //0
                result = cell.getNumericCellValue();
                break;
            case HSSFCell.CELL_TYPE_STRING: //1
                result= cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_FORMULA: //2
                throw new RuntimeException("WE can't evaluate formulas in Java");
            case HSSFCell.CELL_TYPE_BLANK: //3
                result = "-";
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN: //4
                result = cell.getBooleanCellValue();
                break;
            case HSSFCell.CELL_TYPE_ERROR: //5
                throw new RuntimeException ("This cell has an error");
            default:
                throw new RuntimeException("We don't support this cell type: " + type);
        }
        return result.toString();
    }

  /*  public  String getIntcell(int RowNum, int ColNum) {
        try {
            //excelWSheet = excelWbook.getSheet(SheetName);
            intCell = (int) excelWSheet.getRow(RowNum).getCell(ColNum).getNumericCellValue();
            String intcelldata = String.valueOf(intCell);
            return intcelldata;
        } catch (Exception e) {

            return "";

        }*/


    //}
}