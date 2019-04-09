package com.qianfeng.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.util.SocketUtils;

import com.qianfeng.pojo.SysUser;

public class ExcelUtils {

	
	/**
	 *读取两种格式的文件 
	 * @throws IOException 
	 */
	public static void readExcel(String fileName, InputStream inputStream) throws IOException {
		//判断读取文件的格式
		boolean ret = isXls(fileName);
		Workbook workbook = null;
		
		if(ret == true) {//说明后缀是xls
			workbook= new HSSFWorkbook(inputStream);
			  
		} else {
			workbook = new XSSFWorkbook(inputStream);
		}
		
		Sheet sheet = workbook.getSheetAt(0);
		
		int lastRowNum = sheet.getLastRowNum();
		for (int i = 0; i<=lastRowNum;i++) {
			Row row = sheet.getRow(i);
			int lastCellNum = row.getLastCellNum();
			for(int j=0; j < lastCellNum; j++) {
				Cell cell = row.getCell(j);
				if(cell!= null) {
					cell.setCellType(CellType.STRING);
					System.out.println(cell.getStringCellValue());
				}
						
						
			}
			
		}
		workbook.close();
		
	}
	
	public static List<Map<String,Object>> readExcel2(String fileName, InputStream inputStream) throws IOException {
		//判断读取文件的格式
		boolean ret = isXls(fileName);
		Workbook workbook = null;
		
		if(ret == true) {//说明后缀是xls
			workbook= new HSSFWorkbook(inputStream);
			  
		} else {
			workbook = new XSSFWorkbook(inputStream);
		}
		
		Sheet sheet = workbook.getSheetAt(0);
		//获取第一行数据，本行存的是数据的key值
		Row row2 = sheet.getRow(0);
		int lastCellNum = row2.getLastCellNum();
		//将key值存到数组里面
		String[] titles = new String[lastCellNum];
		for(int i=0; i < lastCellNum; i++) {
			titles[i] = row2.getCell(i).getStringCellValue();
		}
		
		
		int lastRowNum = sheet.getLastRowNum();
		
		List<Map<String, Object>> list = new ArrayList<>();
		for (int i = 1; i<=lastRowNum;i++) {
			Map<String, Object> map = new HashedMap<>();
			Row row = sheet.getRow(i);
			for(int j=0; j < lastCellNum; j++) {
				Cell cell = row.getCell(j);
				if(cell!= null) {
					cell.setCellType(CellType.STRING);
					map.put(titles[j], cell.getStringCellValue());
				}
			}
			list.add(map);
		}
		workbook.close();
		return list;
	}
	
	
	
	public static boolean isXls(String fileName){
		// aa.xlsx
		// (?i)忽略大小写
		if(fileName.matches("^.+\\.(?i)(xls)$")){
			return true;
		}else if(fileName.matches("^.+\\.(?i)(xlsx)$")){
			return false;
		}else{
			throw new RuntimeException("格式不对");
		}
	}

	public static void exportExcel(OutputStream outputStream){
		List<SysUser> list = new ArrayList<>();
		for(int i = 0; i < 4; i++){
			SysUser u = new SysUser();
			u.setUsrId(i);
			u.setUsrName("haha" + i);
			u.setUsrPassword("123");
			u.setUsrFlag("1");
			u.setUsrRoleId(1);
			list.add(u);
		}
		try{
			XSSFWorkbook workBook = new XSSFWorkbook();
			// 创建sheet对象
			XSSFSheet sheet = workBook.createSheet("hahaha");
			
			for(int i = 0; i < list.size(); i++){
				// 创建行对象
				XSSFRow row = sheet.createRow(i);
				
				// 创建单元格对象
				row.createCell(0).setCellValue(list.get(i).getUsrId());
				row.createCell(1).setCellValue(list.get(i).getUsrName());
				row.createCell(2).setCellValue(list.get(i).getUsrPassword());
				row.createCell(3).setCellValue(list.get(i).getUsrRoleId());
				row.createCell(4).setCellValue(list.get(i).getUsrFlag());
			}
			workBook.write(outputStream);
			
			workBook.close();
		}catch(Exception e){
			
		}
		
	}
	
}
