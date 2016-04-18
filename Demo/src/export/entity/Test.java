package export.entity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;

import export.poi.ExportToExcel;
/**
 * export.poi.ExportToExcel类测试
 * @author Administrator
 *
 */
public class Test {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		List<Employee> list1 = new ArrayList<Employee>();
		List<Department> list2 = new ArrayList<Department>();
		list1.add(new Employee(1, "张三", new Date(), 6000.00));
		list1.add(new Employee(2, "李四", new Date(), 12000.00));
		list1.add(new Employee(3, "王五", new Date(), 3000.00));
		list1.add(new Employee(4, "赵六", new Date(), 5000.00));
		list1.add(new Employee(5, "周七", new Date(), 8000.00));
		list2.add(new Department(1,"财务部"));
		list2.add(new Department(2,"人事部"));
		list2.add(new Department(3,"开发部"));
		
		String[] header1 = {
				"员工编号","员工姓名","入职时间","员工薪资"
		};
		String[] header2 = {
				"部门编号","部门名称"
		};
		
		ExportToExcel export = new ExportToExcel();
		
		export.createPage("员工信息",header1);
		for(Employee e : list1){
			HSSFRow row = export.getRow();
			row.createCell(0,HSSFCell.CELL_TYPE_NUMERIC).setCellValue(e.getId());
			row.createCell(1,HSSFCell.CELL_TYPE_STRING).setCellValue(e.getName());
			row.createCell(2,HSSFCell.CELL_TYPE_STRING).setCellValue(sdf.format(e.getTime()));
			row.createCell(3,HSSFCell.CELL_TYPE_NUMERIC).setCellValue(e.getSalary());
		}
		export.reset();
		
		export.createPage("部门信息", header2);
		for(Department d : list2){
			HSSFRow row = export.getRow();
			row.createCell(0,HSSFCell.CELL_TYPE_NUMERIC).setCellValue(d.getId());
			row.createCell(1,HSSFCell.CELL_TYPE_STRING).setCellValue(d.getName());
		}
		
		try {
			FileOutputStream out = new FileOutputStream("E:/a.xls");
			export.getWorkbook().write(out);
			out.close();
			System.out.println("ok");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
