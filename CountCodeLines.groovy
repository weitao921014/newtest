/**
 * <pre>
 * 一个统计目录下所有java文件总共行数的小脚本，想知道某个巨大的安卓项目总行数吗？
 * 当然，你也可以修改过滤，以统计其他类型的源码
 * 在ubuntu16上执行正常
 * 初识groovy，用的并不熟练
 *
 * 关于Linux下的终端颜色:
 * \033 声明了转义序列的开始，然后是 [ 开始定义颜色,后面定义了高亮显示字符,然后是背景颜色，接着是前景颜色。
 * 我们用 \033[0m 关闭转义序列， \033[0m 是终端默认颜色。
 *
 * 前景 背景颜色
 * -------------
 * 30 40 黑色
 * 31 41 紅色
 * 32 42 綠色
 * 33 43 黃色
 * 34 44 藍色
 * 35 45 紫紅色
 * 36 46 青藍色
 * 37 47 白色
 * </pre>
 */

import groovy.transform.Field

File f = new File(System.getProperty("user.dir"));
//File f = new File("/home/android/and/master/packages/apps/Settings/src/com/android");

println(f.getPath());
println("*********************************************");

@Field int lines = 0;
@Field int filecount = 0;

def countFiles(File file) {

    if (file.isDirectory()) {
        def list = file.listFiles();
        list.each { countFiles(it) }
    } else {
        if (file.getName().contains(".java")) {
            int line = 0;
            file.eachLine { line += 1; }
            println((filecount+1)+" found file [" + file + "] \033[0;32m[" + line + "]\033[0m");
            lines += line;
            filecount += 1;
        }
    }
}

countFiles(f);
println("*********************************************");
println("total found \033[0;32m${filecount}\033[0m files, total \033[0;32m${lines}\033[0m lines");
