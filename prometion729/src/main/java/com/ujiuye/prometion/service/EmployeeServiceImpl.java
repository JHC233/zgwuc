package com.ujiuye.prometion.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.ujiuye.prometion.mapper.EmployeeMapper;
import com.ujiuye.prometion.mapper.EmployeeRoleMapper;
import com.ujiuye.prometion.pojo.Employee;
import com.ujiuye.prometion.pojo.EmployeeRole;
import com.ujiuye.prometion.utils.MD5Utils;
import com.ujiuye.prometion.utils.PinyinHelperUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private EmployeeRoleService employeeRoleService;

    public int remove(int eid) {
//        查看一下中间表看中间表有没有数据
        List<EmployeeRole>  employeeRoleList=employeeRoleService.listByEmpFk(eid);
        if (employeeRoleList!=null && employeeRoleList.size()>0){
            return -1;
        }

        return employeeMapper.remove(eid);
    }

    @Override
    public List<Employee> listAll() {
        return employeeMapper.listAll();
    }

    @Override
    public Employee login(String username, String password) {
        Employee employee=employeeMapper.getByUserName(username);
        if (employee==null){
            return null;
        }
        if (MD5Utils.stringToMD5(password).equals(employee.getPassword())){
            return employee;
        }
        return null;

    }

    @Override
    public Employee getByUserName(String username) {
        return employeeMapper.getByUserName(username);
    }


    @Override
    public File getExcel(int pageNum) {
        PageHelper.startPage(pageNum,5);
        List<Employee> list = employeeMapper.list(null, null, null);
        PageInfo<Employee> page = new PageInfo<Employee>(list);
        File file=ListToExcel(page.getList(),pageNum);
        return file;
    }

    @Value("${excel.url}")
    private String excelurl;

    private File ListToExcel(List<Employee> list,int pageNum) {
        String filename ="用户数据第"+pageNum+"页";

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("filename");
        XSSFRow sheetRow = sheet.createRow(0);
        sheetRow.createCell(0).setCellValue("eid");
        sheetRow.createCell(1).setCellValue("ename");
        sheetRow.createCell(2).setCellValue("esex");
        sheetRow.createCell(3).setCellValue("eage");
        sheetRow.createCell(4).setCellValue("telephone");
        sheetRow.createCell(5).setCellValue("hiredate");
        sheetRow.createCell(6).setCellValue("pnum");
        sheetRow.createCell(7).setCellValue("username");
        sheetRow.createCell(8).setCellValue("remark");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        for(int i=0;i<list.size();i++){
            Employee employee = list.get(i);
            XSSFRow row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(employee.getEid());
            row.createCell(1).setCellValue(employee.getEname());
            row.createCell(2).setCellValue(employee.getEsex());
            row.createCell(3).setCellValue(employee.getEage());
            row.createCell(4).setCellValue(employee.getTelephone());
            String timeStr = format.format(employee.getHiredate());
            row.createCell(5).setCellValue(timeStr);
            row.createCell(6).setCellValue(employee.getPnum());
            row.createCell(7).setCellValue(employee.getUsername());
            row.createCell(8).setCellValue(employee.getRemark());
        }
        File file = new File(excelurl+filename+".xlsx");
        try {
            workbook.write(new FileOutputStream(file));
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Employee> list(int type,String keyword) {
        List<Employee> list=null;
        if (type==0){
            list=employeeMapper.list(null,null,null);
        }
        if (type==1){
            list=employeeMapper.list(keyword,null,null);
        }
        if (type==2){
            list=employeeMapper.list(null,keyword,null);
        }
        if (type==3){
            list=employeeMapper.list(null,null,keyword);
        }
        return list;
    }

    public int save(Employee employee,List<Integer> list) {

        //  设置密码
        employee.setPassword(MD5Utils.stringToMD5("123456"));

        //设置用户名
        while (true) {
            //  获取姓名的拼音字母
            String pinYinHeadChar= PinyinHelperUtil.getPinYinHeadChar(employee.getEname()).toLowerCase();
            // 生成四位随机数
            String number=String.valueOf(Math.random()).substring(3,7);
            String username=pinYinHeadChar+number;
            //查数据库
            Employee dbEmpolyee=employeeMapper.getByUserName(username);
            if(dbEmpolyee==null){
                  employee.setUsername(username);
                  break;
            }
     }
        // 添加员工
        int save=employeeMapper.save(employee);
        // 为这个员工添加角色
        Integer eid=employee.getEid();
        // 添加中间表 遍历     1，2,3
        for (Integer integer : list) { //integer为角色id
            EmployeeRole employeeRole = new EmployeeRole();
            employeeRole.setEmp_fk(eid);
            employeeRole.setRole_fk(integer);
            employeeRoleService.save(employeeRole);
        }
        return 1;
    }

    @Override
    public int update(Employee employee, List<Integer> list) {
//        先删除旧的角色
        employeeRoleService.removeByEmpFk(employee.getEid());
//        再添加
        Integer eid=employee.getEid();
//        添加中间表  遍历
        for (Integer integer : list) {
            EmployeeRole employeeRole=new EmployeeRole();
            employeeRole.setEmp_fk(eid);
            employeeRole.setRole_fk(integer);
            employeeRoleService.save(employeeRole);
        }
        return employeeMapper.update(employee);
    }

    @Override
    public int updateLogo(Employee employee) {
        return employeeMapper.update(employee);
    }

    public int update(Employee employee) {
        return employeeMapper.update(employee);
    }

    public Employee getByEid(int eid) {
        return employeeMapper.getByEid(eid);
    }


}
