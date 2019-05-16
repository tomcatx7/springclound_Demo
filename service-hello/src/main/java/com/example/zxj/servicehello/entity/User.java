package com.example.zxj.servicehello.entity;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import lombok.Data;
import java.io.FileNotFoundException;

@Data
@TableName("user")
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;

    public static void main(String[] args)  {
        AutoGenerator mpg = new AutoGenerator();
        //全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("D:\\code\\springclound\\springclound_Demo\\service-hello\\src\\main\\java");
        gc.setAuthor("zhongxiajun");
        gc.setOpen(false);
        mpg.setGlobalConfig(gc);
        //数据库配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUrl("jdbc:mysql://localhost:3306/mydatabase?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);
        //策略配置
//        StrategyConfig stc = new StrategyConfig();
//        stc.setColumnNaming()
        //包配置
        PackageConfig pcg = new PackageConfig();
        pcg.setModuleName("user");
        pcg.setParent("com.example.zxj");
        pcg.setController("controller");
        pcg.setEntity("entity");
        pcg.setMapper("mapper");
        pcg.setService("service");
        pcg.setServiceImpl("serviceImpl");
        pcg.setXml("mapperXml");
        mpg.setPackageInfo(pcg);

        mpg.execute();
    }
}
