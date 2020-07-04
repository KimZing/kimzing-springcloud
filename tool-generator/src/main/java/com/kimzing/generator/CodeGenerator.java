package com.kimzing.generator;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.kimzing.utils.po.AbstractPO;
import com.kimzing.utils.string.StringUtil;

import java.util.ArrayList;
import java.util.List;

import static com.kimzing.generator.param.Parameters.*;

public class CodeGenerator {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator generator = new AutoGenerator();
        // 全局配置
        GlobalConfig globalConfig = getGlobalConfig();
        generator.setGlobalConfig(globalConfig);
        // 数据源配置
        DataSourceConfig dataSourceConfig = getDataSourceConfig();
        generator.setDataSource(dataSourceConfig);
        // 包配置
        PackageConfig packageConfig = getPackageConfig();
        generator.setPackageInfo(packageConfig);
        // 自定义配置
        InjectionConfig injectionConfig = getInjectionConfig();
        generator.setCfg(injectionConfig);
        // 配置模板
        TemplateConfig templateConfig = getTemplateConfig();
        generator.setTemplate(templateConfig);
        // 策略配置
        StrategyConfig strategy = getStrategyConfig();
        generator.setStrategy(strategy);
        // 设置模板并生成
        generator.setTemplateEngine(new FreemarkerTemplateEngine());
        generator.execute();
    }

    private static InjectionConfig getInjectionConfig() {
        InjectionConfig injectionConfig = new InjectionConfig() {@Override public void initMap() {}};

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return generaPath + "/src/main/resources/mapper/" + packageName
                        + "/" + StringUtil.upperFirstChar(tableInfo.getName()) + "Mapper" + StringPool.DOT_XML;
            }
        });

        injectionConfig.setFileOutConfigList(focList);
        return injectionConfig;
    }

    private static TemplateConfig getTemplateConfig() {
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        // 指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        templateConfig.setController(controller ? "templates/controller.java": "");
        templateConfig.setService(service ? "templates/service.java": "");
        templateConfig.setServiceImpl(serviceImpl ? "templates/serviceImpl-" + serviceImplType + ".java": "");
        templateConfig.setMapper(mapper ? "templates/mapper.java": "");
        templateConfig.setEntity(entity ? "templates/entity.java": "");
        templateConfig.setXml(xml ? "templates/mapper.xml": "");
        return templateConfig;
    }

    private static StrategyConfig getStrategyConfig() {
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass(AbstractPO.class);
        //TODO 逻辑删除， 另外生成api和服务的包要分开
        // strategy.setLogicDeleteFieldName()
        strategy.setEntityLombokModel(true);
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns(superEntityColumns);
        strategy.setInclude(tables);
        strategy.setChainModel(true);
        strategy.setEntityTableFieldAnnotationEnable(true);
        return strategy;
    }

    private static PackageConfig getPackageConfig() {
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.kimzing");
        packageConfig.setModuleName(moduleName);
        packageConfig.setController("controller." + packageName);
        packageConfig.setService("service." + packageName);
        packageConfig.setServiceImpl("service." + packageName + ".impl");
        packageConfig.setMapper("mapper." + packageName);
        packageConfig.setEntity("mapper." + packageName + ".po");
        packageConfig.setXml("mapper." + packageName);

        return packageConfig;
    }

    private static DataSourceConfig getDataSourceConfig() {
        DataSourceConfig dataSource = new DataSourceConfig();
        dataSource.setUrl("jdbc:mysql://" + url + "?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dataSource.setDriverName("com.mysql.jdbc.Driver");
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    /**
     * 全局配置
     * @return
     */
    private static GlobalConfig getGlobalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(outputDir);
        globalConfig.setAuthor(author);
        globalConfig.setOpen(needOpenDir);
        globalConfig.setBaseResultMap(baseResultMap);
        globalConfig.setFileOverride(fileOverride);
        globalConfig.setBaseColumnList(baseColumnList);
        globalConfig.setEntityName(entityName);
        globalConfig.setMapperName(mapperName);
        globalConfig.setXmlName(xmlName);
        globalConfig.setServiceName(serviceName);
        globalConfig.setServiceImplName(serviceImplName);
        globalConfig.setControllerName(controllerName);
        return globalConfig;
    }

}