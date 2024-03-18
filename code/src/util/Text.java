package util;

public class Text {
    public static boolean notEmptyOrNull(String s) {
        return (s != null && !s.isEmpty());
    }
    public static boolean emptyOrNull(String s) {
        return (s == null || s.isEmpty());
    }
}
