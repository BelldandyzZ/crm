package com.xxz.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.xxz.bean.Employee;
import com.xxz.mapper.EmployeeMapper;
import com.xxz.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Map;

// 1.继承AnalysisEventListener
public class DemoDataListener<E> extends AnalysisEventListener<E> {

    private EmpService empService = new EmpService();

    // 3.读表头内容
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        //将表头信息导入集合（实际中不需要）
        System.out.println("表头信息：" + headMap);
    }

    // 4.所有都读取完了，执行这个方法
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        //一般在这里进行插入数据库操作（当然这只是我个人认为的，在尚医通项目和在线教育项目中，这个项目都是空的，插入数据库的操作在invoke(）方法中进行。而且invokeHeadMap方法也用不到，因为不需要读取表头信息，读取时导入，数据库中有字段（表头），不需要再导）
        //狂神讲的课中用到了这个方法，可以具体去看一下他的笔记
    }

    // 2.一行一行的读取内容（list集合），但是不读表头。
    @Override
    public void invoke(E e, AnalysisContext analysisContext) {
        System.out.println("==============Mapper：" + empService);
        //一般在这里进行导入集合操作（在项目中，一般所有业务操作，都在这个方法中进行）
        //EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();
        System.out.println("正在添加：" + e);
        int state = empService.insertEmp((Employee) e);
        System.out.println(state > 0 ? "插入成功！" : "插入失败！");
    }
}

