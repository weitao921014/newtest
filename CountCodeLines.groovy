/**
 * <pre>
 * 一个统计目录下所有java文件总共行数的小脚本，想知道某个巨大的安卓项目总行数吗？
 * 当然，你也可以修改过滤，以统计其他类型的源码
 * 在ubuntu16上执行正常
 * 初识groovy，用的并不熟练
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
            final int line = 0;
            file.eachLine { line += 1; }
            lines += line;
            filecount += 1;
            println(filecount+" found file [" + file + "] \033[0;32m[" + line + "]\033[0m"); 
        }
    }
}

countFiles(f);
println("*********************************************");
println("total found \033[0;32m${filecount}\033[0m files, total \033[0;32m${lines}\033[0m lines");
