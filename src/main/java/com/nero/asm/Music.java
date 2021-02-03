package com.nero.asm;

public class Music {
    public void run() {
        // 编译期在这里插入代码 System.out.println("asm insert before");
        System.out.println("this is run");
        // 编译期在这里插入代码 System.out.println("asm insert after");
    }


    public int getValue() {
        System.out.println("this is run");
        // 编译期在 return 语句之前插入 System.out.println("insert before return");
        return 1;
    }

    public void put(String value) {
        // 注意方法 desc
    }

    private void add(String value, Thread thread) {
        // 注意方法 desc
    }

    protected Music fake(int[] nums, String[] values) {
        // 注意方法 desc
        return null;
    }
}
