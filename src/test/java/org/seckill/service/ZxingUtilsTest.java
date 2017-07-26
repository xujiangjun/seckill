package org.seckill.service;

import com.google.zxing.WriterException;
import org.junit.Test;
import org.seckill.util.ZXingUtils;

import java.io.IOException;

/**
 * @author xujiangjun
 * @date 2017-07-06 14:39
 */
public class ZxingUtilsTest {

    @Test
    public void testBuildQRCode() throws IOException, WriterException {
        ZXingUtils.Encode.buildQRCode("www.baidu.com", "/Users/xujiangjun", "QRCode.jpg", ZXingUtils.ImageType.JPEG);
    }
}
