package com.trung.util;

public class Logger {
    enum Type {
        VERBOSE, DEBUG
    }

    public static boolean DEBUG;

    public static void verbose(String message) {
        log(Type.VERBOSE, "", message);
    }

    public static void debug(String message) {
        if (DEBUG) {
            log(Type.DEBUG, "", message);

        }
    }

    public static void debug(Class aClass, String message) {
        if (DEBUG) {
            log(Type.DEBUG, aClass.getCanonicalName(), message);
        }
    }

    private static void log(Type type, String prefix, String message) {
        System.out.printf("[%s][%s]: %s\n", type.name(), prefix, message);
    }

}
