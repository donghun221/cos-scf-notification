package model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.RegexValidator;
import org.junit.Test;

import common.SCFTestBase;
import model.COSEntity.COSBucketEntity;

public class COSEntityTest extends SCFTestBase {
    @Test
    public void testCOSBucketEntity_getName_HappyCaes() {
        COSBucketEntity entity = getBucketEntity4Put();
        RegexValidator validator = new RegexValidator(COSBucketRegex);
        assertTrue(validator.isValid(entity.getName()));
    }
    
    @Test
    public void testCOSBucketEntity_getAppId_HappyCase() {
        COSBucketEntity entity = getBucketEntity4Put();
        assertTrue(StringUtils.isNumeric(entity.getAppId()));
    }
    
    @Test
    public void testCOSBucketEntity_getRegion_HappyCase() {
        COSBucketEntity entity = getBucketEntity4Put();
        assertFalse(StringUtils.isNumeric(entity.getRegion()));
    }
    
    @Test
    public void testCOSBucketEntity_toString_HappyCase() {
        COSBucketEntity entity = getBucketEntity4Put();
        assertTrue(StringUtils.contains(entity.toString(), "bucketName"));
        assertTrue(StringUtils.contains(entity.toString(), "appId"));
        assertTrue(StringUtils.contains(entity.toString(), "region"));
    }
}
