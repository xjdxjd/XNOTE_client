package com.xnote.client.common.utils.security;

import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.Random;

@Component("vcUtils")
public class VerifyCodeUtils {

	public Color getRandColor(int fc,int bc) {

		Random random = new Random();
        if(fc>255)
            fc = 255;
        if(bc>255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r,g,b);
	}
}
