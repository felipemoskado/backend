//package repository
//
//import config.JooqConfigTest
//import helper.RandomTest
//import main.kotlin.repository.UsuarioRepository
//import org.assertj.core.api.Assertions.*
//import org.jooq.DSLContext
//import org.jooq.Tables.*
//import org.jooq.tables.records.UsuarioRecord
//import org.junit.Before
//import org.junit.Test
//import org.junit.runner.RunWith
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.test.context.ActiveProfiles
//import org.springframework.test.context.jdbc.Sql
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
//import org.springframework.transaction.annotation.Transactional
//
//@RunWith(SpringJUnit4ClassRunner::class)
//@SpringBootTest(classes = [UsuarioRepository::class, JooqConfigTest::class])
//@Sql(scripts = ["classpath:usuario-repository.sql"])
//@ActiveProfiles("test")
//class UsuarioRepositoryIT {
//
//    @Autowired
//    private lateinit var dslContext: DSLContext
//    private lateinit var usuarioRepository: UsuarioRepository
//
//    @Before
//    fun setup() {
//        usuarioRepository = UsuarioRepository(dslContext)
//    }
//
//    @Test
//    fun `Deve inserir novo usuario`() {
//        val salvou = usuarioRepository.save(record = usuarioRecord())
//
//        assertThat(salvou).isTrue()
//
//        usuarioRepository.findOne(ID_TEST)!!.run {
//            assertThat(this[USUARIO.ID]).isEqualTo(ID_TEST)
//            assertThat(this[USUARIO.LOGIN]).isEqualTo(LOGIN_TEST)
//            assertThat(this[USUARIO.SENHA]).isEqualTo(PASSWORD_TEST)
//        }
//    }
//
//    @Test
//    fun `Deve atualizar novo usuario`() {
//        usuarioRepository.findOne(id = USUARIO_ID_EXISTENTE)!!.run {
//            assertThat(this[USUARIO.ID]).isEqualTo(USUARIO_ID_EXISTENTE)
//            assertThat(this[USUARIO.LOGIN]).isEqualTo("loucura@gmail.com")
//            assertThat(this[USUARIO.SENHA]).isEqualTo("!@#$%&*()")
//        }
//
//        assertThat(usuarioRepository.findAll().size).isEqualTo(1)
//
//        val atualizou = usuarioRepository.save(record = usuarioRecord(id = USUARIO_ID_EXISTENTE))
//
//        assertThat(atualizou).isTrue()
//
//        usuarioRepository.findOne(USUARIO_ID_EXISTENTE)!!.run {
//            assertThat(this[USUARIO.ID]).isEqualTo(USUARIO_ID_EXISTENTE)
//            assertThat(this[USUARIO.LOGIN]).isEqualTo(LOGIN_TEST)
//            assertThat(this[USUARIO.SENHA]).isEqualTo(PASSWORD_TEST)
//        }
//    }
//
//    private fun usuarioRecord(id: Long = ID_TEST): UsuarioRecord =
//        UsuarioRecord().also {
//            it.id = id
//            it.login = LOGIN_TEST
//            it.senha = PASSWORD_TEST
//        }
//
//    companion object {
//        private const val USUARIO_ID_EXISTENTE = 1L
//        private val ID_TEST = RandomTest.positiveLong()
//        private val LOGIN_TEST = RandomTest.generateString()
//        private val PASSWORD_TEST = RandomTest.generateString()
//    }
//}