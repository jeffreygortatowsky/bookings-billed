dataSource {
    pooled = true
    driverClassName = "com.mysql.jdbc.Driver"
    properties {
        maxActive = 50
        maxIdle = 25
        minIdle = 1
        initialSize = 1

        numTestsPerEvictionRun = 3
        maxWait = 10000

        testOnBorrow = true
        testWhileIdle = true
        testOnReturn = true

        validationQuery = "select now()"

        minEvictableIdleTimeMillis = 1000 * 60 * 5
        timeBetweenEvictionRunsMillis = 1000 * 60 * 5
    }
}

hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
//    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
}

// environment specific settings
environments {
    sandbox {
        dataSource {
            dbCreate = "validate"
            url = "jdbc:mysql://sandbox-db.dogvacay.com:3306/dogvacay?zeroDateTimeBehavior=convertToNull"
            username = "dogvacay"
            password = "#Tbnl..25H6&b20GgG"
        }
    }

    development {
        dataSource {
            dbCreate = "validate" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:mysql://localhost:3306/dogvacay"
            username = "root"
            password = ""
        }
    }

    test {
        dataSource {
            dbCreate = "validate"
            url = "jdbc:mysql://sandbox-db.dogvacay.com:3306/dogvacay?zeroDateTimeBehavior=convertToNull"
            username = "dogvacay"
            password = "#Tbnl..25H6&b20GgG"
        }
    }

    production {
        dataSource {
            dbCreate = "validate"
            url = "jdbc:mysql://readonly-4.crxknjyccvra.us-east-1.rds.amazonaws.com:3306/dogvacay?zeroDateTimeBehavior=convertToNull"
            username = "dogvacay"
            password = "#Tbnl..25H6&b20GgG"
        }
    }
}
