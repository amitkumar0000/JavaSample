package annotation;

import java.lang.annotation.*;

@MyAnnotation
class Base{
   @MyAnnotation
   @Deprecated
    public void show(){}
}

@Deprecated
@TestAnnotation(os = "ios" ,ver = 10)
class Derived extends Base{

    @Override
    public void show(){

    }
}

public class AnnotationDemo {
    Base derived2 =  new Derived();
    public AnnotationDemo(){
        derived2.show();
        Class cls = derived2.getClass();
        Annotation an = cls.getAnnotation(TestAnnotation.class);
        TestAnnotation testAnnotation = (TestAnnotation)an;
        System.out.println("OS "+ testAnnotation.os() + " ver::"+ testAnnotation.ver());
    }
}

@Documented
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface MyAnnotation{

}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface  TestAnnotation{
    String os() default "Android";
    int ver() default 1;

}


