package annotation;

import java.lang.annotation.*;

@MyAnnotation
class Base{
   @MyAnnotation
   @Deprecated
    public void show(){}
}

@Deprecated
class Derived extends Base{

    @Override
    public void show(){

    }
}

public class AnnotationDemo {
    Base derived2 =  new Derived();
    public AnnotationDemo(){
        derived2.show();
    }
}

@Documented
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface MyAnnotation{

}


