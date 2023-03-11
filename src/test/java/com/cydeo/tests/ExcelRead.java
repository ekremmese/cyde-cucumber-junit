package com.cydeo.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelRead {

@Test
    public void read_from_excel_file() throws IOException {
    String path = "SampleData.xlsx";

    //to read from excel we need to load it to FileInput Stream
    FileInputStream fileInputStream = new FileInputStream(path);

    //workbook>sheet>row>cell

    //<1> Create a workbook
    XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

    //<2> We need to get specific sheet from currently opened workbook
    XSSFSheet sheet = workbook.getSheet("Employees");

    //<3> Select row and cell
    //Print out Mary's cell
    //Indexes start from 0

    System.out.println(sheet.getRow(1).getCell(0));

    //print out developer
    System.out.println(sheet.getRow(3).getCell(2));

    //print out Ahmed
    System.out.println(sheet.getRow(3).getCell(0));

    //getPhysicalNumberOfRows() method
    //Return the count of used cells only
    //Starts counting from 1
    int usedRows = sheet.getPhysicalNumberOfRows();
    System.out.println(usedRows);

    //lastUsedRowNum() method
    //Returns the number from top cell to bottom cell
    //It doesn't care if the cell is empty or not
    //Start counting from Zero

    int lastUsedRow = sheet.getLastRowNum();
    System.out.println(lastUsedRow);

    System.out.println("-----------------------------");

    //TODO: Create a logic to print Ahmed's name

    for (int rowNum =0; rowNum<usedRows; rowNum++){

        if(sheet.getRow(rowNum).getCell(0).toString().equals("Ahmed")){
            System.out.println(sheet.getRow(rowNum).getCell(0));
        }

    }

    System.out.println("-----------------------------");

    //TODO: Create a logic to print out Lindan's Job_ID
    //check if name is Linda ---> print out Job_ID of Linda

    for ( int rowNum = 0 ; rowNum<usedRows; rowNum++ ){
        if(sheet.getRow(rowNum).getCell(0).toString().equals("Lindan")){
            System.out.println(sheet.getRow(rowNum).getCell(2));
        }
    }


}

}
