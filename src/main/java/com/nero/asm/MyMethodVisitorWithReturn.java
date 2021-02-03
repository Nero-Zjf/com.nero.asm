package com.nero.asm;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import java.io.PrintStream;

public class MyMethodVisitorWithReturn extends MethodVisitor {
    public MyMethodVisitorWithReturn(int api, MethodVisitor mv) {
        super(api, mv);
    }

    @Override
    public void visitInsn(int opcode) {
        System.out.println("opcode==" + opcode);
        if (opcode == Opcodes.IRETURN) {
            hack(mv, "insert before return");
        }
        super.visitInsn(opcode);
    }

    private static void hack(MethodVisitor mv, String msg) {
        mv.visitFieldInsn(
                Opcodes.GETSTATIC,
                Type.getInternalName(System.class),
                "out",
                Type.getDescriptor(PrintStream.class)
        );
        mv.visitLdcInsn(msg);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                Type.getInternalName(PrintStream.class),
                "println",
                "(Ljava/lang/String;)V",
                false
        );
    }
}
