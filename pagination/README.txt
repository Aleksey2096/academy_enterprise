mvn liquibase:update (update default profile main db)

mvn liquibase:update (update second profile test db)

mvn liquibase:rollback -Dliquibase.rollbackCount=1 (drop test table)

mvn -Ptest test (executes tests with test hibernate configuration)
