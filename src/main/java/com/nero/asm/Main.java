package com.nero.asm;


import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    private static final String PATH = "./target/classes/com/nero/asm/";
    public static void main(String[] args) {

        try {
            ClassReader classReader = new ClassReader("com.nero.asm.Music");
            ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS);
            ClassVisitor visitor = new MyVisitor(writer);
            classReader.accept(visitor, ClassReader.EXPAND_FRAMES);

            byte[] result = writer.toByteArray();

            // 将新生成的.class文件覆盖原有的文件
            File file = new File(PATH + "Music.class");
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(result);
            outputStream.close();

            // 此处运行已经是增强之后的类
            Music music = new Music();
            music.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
