package com.external.activeandroid.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {

    public enum ConflictAction {
        ROLLBACK,
        ABORT,
        FAIL,
        IGNORE,
        REPLACE
    }

    public enum ForeignKeyAction {
        SET_NULL,
        SET_DEFAULT,
        CASCADE,
        RESTRICT,
        NO_ACTION
    }

    int length() default -1;

    String name();

    boolean notNull() default false;

    ForeignKeyAction onDelete() default ForeignKeyAction.NO_ACTION;

    ConflictAction onNullConflict() default ConflictAction.FAIL;

    ConflictAction onUniqueConflict() default ConflictAction.FAIL;

    ForeignKeyAction onUpdate() default ForeignKeyAction.NO_ACTION;

    boolean unique() default false;
}
