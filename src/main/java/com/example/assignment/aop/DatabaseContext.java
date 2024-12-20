package com.example.assignment.aop;

import com.example.assignment.util.DatabaseType;

/**
 * Database Context.
 */
public class DatabaseContext {

    private static final ThreadLocal<DatabaseType> CONTEXT = new ThreadLocal<>();

    public static void set(DatabaseType databaseType) {
        CONTEXT.set(databaseType);
    }

    public static DatabaseType getDatabaseType() {
        return CONTEXT.get();
    }

    public static void reset() {
        CONTEXT.set(DatabaseType.UPDATABLE);
    }
}
