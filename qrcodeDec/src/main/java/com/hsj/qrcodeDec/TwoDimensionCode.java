package com.hsj.qrcodeDec;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.junit.Test;

import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;  

public class TwoDimensionCode {

    /** 
     * 解析图像 
     */  
	@Test  
    public void testDecode() {  
        String filePath = "http://139.198.13.100:7010/resource/M00/00/43/wKgAA1oKik6ASojMAAAB9enLL80510.png";  
        BufferedImage image;
        URL imgurl = null;
        try {  
        	imgurl = new URL(filePath);
            image = ImageIO.read(imgurl);  
            LuminanceSource source = new BufferedImageLuminanceSource(image);  
            Binarizer binarizer = new HybridBinarizer(source);  
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);  
            Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();  
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");  
            Result result = new MultiFormatReader().decode(binaryBitmap, hints);// 对图像进行解码  
            String content = result.getText();
            System.out.println("二维码图片中内容：  "+content);  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (NotFoundException e) {  
            e.printStackTrace();  
        }  
    }  
} 

