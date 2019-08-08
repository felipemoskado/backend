//package config
//
//import org.jooq.impl.DataSourceConnectionProvider
//import org.jooq.impl.DefaultConfiguration
//import org.jooq.impl.DefaultDSLContext
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.jdbc.datasource.DriverManagerDataSource
//import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy
//import javax.sql.DataSource
//
//@Configuration
//open class JooqConfigTest {
//
//    @Bean
//    open fun dataSource(): DataSource =
//        DriverManagerDataSource().apply {
//            setDriverClassName("org.postgresql.Driver")
//            url = "jdbc:postgresql://localhost:5432/postgres"
//            username = "postgres"
//            password = ""
//        }
//
//    @Bean
//    open fun connectionProvider(): DataSourceConnectionProvider =
//        DataSourceConnectionProvider(TransactionAwareDataSourceProxy(dataSource()))
//
//    @Bean
//    open fun dsl(): DefaultDSLContext = DefaultDSLContext(configuration())
//
//    open fun configuration(): DefaultConfiguration {
//        val defaultConfiguration = DefaultConfiguration()
//        defaultConfiguration.set(connectionProvider())
//        return defaultConfiguration
//    }
//}