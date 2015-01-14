package com.dogvacay.booking.utils

import org.junit.Test

/**
 * Created by jeffreygortatowsky on 1/13/15.
 */
class ServiceUtilsTest extends GroovyTestCase {
    static Set<String> servicesStrings = ["BOARDING", "DAYCARE", "TAXI", "GROOMING", "BATH", "CARE", "WALKING"] as Set
    @Test
    void testServiceUtils() {
        assertEquals(servicesStrings.size(), ServiceUtils.servicesStrings.size())
        servicesStrings.each {
            assertTrue("And that there are the same values", ServiceUtils.isValidService(it));
        }
        assertFalse("Bad value is not valid", ServiceUtils.isValidService("TOENAIL_CLIPPING"))
        assertTrue("Null is assumed to be BOARDING as it is in the DB", ServiceUtils.isValidService(null))
    }
}
