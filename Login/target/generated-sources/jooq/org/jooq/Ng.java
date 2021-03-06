/*
 * This file is generated by jOOQ.
 */
package org.jooq;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.impl.SchemaImpl;
import org.jooq.tables.Usuario;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Ng extends SchemaImpl {

    private static final long serialVersionUID = 1742288897;

    /**
     * The reference instance of <code>ng</code>
     */
    public static final Ng NG = new Ng();

    /**
     * The table <code>ng.usuario</code>.
     */
    public final Usuario USUARIO = org.jooq.tables.Usuario.USUARIO;

    /**
     * No further instances allowed
     */
    private Ng() {
        super("ng", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Usuario.USUARIO);
    }
}
