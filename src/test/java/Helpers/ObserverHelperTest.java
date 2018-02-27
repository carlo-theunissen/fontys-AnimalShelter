package Helpers;

import org.junit.Assert;
import org.junit.Test;

public class ObserverHelperTest {

    @Test
    public void DefaultTest(){
        ObserverHelper helper = new ObserverHelper();
        Assert.assertFalse(helper.Updated);
    }

    @Test
    public void ObserverTest(){
        ObserverHelper helper = new ObserverHelper();
        helper.update(null,null);
        Assert.assertTrue(helper.Updated);
    }
}
