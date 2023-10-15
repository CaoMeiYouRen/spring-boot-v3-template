package ltd.cmyr.demo.util;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class Generator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC",
                        "root",
                        "")
                .globalConfig(builder -> {
                    builder.author("caomeiyouren") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            // 覆盖已生成文件
//                            .fileOverride()
                            .dateType(DateType.ONLY_DATE)
                            .outputDir("src/main/java"); // 指定输出目录
                })
                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
//                    if (typeCode == Types.DATE) {
//                        // 自定义类型转换
//                        return DbColumnType.LOCAL_DATE_TIME;
//                    }
                    return typeRegistry.getColumnType(metaInfo);

                }))
                .packageConfig(builder -> {
                    builder.parent("ltd.cmyr") // 设置父包名
                            .moduleName("demo") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "src/main/resources/mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_") // 设置过滤表前缀
                            .entityBuilder()
                            .enableChainModel()
                            .enableFileOverride();
//                            .naming(NamingStrategy.no_change); //
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
