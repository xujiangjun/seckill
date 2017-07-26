package org.seckill.util;

import com.google.zxing.*;
import com.google.zxing.Reader;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.multi.GenericMultipleBarcodeReader;
import com.google.zxing.multi.MultipleBarcodeReader;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.*;

/**
 * @author xujiangjun
 * @date 2017-07-06 14:22
 */
public class ZXingUtils {
    public static enum ImageType {
        JPEG("jpeg"),PNG("png"),GIF("gif");
        private String value;

        ImageType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    /**编码*/
    public static class Encode {

        // 用于设置QR二维码参数
        private static Map<EncodeHintType, Object> HINTS;
        static {
            HINTS = new EnumMap<EncodeHintType,Object>(EncodeHintType.class);
            HINTS.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            // 设置QR二维码的纠错级别（H为最高级别）具体级别信息
            HINTS.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            HINTS.put(EncodeHintType.MARGIN, 1);
        }
        /**
         * 生成二维码
         * @param widthAndHeight    高宽
         * @param content           二维码内容
         * @param os                输出流
         */
        public static void buildQRCode(int widthAndHeight, String content, OutputStream os, ImageType imageType) throws WriterException, IOException {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, widthAndHeight, widthAndHeight, HINTS);// 生成矩阵
            MatrixToImageWriter.writeToStream(bitMatrix, imageType.getValue(), os);
        }

        public static void buildQRCode(String content, OutputStream os, ImageType imageType) throws WriterException, IOException {
            buildQRCode(200, content, os, imageType);
        }

        /**
         * 生成二维码
         * @param widthAndHeight    高宽
         * @param content           二维码内容
         * @param filePath          输出目录
         * @param fileName          输出文件名
         * @param imageType         输出文件类型
         */
        public static void buildQRCode(int widthAndHeight, String content, String filePath, String fileName, ImageType imageType) throws WriterException, IOException {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
                    BarcodeFormat.QR_CODE, widthAndHeight, widthAndHeight, HINTS);
            Path path = FileSystems.getDefault().getPath(filePath, fileName);
            MatrixToImageWriter.writeToPath(bitMatrix, imageType.getValue(), path);// 输出图像
        }

        public static void buildQRCode(String content, String filePath, String fileName, ImageType imageType) throws WriterException, IOException {
            buildQRCode(200, content,filePath,fileName,imageType);
        }
    }


    /**解码*/
    public static class Decode {

        private static final Map<DecodeHintType,Object> HINTS;
        private static final Map<DecodeHintType,Object> HINTS_PURE;
        static {
            HINTS = new EnumMap<DecodeHintType,Object>(DecodeHintType.class);
            HINTS.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
            HINTS.put(DecodeHintType.POSSIBLE_FORMATS, EnumSet.allOf(BarcodeFormat.class));
            HINTS_PURE = new EnumMap<DecodeHintType,Object>(HINTS);
            HINTS_PURE.put(DecodeHintType.PURE_BARCODE, Boolean.TRUE);
        }

        /**
         * 解析二维码
         */
        public static Collection<Result> readQRCode(File qrCode) throws ReaderException, IOException {
            FileInputStream inputStream = new FileInputStream(qrCode);
            return readQRCode(inputStream);
        }

        public static Collection<Result> readQRCode(InputStream inputStream) throws ReaderException, IOException {
            LuminanceSource source = new BufferedImageLuminanceSource(ImageIO.read(inputStream));
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(source));

            Collection<Result> results = new ArrayList<Result>(1);
            ReaderException savedException = null;
            Reader reader = new MultiFormatReader();
            try {
                //寻找多个条码
                MultipleBarcodeReader multiReader = new GenericMultipleBarcodeReader(reader);
                Result[] theResults = multiReader.decodeMultiple(binaryBitmap, HINTS);
                if (theResults != null) {
                    results.addAll(Arrays.asList(theResults));
                }
            } catch (ReaderException re) {
                savedException = re;
            }

            if (results.isEmpty()) {
                try {
                    //寻找纯条码
                    Result theResult = reader.decode(binaryBitmap, HINTS_PURE);
                    if (theResult != null) {
                        results.add(theResult);
                    }
                } catch (ReaderException re) {
                    savedException = re;
                }
            }

            if (results.isEmpty()) {
                try {
                    //寻找图片中的正常条码
                    Result theResult = reader.decode(binaryBitmap, HINTS);
                    if (theResult != null) {
                        results.add(theResult);
                    }
                } catch (ReaderException re) {
                    savedException = re;
                }
            }

            if (results.isEmpty()) {
                try {
                    //再次尝试其他特殊处理
                    BinaryBitmap hybridBitmap = new BinaryBitmap(new HybridBinarizer(source));
                    Result theResult = reader.decode(hybridBitmap, HINTS);
                    if (theResult != null) {
                        results.add(theResult);
                    }
                } catch (ReaderException re) {
                    savedException = re;
                }
            }
            if (results.isEmpty()){
                throw savedException;
            }else {
                return results;
            }
        }


        public static Result readQRCodeResult(File qrCode) throws ReaderException, IOException {
            FileInputStream inputStream = new FileInputStream(qrCode);
            return readQRCodeResult(inputStream);
        }
        public static Result readQRCodeResult(InputStream inputStream) throws ReaderException, IOException {
            Collection<Result> results = readQRCode(inputStream);
            if (!results.isEmpty()){
                //寻找结果集中非空的结果
                for (Result result : results){
                    if (result != null){
                        return result;
                    }
                }
            }
            throw NotFoundException.getNotFoundInstance();
        }
    }
}
