# testMysqlJDBC
用来进行mysql的jdbc测试

源码里需要重新编译构建jdbc版本，包括jdbc5和jdbc8。
common为基本配置文件，包括数据库的链接信息和执行内容，有具体说明。
common的执行类型选择dbscaleshow时，测试的内容是 file/dbscaleshow等文件的内容，每行对应一个dbscale集群命令，目前完成了dbscale show的编写。
基本的建表，增删改查是固定的，涵盖mysql所有的基本数据类型。
