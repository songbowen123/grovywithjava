package com.example.testgrovyload;

import com.example.testgrovyload.inter.TestInterface;
import com.example.testgrovyload.util.ApplicationContextHelper;
import com.example.testgrovyload.util.CustomizedFunctionUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class TestgrovyloadApplication {

    public static void main(String[] args) throws Exception {
        ApplicationContext app = SpringApplication.run(TestgrovyloadApplication.class, args);
        ApplicationContextHelper.setContext(app);
        runTest();
    }

    public static void runTest() throws Exception {
        Path path = Paths.get("text.txt");

        String a="{\"error_message\":\"This shipment was converted to Send to Amazon and no updates can be made to this shipment\",\"has_errors\":true}";
        String javaCodeText = new String(Files.readAllBytes(path));
        String beanName = "testinterfaceImpl";
        CustomizedFunctionUtils.parseAndInject(beanName, javaCodeText);
        TestInterface bean = (TestInterface) ApplicationContextHelper.getContext().getBean(beanName);
        bean.soutTest();
    }
}
