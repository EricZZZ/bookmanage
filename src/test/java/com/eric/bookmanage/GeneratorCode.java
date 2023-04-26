package com.eric.bookmanage;

import java.sql.SQLException;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class GeneratorCode {

    /**
     * 数据源配置
     */
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig.Builder(
            "jdbc:sqlite:G:/demo/my-java-project/bookmanage/db/bookmanageDB.db", "", "");

    /**
     * 执行 run
     */
    public static void main(String[] args) throws SQLException {

        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                // 全局配置
                .globalConfig((scanner, builder) -> builder.author(scanner.apply("请输入作者名称")).outputDir("G:/demo/my-java-project/bookmanage/src/main/java"))
                // 包配置
                .packageConfig((scanner, builder) -> builder.parent(scanner.apply("请输入包名")))
                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(scanner.apply("请输入表名，多个表名用,隔开")))

                /*
                 * 模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
                 * .templateEngine(new BeetlTemplateEngine())
                 * .templateEngine(new FreemarkerTemplateEngine())
                 */
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

}
