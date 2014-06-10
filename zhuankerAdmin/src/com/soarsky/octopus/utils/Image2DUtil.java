package com.soarsky.octopus.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 2D 图象简单处理工具类
 * <pre>
 * 本类提供"缩放2D图象尺寸"与"在图象上加上指定的文字"的静态方法，主要方法有：
 * 1、缩放2D图象尺寸 scale2DImage()
 * 2、在图象上加上指定的文字 drawTextTo2DImage()
 * </pre>
 */
public class Image2DUtil {

	private static final long serialVersionUID = 8863826860883362070L;
	
	/**
	 * 默认缩图片高度
	 */
	private static final int DEFAULTSMALLIMAGEWIDTH = 150;

	/**
	 * 缩放2D图象尺寸
	 * @param sourceFile 源图象 
	 * @param destFilePath 目标图象路径
	 * @return 缩放成功返回true, 否则返回false 
	 * @throws Exception
	 */
	public static boolean scale2DImage(File sourceFile, String destFilePath) throws Exception {
		return scale2DImage(sourceFile, new File(destFilePath), DEFAULTSMALLIMAGEWIDTH);
	}
	
	/**
	 * 缩放2D图象尺寸
	 * @param sourceFile 源图象 
	 * @param destFilePath 目标图象
	 * @return 缩放成功返回true, 否则返回false 
	 * @throws Exception
	 */
	public static boolean scale2DImage(File sourceFile, File destFilePath) throws Exception {
		return scale2DImage(sourceFile, destFilePath, DEFAULTSMALLIMAGEWIDTH);
	}
	
	/**
	 * 缩放2D图象尺寸
	 * @param sourceFile 源图象 
	 * @param destFilePath 目标图象
	 * @param destWidth 目标图象宽度（按比例缩放）
	 * @return 缩放成功返回true, 否则返回false 
	 * @throws Exception
	 */
	public static boolean scale2DImage(File sourceFile, File destFilePath, int destWidth) throws Exception {
		boolean result = false;
		if (sourceFile != null && destFilePath != null && !"".equals(destFilePath) && destWidth > 0) {

			Image srcImage = ImageIO.read(sourceFile);
			/**
			 * 原始图象尺寸
			 */
			int srcWidth = srcImage.getWidth(null);
			int srcHeight = srcImage.getHeight(null);
			
			/**
			 * 目标图象尺寸
			 */
			int destLocalWidth = destWidth;
			int destLocalHeight = (int)((double)srcHeight * (double)destLocalWidth / (double)srcWidth);

			BufferedImage destImage = new BufferedImage(destLocalWidth, destLocalHeight,
					BufferedImage.TYPE_INT_RGB);
			destImage.getGraphics().drawImage(srcImage, 0, 0, destLocalWidth,
					destLocalHeight, null);

			ImageIO.write(destImage, "JPEG", destFilePath);
			result = true;
		}
		return result;
	}

	/**
	 * 在图象上加上指定的文字
	 * @param sourceFile 源图象
	 * @param destFilePath 目标图象路径
	 * @param text 预加到图象上的文本 
	 * @throws Exception
	 */
	public static boolean drawTextTo2DImage(File sourceFile, String destFilePath, String text) throws Exception {
		boolean result = false;
		if (sourceFile != null && destFilePath != null && !"".equals(destFilePath) && text != null && !"".equals(text)) {

			BufferedImage sourceImage = ImageIO.read(sourceFile);

			Graphics2D g2d = sourceImage.createGraphics();
			
			g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,
					RenderingHints.VALUE_FRACTIONALMETRICS_ON);
			
			g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
					RenderingHints.VALUE_RENDER_QUALITY);
			
			g2d.setColor(new Color(0, 0, 255));
			
			g2d.setFont(new Font("黑体", Font.BOLD, 30));
			
			/**
			 * 原始图象尺寸
			 */
			int srcWidth = sourceImage.getWidth();
			int srcHeight = sourceImage.getHeight();
			
			int textAmount = 40 * text.length();
			int left = srcWidth - textAmount + (8 * (text.length() - 1));
			int top = srcHeight - 15;
			
			g2d.drawString(text, left, top);
			
			g2d.dispose();

			ImageIO.write(sourceImage, "JPEG", new File(destFilePath));
			result = true;
		}
		return result;
	}
	
	/**
	 * 返回图片的宽度
	 * @param imageFile
	 * @return
	 * @throws IOException
	 */
	public int getImageWidth(File imageFile) throws IOException{
		BufferedImage image = ImageIO.read(imageFile);
		return image.getWidth();
	}
	
	/**
	 * 返回图片的高度
	 * @param imageFile
	 * @return
	 * @throws IOException
	 */
	public int getImageHeight(File imageFile) throws IOException{
		BufferedImage image = ImageIO.read(imageFile);
		return image.getHeight();
	}
}
