package main.kotlin.config

import org.h2.jdbcx.JdbcDataSource
import org.jooq.SQLDialect
import org.jooq.impl.DefaultConfiguration
import org.jooq.impl.DefaultExecuteListenerProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import javax.sql.DataSource
import org.jooq.impl.DefaultDSLContext
import org.jooq.impl.DataSourceConnectionProvider
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy



@Configuration
class JooqConfig {

    @Autowired
    private lateinit var environment: Environment

    @Bean
    open fun dataSource(): DataSource {
        val dataSource = JdbcDataSource()

        dataSource.setUrl(environment.getRequiredProperty("localhost"))
        dataSource.user = environment.getRequiredProperty("postgres")
        dataSource.password = environment.getRequiredProperty("")
        return dataSource
    }

    @Bean
    fun transactionAwareDataSource(): TransactionAwareDataSourceProxy {
        return TransactionAwareDataSourceProxy(dataSource())
    }

    @Bean
    fun transactionManager(): DataSourceTransactionManager {
        return DataSourceTransactionManager(dataSource())
    }

    @Bean
    fun connectionProvider(): DataSourceConnectionProvider {
        return DataSourceConnectionProvider(transactionAwareDataSource())
    }

    @Bean
    fun dsl(): DefaultDSLContext {
        return DefaultDSLContext(configuration())
    }

    @Bean
    fun configuration(): DefaultConfiguration {
        val jooqConfiguration = DefaultConfiguration()
        jooqConfiguration.set(connectionProvider())

        val sqlDialectName = environment.getRequiredProperty("jooq.sql.dialect")
        val dialect = SQLDialect.valueOf(sqlDialectName)
        jooqConfiguration.set(dialect)

        return jooqConfiguration
    }
}