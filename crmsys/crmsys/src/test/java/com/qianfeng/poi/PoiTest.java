package com.qianfeng.poi;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class PoiTest {

	//读取xlsx后缀的文件
	@Test
	public void readXLSX() throws IOException {
		
		//读取文件
		FileInputStream fileInputStream = new FileInputStream("d:/text1.xlsx");
		//根据文件流创建workBook对象
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
		//根据索引获取制定的sheet
		XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
		
		
		//获取最后一行行数   从0开始
	//	int lastRowNum = sheet.getLastRowNum();
		//循环进行多行多列输出
		//获取列数
		
		//根据索引获取行
		XSSFRow row = sheet.getRow(0);
		
		//获取最后一行列数  从1开始
 		//row.getLastCellNum();
		//循环获取列中数据
		
		//获取单元格
		XSSFCell cell = row.getCell(0);
		
		//设置单元格类型，统一获取
		//cell.setCellType(CellType.STRING);
		
		//如果单元格里存的是字符串，使用该方法获取数据
		System.out.println(cell.getStringCellValue());
		
		//获取数字内容
		XSSFCell cell2 = row.getCell(1);
		System.out.println(cell2.getNumericCellValue());
		
		xssfWorkbook.close();
	}
	
	
	
	
}
