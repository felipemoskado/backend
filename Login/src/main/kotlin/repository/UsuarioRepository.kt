package main.kotlin.repository

import org.jooq.DSLContext
import org.jooq.Tables.USUARIO
import org.jooq.tables.records.UsuarioRecord
import org.springframework.stereotype.Repository

@Repository
class UsuarioRepository(private val dslContext: DSLContext) {

    fun save(record: UsuarioRecord): Boolean =
        if (record.id == null)
            dslContext.insertInto(USUARIO).set(record).execute() > 0
        else
            dslContext.update(USUARIO).set(record).where(USUARIO.ID.eq(record.id)).execute() > 0

    fun delete(id: Long): Boolean = dslContext.deleteFrom(USUARIO).where(USUARIO.ID.eq(id)).execute() > 0

    fun findAll(): List<UsuarioRecord> = dslContext.selectFrom(USUARIO).fetch()

    fun findOne(id: Long): UsuarioRecord? = dslContext.selectFrom(USUARIO).where(USUARIO.ID.eq(id)).fetchOne()
}