package com.yinwq.chunting.generator;

import org.apache.ibatis.io.Resources;

import com.github.zhuyizhuo.generator.mybatis.generator.Generator;
import com.github.zhuyizhuo.generator.mybatis.generator.GeneratorBuilder;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2018/11/8 16:51
 */
public class Test {
    public static void main(String[] args) throws Exception {
        /** 此处使用 配置文件的绝对路径或者在项目中的相对路径
         * 本例配置文件路径在maven项目的src/main/resources文件夹下
         */
        Generator generator = new GeneratorBuilder()
                .build(Resources.getResourceAsStream("config.properties"));
        generator.generate();
    }
}
