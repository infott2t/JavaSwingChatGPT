package gptcode;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public  class Utilv1 {
    
    static int times;
    static int promptv;
    static int completionv;
    static int totalv;

    static int totalAll;

    static String contents;

     private static PropertyChangeSupport support = new PropertyChangeSupport(Utilv1.class);

    public static void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public static void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public static void setContents(String newContents) {
        String oldContents = contents;
        contents = newContents;
        int oldTotalAll = totalAll;
        totalAll += totalv;
        support.firePropertyChange("contents", oldContents, newContents);
        support.firePropertyChange("totalAll", oldTotalAll, totalAll);
    }




}
