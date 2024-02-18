package opel_demo.asm;

import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassWriter;
import com.sun.xml.internal.ws.org.objectweb.asm.MethodVisitor;

public class AddSecurityCheckClassAdapter extends ClassAdapter {
    public AddSecurityCheckClassAdapter(ClassWriter cv) {
        super((com.sun.xml.internal.ws.org.objectweb.asm.ClassVisitor) cv);
    }

    // 重写 visitMethod，访问到 "operation" 方法时，给出自定义 MethodVisitor，实际改写方法内容
    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
        System.out.println("AddSecurityCheckClassAdapter;" + "name:" + name + ";desc:" + desc + ";signature:" + signature);
        MethodVisitor wrappedMv = mv;
        if (mv != null) {
            if ("operation".equals(name)) {
                // 使用自定义的MethodVisitor,实际改写方法内容
                wrappedMv = new AddSecurityCheckMethodAdapter(mv);
            }
        }
        return wrappedMv;
    }
}