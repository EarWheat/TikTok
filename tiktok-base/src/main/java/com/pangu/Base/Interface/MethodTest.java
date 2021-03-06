package com.pangu.Base.Interface;


/*
 * @author:liuzhaolu
 * @createTime: 2020-08-05 18:04
 * @desc:方法测试
 */
public class MethodTest {

    static class User{
        String name;
        Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public void show(){
            System.out.println(this.name + " is " + this.age + " years old!");
        }
    }

    public static void main(String[] args) {
        User user = new User();
        user.setName("zero");
        method_1(user);
        user.show();
        method_2(user);
        user.show();
    }

    private static void method_1(User param){
        param.setAge(18);
    }

    private static User method_2(User param){
        param.setName("Liu liu");
        return param;
    }
}
