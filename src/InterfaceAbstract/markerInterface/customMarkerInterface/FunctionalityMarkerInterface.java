package InterfaceAbstract.markerInterface.customMarkerInterface;

public class FunctionalityMarkerInterface {
    public static void isMarker(ImplMarkerInterface implMarkerInterface){
        if(implMarkerInterface instanceof  MyMarkerInterface){
            System.out.println("Hi I am Marker Interface.... JVM will perform some special operation");
        }
    }

}
