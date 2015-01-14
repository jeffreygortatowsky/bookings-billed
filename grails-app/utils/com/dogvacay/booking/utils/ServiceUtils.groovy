package com.dogvacay.booking.utils

import org.apache.commons.lang.StringUtils

/**
 * Created by jeffreygortatowsky on 1/13/15.
 */

class ServiceUtils {
    static Set<String> servicesStrings = ["BOARDING", "DAYCARE", "TAXI", "GROOMING", "BATH", "CARE", "WALKING"] as Set

    static Boolean isValidService(String test) {
        if (StringUtils.isBlank(test))
            test = "BOARDING"
        return servicesStrings.contains(test.toUpperCase())
    }
}
