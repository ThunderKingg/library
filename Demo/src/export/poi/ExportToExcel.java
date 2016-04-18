package export.poi;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/**
 * 一个ExportToExcel对象就是一个Excel文件
 * 1.创建一页
 * 2.循环将要进行导出的数据
 * 3.循环中调用getRow方法创建一行
 * 4.如果想要增加新的一行先调用reset重置行数然后从第一步开始
 * 测试数据export.entity.Test
 * @author 王雷
 *
 */
public class ExportToExcel {
	
	private int numberRow = 1;
	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	private HSSFRow row;
	
	public ExportToExcel(){
		workbook = new HSSFWorkbook();
	}
	
	public void reset() {
		numberRow = 1;
	}
	
	public HSSFWorkbook getWorkbook(){
		return workbook;
	}
	
	public HSSFRow getRow(){
		row = sheet.createRow(numberRow++);
		return row;
	}
	/**
	 * 
	 * @param pageName 为新创建的这一页命名
	 * @param header 表示一页的标题
	 */
	public void createPage(String pageName, String[] header) {
		sheet = workbook.createSheet(pageName);
		row = sheet.createRow(0);
		for(int i = 0; i < header.length; i++){
			row.createCell(i,HSSFCell.CELL_TYPE_STRING).setCellValue(header[i]);
		}
	}
}
